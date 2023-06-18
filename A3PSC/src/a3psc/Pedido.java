package a3psc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pedido {
    /* ------------ ATRIBUTOS ------------ */
    private static final Connection con = Conexao.getConexao();                   // estabelecendo conexão com o BD
    private static int idPedidoAtivo;
    

    /* ------------ CONSTRUTOR ------------ */
    public Pedido(){}
    

    /* ------------- MÉTODOS ------------- */
    

    /* ------------------------------------
     * MÉTODOS: CRUD
     * abrir, cancelar, concluir, updates
     ---------------------------------------*/
    

    // MÉTODO: abrir/criar novo pedido --- ocorre ao abrir a aba de pedidos
    public static void abrirPedido(){
        String query = "INSERT INTO pedido (estado) VALUE (?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,"ABERTO");
            ps.execute();
            ps.close();
            setIdAtivo();
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // MÉTODO: cancelar/apagar pedido
    public static void cancelarPedido(){
        setIdAtivo();
        String query = "DELETE FROM pedido WHERE idPedido = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Pedido.idPedidoAtivo);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // MÉTODO: concluir pedido --- realizar alterações de estoque
    public static void concluirPedido(){
        setIdAtivo();
        String query1 = "SELECT * FROM pedidoproduto WHERE idPedido ="+Pedido.idPedidoAtivo;
        String query2 = "UPDATE produto SET qtde = ? WHERE idProd = ?";
        String query3 = "UPDATE pedido SET estado = 'CONCLUIDO' WHERE idPedido = ?";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query1);
            
            while(rs.next()){
                int idProd = rs.getInt("idProd");
                int qtde = ProdutoDAO.getQtde(idProd) - rs.getInt("qtdeProd");      // qtde atual - qtde q tava no pedido
                PreparedStatement ps = con.prepareStatement(query2);
                ps.setInt(1,qtde);
                ps.setInt(2,idProd);
                ps.execute();
                ps.close();
            }
               PreparedStatement ps = con.prepareStatement(query3);
               ps.setInt(1, idPedidoAtivo);
               ps.execute();
               ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    
    // MÉTODO: setar preçoTotal
    public static void setPrecoTotal(){
        setIdAtivo();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE pedido SET precoTotal = ? WHERE idPedido = ?");
            ps.setDouble(1, calcPreco());
            ps.setInt(2,Pedido.idPedidoAtivo);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // MÉTODO: adicionar produto
    public static void addProd(int idProd){
       setIdAtivo();
        boolean tem = temProd(idProd);
       if(!tem){
           String query = "INSERT INTO pedidoProduto (idPedido, idProd, qtdeProd) VALUES (?, ?, ?)";
           try {
               PreparedStatement ps = con.prepareStatement(query);
               ps.setInt(1,Pedido.idPedidoAtivo);
               ps.setInt(2,idProd);
               ps.setInt(3,1);
               ps.execute();
               ps.close();
           } catch (SQLException ex) {
               Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       else{
           int qtde = getQtde(idProd) + 1;
           String query = "UPDATE pedidoProduto SET qtdeProd = ? WHERE idPedido = ? AND idProd = ?";
           try {
               PreparedStatement ps = con.prepareStatement(query);
               ps.setInt(1,qtde);
               ps.setInt(2,Pedido.idPedidoAtivo);
               ps.setInt(3,idProd);
               ps.execute();
               ps.close();
           } catch (SQLException ex) {
               Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
           
       }     
    }
    
    
    // MÉTODO: remover produto
    public static void removeProd(int idProd){
        setIdAtivo();
        boolean tem = temProd(idProd);
        if(tem){
            if(getQtde(idProd)==1){
                try {
                    String query = "DELETE FROM pedidoProduto WHERE idPedido = ? AND idProd = ?";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setInt(1,Pedido.idPedidoAtivo);
                    ps.setInt(2,idProd);
                    ps.execute();
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                try {
                    int qtde = getQtde(idProd) - 1;
                    String query = "UPDATE pedidoProduto SET qtdeProd = ? WHERE idPedido = ? AND idProd = ?";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setInt(1,qtde);
                    ps.setInt(2,Pedido.idPedidoAtivo);
                    ps.setInt(3,idProd);
                    ps.execute();
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        }
        else if(!tem){
            System.out.println("o produto selecionado não está no carrinho");
        }
    }
    

    
    
    /* ------------------------------------
     * MÉTODOS: SUPORTE
     * setID, temProd, getQtde, calcPreço
     ---------------------------------------*/
    
    // MÉTODO: pegar id de pedido ativo
    private static void setIdAtivo(){
        String query = "SELECT idPedido FROM pedido WHERE idPedido = (SELECT MAX(idPedido) FROM pedido)";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()){
                Pedido.idPedidoAtivo = 0;
            }
            else{
                Pedido.idPedidoAtivo = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // MÉTODO: checar se já tem o produto na lista de produtos do pedido
    public static boolean temProd(int idProd){
        setIdAtivo();
        String query = "SELECT * FROM pedidoproduto WHERE idpedido = "+Pedido.idPedidoAtivo+" AND idprod ="+idProd; 
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            if (!rs.next()){
                return false;
            }
            else{
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    // MÉTODO: pegar a quantidade de um produto
    public static int getQtde(int idProd){
        setIdAtivo();
        String query = "SELECT qtdeProd FROM pedidoProduto WHERE idProd ="+idProd+" AND idPedido = "+Pedido.idPedidoAtivo;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                int qtde = rs.getInt(1);
                return qtde;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    // MÉTODO: calcular preço final
    public static double calcPreco(){
        setIdAtivo();
        String query = "SELECT * FROM pedidoproduto WHERE idPedido = "+Pedido.idPedidoAtivo;
        double precoTotal = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                int idProd = rs.getInt("idProd");
                int qtde = rs.getInt("qtdeProd");
                double preco = ProdutoDAO.getPreco(idProd);
                precoTotal = precoTotal + preco*qtde;
            }
            return precoTotal;
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    
}

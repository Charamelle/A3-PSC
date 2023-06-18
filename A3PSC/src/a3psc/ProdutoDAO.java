package a3psc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProdutoDAO extends Produto {
    
    /* ------------ ATRIBUTOS ------------ */
    private static int pos;
    private static Produto[] produtos = new Produto[600];
    private static Connection con = Conexao.getConexao();
    

    /* ------------ CONSTRUTOR ------------ */
    public ProdutoDAO(){}
    



    /*~~~ ÍNDICE : MÉTODOS ~~~*/
    /* crud: linha 31         */
    /* suporte: linha 292     */
    /* sincronizar: linha 415 */
    /*~~~~~~~~~~~~~~~~~~~~~~~~*/
  



    /* ------------------------------------
     * MÉTODOS: CRUD
     * criar, deletar e update em atributos
     ---------------------------------------*/

    // MÉTODO: criar/adicionar novo produto à loja                                
    public static void criarProduto(String setor, String cor, String estampa, int qtde){
        setPos();
        String sql = "INSERT INTO PRODUTO (NOMEPROD, SETOR, COR, TAMANHO, ESTAMPA, IDESTAMPA, QTDE, PRECO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int idEstampa = getIdEstampa(setor, estampa);        
        
        if(!checarProduto(setor, idEstampa, cor)){
            if (idEstampa != -1){
                for (int i = 0; i<3; i++){                                              
                    ProdutoDAO.pos++;
                    String tamanho = Produto.getTamanho(i);
                    produtos[pos] = new Produto(setor, cor, tamanho, idEstampa, estampa, qtde);

                    try {
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1,produtos[pos].nome);
                        ps.setString(2,produtos[pos].setor);
                        ps.setString(3,produtos[pos].cor);
                        ps.setString(4,produtos[pos].tamanho);
                        ps.setString(5,produtos[pos].estampa);
                        ps.setInt(6,produtos[pos].idEstampa);
                        ps.setInt(7,produtos[pos].qtde);
                        ps.setDouble(8,produtos[pos].preco);
                        ps.execute();

                        ps.close();                                                 // precisa sempre fechar no final, né mores
                    }
                    catch (SQLException ex) {
                        Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            System.out.println("Esse produto ja existe");
        }
    }
    
    
    // MÉTODO: criar uma nova estampa                                           
    public static void criarEstampa(String setor, String nomeEstampa){
        
        if (!checarEstampa(setor,nomeEstampa)){
            try { 
                String query = "INSERT INTO ESTAMPA (SETORESTAMPA, NOMEESTAMPA) VALUES (?, ?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, setor);
                ps.setString(2, nomeEstampa);
                ps.execute();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } else {
            System.out.println("Essa estampa ja existe");
        }
    }


    // MÉTODO: criar um novo setor                                           
    public static void criarSetor(String setor){
        
        if (!checarSetor(setor)){
            try { 
                String query = "INSERT INTO SETOR (nomesetor) VALUE (?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, setor);
                ps.execute();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } else {
            System.out.println("Esse setor ja existe");
        }
    }


    // MÉTODO: editar nome da estampa                                          
    public static void editaEstampa(int idEstampa, String estampaNova){
        String query1 = "UPDATE estampa SET nomeEstampa = ? WHERE idEstampa = ?";
        String query2 = "UPDATE produto SET estampa = ? WHERE idEstampa = ?;";
        try {
                PreparedStatement ps1 = con.prepareStatement(query1);
                ps1.setString(1,estampaNova);
                ps1.setInt(2,idEstampa);
                ps1.execute();

                PreparedStatement ps2 = con.prepareStatement(query2);
                ps2.setString(1,estampaNova);
                ps2.setInt(2,idEstampa);
                ps2.execute();
                
                sync();
                updateNome(idEstampa);
                
                ps1.close();                                                 
                ps2.close();                                                                                                  
            }
        catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    // MÉTODO: editar nome do setor                                            
    public static void editaSetor(String setor, String setorNovo){
        String query1 = "UPDATE setor SET nomeSetor = ? WHERE nomeSetor = ?";
        String query2 = "UPDATE estampa SET setorEstampa = ? WHERE setorEstampa = ?;";
        String query3 = "UPDATE produto SET setor = ? WHERE setor = ?;";
        try {
                PreparedStatement ps1 = con.prepareStatement(query1);
                ps1.setString(1,setorNovo);
                ps1.setString(2,setor);
                ps1.execute();

                PreparedStatement ps2 = con.prepareStatement(query2);
                ps2.setString(1,setorNovo);
                ps2.setString(2,setor);
                ps2.execute();
                
                PreparedStatement ps3 = con.prepareStatement(query3);
                ps3.setString(1,setorNovo);
                ps3.setString(2,setor);
                ps3.execute();
                
                sync();
                updateNome("setor");
                
                ps1.close();                                                 
                ps2.close();
                ps3.close();
            }
        catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // MÉTODO: editar quantidade                                             
    public static void editaQtde(int idProduto, int qtdeNova){
    String query = "UPDATE produto SET qtde = ? WHERE idProd = ?";
       try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1,qtdeNova);
                ps.setInt(2,idProduto);
                ps.execute();

                ps.close();                                               
            }
            catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    // MÉTODO: editar preço                                                     
    public static void editaPreco(int idProduto, int precoNovo){
    String query = "UPDATE produto SET preco = ? WHERE idProd = ?";
        try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1,precoNovo);
                ps.setInt(2,idProduto);
                ps.execute();

                ps.close();
                sync();
            }
            catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }


    // MÉTODO: deletar produto (vai apagar todos os tamanhos)                  
    public void delProd(int idProduto){
        String query1 = "SELECT * FROM produto WHERE idProd = "+idProduto;
        String query2 = "DELETE FROM PRODUTO WHERE setor = ? AND cor = ? AND idEstampa = ?";
        try {
            Statement stmt = con.createStatement();                                             // pegando as informações que determinam o produto
            ResultSet rs = stmt.executeQuery(query1);                                     // ^^ aí dá pra apagar todos os outros que são a msm camiseta,
            
            if(rs.next()){                                                                          // só que de tamanhos diferentes :)
                String setor = rs.getString("setor");
                String cor = rs.getString("cor");
                int idEstampa = rs.getInt("idEstampa");
            }
            PreparedStatement ps = con.prepareStatement(query2);
            ps.setString(1,setor);
            ps.setString(2,cor);
            ps.setInt(3,idEstampa);
            ps.execute();
            ps.close();                                              
            }
        catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    

    // MÉTODO: deletar estampa                                                  
    public void delEstampa(int idEstampa){
        String query1 = "SELECT idProd FROM produto WHERE idEstampa = "+idEstampa;
        String query2 = "DELETE FROM estampa WHERE idEstampa = ?";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query1);
            
            while(rs.next()){
                int idProd = rs.getInt(1);                                          // excluindo todos os produtos que usam essa estampa
                delProd(idProd);
            }
            
            PreparedStatement ps = con.prepareStatement(query2);
            ps.setInt(1,idEstampa);
            ps.execute();
            ps.close();                                              
            }
        catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // MÉTODO: deletar setor                                                    
    public void delSetor(String setor){
        String query1 = "SELECT idEstampa FROM estampa WHERE setorESTAMPA = '"+setor+"'";         // selecionar estampas do setor
        String query2 = "DELETE FROM produto WHERE setor = ?";                                    // deletar produtos do setor
        String query3 = "DELETE FROM setor WHERE nomeSetor = ?";                                  // deletar o setor em si
        
        try {
            Statement stmt1 = con.createStatement();
            ResultSet rs1 = stmt1.executeQuery(query1);
            while(rs1.next()){
                int idEstampa = rs1.getInt(1);
                delEstampa(idEstampa);
            }
            
            PreparedStatement ps1 = con.prepareStatement(query2);
            PreparedStatement ps2 = con.prepareStatement(query3);
            ps1.setString(1,setor);
            ps2.setString(1,setor);
            ps1.execute();
            ps2.execute();
            ps1.close();                                              
            ps2.close();                                              
            }
        catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    



    /* ------------------------------------
     * MÉTODOS: SUPORTE
     * verificar, get
     ---------------------------------------*/

    // MÉTODO: ver quantas camisetas já tem no sistema
    public static void setPos(){
        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT IDPROD FROM PRODUTO WHERE IDPROD = (SELECT MAX(IDPROD) FROM PRODUTO)");
            if (!rs.next()){
                ProdutoDAO.pos = 0;
            }
            else{
                ProdutoDAO.pos = rs.getInt(1);
            }
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // MÉTODO: verificar se o produto já existe (setor, idestampa, cor)
    public static boolean checarProduto(String setor, int idEstampa, String cor){
        String query = "SELECT * FROM PRODUTO WHERE setor = '"+setor+"' AND idEstampa = "+idEstampa+" AND cor = '"+cor+"'";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs.next();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
            return false;   
        }
    }
    
    
    // MÉTODO: verificar se a estampa já existe                                 
    public static boolean checarEstampa(String setor, String estampa){
        String query = "SELECT NOMEESTAMPA FROM ESTAMPA WHERE NOMEESTAMPA = '"+estampa+"' AND SETORESTAMPA = '"+setor+"'";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs.next();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
            return false;   
        }
    }
    
    // MÉTODO: verificar se a estampa já existe                                 
    public static boolean checarEstampa(int idEstampa){
        String query = "SELECT NOMEESTAMPA FROM ESTAMPA WHERE IDESTAMPA = '"+idEstampa+"'";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs.next();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
            return false;   
        }
    }
    
    // MÉTODO: pegar o ID da estampa                                            
    public static int getIdEstampa(String setor, String estampa){
        String query = "SELECT IDESTAMPA FROM ESTAMPA WHERE NOMEESTAMPA = '"+estampa+"' AND SETORESTAMPA = '"+setor+"'";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            int id = rs.getInt(1);
            
            return id;
        } 
        catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
    
    
    // MÉTODO: verificar se o setor já existe                                
    public static boolean checarSetor(String setor){
        String query = "SELECT NOMESETOR FROM SETOR WHERE NOMESETOR = '" + setor + "'";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs.next();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
            return false;   
        }
        
    }
    
    
    // MÉTODO: get preço
    public static double getPreco(int idProd){
        sync();
        return produtos[idProd].getPreco();
    }
   
    
    // MÉTODO: get qtde
    public static int getQtde(int idProd){
        sync();
        return produtos[idProd].getQtde();
    }




    /* ------------------------------------
     * MÉTODOS: SINCRONIZAR INFORMAÇÕES
     * sincronizar cm obj, atualizar mediante ação
     ---------------------------------------*/
    
    // MÉTODO: sincroniza todas as informações que estão no BD com os do objeto 
    public static void sync(){
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from produto");
            
            while(rs.next()){
                int id = rs.getInt("idProd");
                if(produtos[id] == null){
                    produtos[id] = new Produto();
                }
                
                produtos[id].nome = rs.getString("nomeProd");
                produtos[id].setor = rs.getString("setor");
                produtos[id].cor = rs.getString("cor");
                produtos[id].tamanho = rs.getString("tamanho");
                produtos[id].estampa = rs.getString("estampa");
                produtos[id].idEstampa = rs.getInt("idestampa");
                produtos[id].qtde = rs.getInt("qtde");
                produtos[id].preco = rs.getInt("preco");
                //System.out.println(produtos[id].toStringInfo());
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    
    // MÉTODO: atualizar nome do produto (quando altera a estampa)              
    private static void updateNome(int idEstampa){
        String query1 = "SELECT idProd FROM produto WHERE idEstampa = "+idEstampa;
        String query2 = "UPDATE produto SET nomeProd = ? WHERE idProd = ?";
        try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query1);                             // pegando quais são os produtos que vai precisar editar o nome
                
                while(rs.next()){
                    int id = rs.getInt("idProd");
                    String novoNome = produtos[id].gerarNome();
                    
                    PreparedStatement ps = con.prepareStatement(query2);
                    ps.setString(1,novoNome);
                    ps.setInt(2,id);
                    ps.execute();
                    ps.close(); 
                    
                }                                             
        }
        catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // MÉTODO: atualizar nome do produto (cor ou setor)                        
    private static void updateNome(String op){                                         // op = setor ou cor 
        String query1 = "";
        if (op == "setor"){
            query1 = "SELECT idProd FROM produto WHERE setor = "+op;
        }
        else if (op == "cor"){
            query1 = "SELECT idProd FROM produto WHERE  = "+op;
        }
        
        String query2 = "UPDATE produto SET nomeProd = ? WHERE idProd = ?";
        try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query1);                             // pegando quais são os produtos que vai precisar editar o nome
                
                while(rs.next()){
                    int id = rs.getInt("idProd");
                    String novoNome = produtos[id].gerarNome();
                    
                    PreparedStatement ps = con.prepareStatement(query2);
                    ps.setString(1,novoNome);
                    ps.setInt(2,id);
                    ps.execute();
                    ps.close(); 
                    
                }                                             
        }
        catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
}

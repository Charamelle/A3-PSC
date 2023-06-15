package a3psc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {
    /* ------------ ATRIBUTOS ------------ */
    private String usuario;
    private String senha;
    private static Connection con = Conexao.getConexao();                       // conectando com a database
    

    /* ------------ CONSTRUTOR ------------ */
    public Login(){}
    

    /* ------------ MÉTODOS ------------ */
        
    // MÉTODO: verificar se já tem alguém com aquele usuário                    
    private static boolean checarUsuario(String usuario){
        String query = "SELECT usuario FROM login WHERE usuario = '"+usuario+"'";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    
    // MÉTODO: verificar se o nome de usuário é permitido
    private static boolean usuarioOK(String usuario){
        char[]temp = usuario.toCharArray();
        if(temp.length<3){
            return false;
        } else{
        return true;
        }
        
    }
    
    
    // MÉTODO: cadastrar usuário                                                
    public static void cadastrar(String usuario, String senha){
        if (!checarUsuario(usuario) && usuarioOK(usuario)){
            String query = "INSERT INTO login (usuario, senha) VALUES (?,?)";
            
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,usuario);
                ps.setString(2, senha);
                ps.execute();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            if(checarUsuario(usuario)){System.out.println("nome de usuario ja em uso");}
            else{System.out.println("o nome de usuario deve conter ao menos 3 caracteres");}
        }
    }
    

    // MÉTODO: alterar senha
    public static void editarSenha(String usuario, String novaSenha){
        boolean existe = checarUsuario(usuario);
        
        if(existe){
            String query = "UPDATE login SET senha = ? WHERE usuario = ?";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,novaSenha);
                ps.setString(2,usuario);
                ps.execute();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("o nome de usuario informado nao esta cadastrado");
        }
        
    }

    
    // MÉTODO: alterar nome de usuário
    public static void editarUsuario(String usuario, String novoUsuario){
        boolean existe = checarUsuario(usuario);
        
        if(existe){
            String query = "UPDATE login SET usuario = ? WHERE usuario = ?";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, novoUsuario);
                ps.setString(2, usuario);
                ps.execute();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("o usuario informado nao esta cadastrado");
        }
        
    }


    // MÉTODO: deletar usuário
    public static void deletarUsuario(String usuario){
        boolean existe = checarUsuario(usuario);
        
        if(existe){
            String query = "DELETE FROM login WHERE usuario = ?";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, usuario);
                ps.execute();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        else{
            System.out.println("esse usuario nao existe");
        }
    }

    
    // MÉTODO: realizar login                                                   
    public static boolean login(String usuario, String senha){                  
        String query = "SELECT usuario FROM login WHERE usuario = '"+usuario+"' AND senha = '"+senha+"'";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                System.out.println("logando...");
                return true;
            }
            else{
                System.out.println("Usuario ou senha incorretos");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

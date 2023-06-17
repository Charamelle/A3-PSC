package a3psc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/a3psc";      // url de banco de dados - padrão
    private static final String user = "root";                                  // root - local
    /* ^ NÃO EDITAR ESSES DOIS DE CIMA ^ */
    
    private static final String password = "";  // É ESSE DAQUI QUE EDITA: coloca sua senha do root do mysql
    // obs. esse arquivo não eh mandado pro github, então não precisa tirar a senha toda vez que for dar commit no github :)
    

    /*~ criar a conexão ~*/
    private static Connection conn;
    
    /*~ método pra poder usar ela em outras classes ~*/
    public static Connection getConexao(){
        try {
            if (conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            } 
            else {
                return conn;
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


}

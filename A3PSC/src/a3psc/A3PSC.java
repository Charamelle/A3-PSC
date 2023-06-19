package a3psc;

public class A3PSC {


    public static void main(String[] args) {
        ProdutoDAO.resetBD();
        ProdutoDAO.setupBD();
        
       
        JanelaUsuario janela = new JanelaUsuario();
        janela.setVisible(true);
        
        
    } 
}

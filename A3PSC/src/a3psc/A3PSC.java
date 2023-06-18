package a3psc;

public class A3PSC {

    // só uma listinha de criação de setores, estampas e produtos pra preparar o bd pra testes
    private void setupDB(){
        // setores
        ProdutoDAO.criarSetor("MUSE");
        ProdutoDAO.criarSetor("MCR");
        ProdutoDAO.criarSetor("KISS");
        ProdutoDAO.criarSetor("ACDC");
        
        // estampas
        ProdutoDAO.criarEstampa("MUSE","UPRISING");
        ProdutoDAO.criarEstampa("MUSE","PSYCHO");
        ProdutoDAO.criarEstampa("MUSE","HYSTERIA");
        ProdutoDAO.criarEstampa("MCR","THE BLACK PARADE");
        ProdutoDAO.criarEstampa("KISS","DYNASTY");
        ProdutoDAO.criarEstampa("ACDC","HIGHWAY TO HELL");
        ProdutoDAO.criarEstampa("ACDC","BACK IN BLACK");
        
        // produtos
        double preco = Produto.precoBase;
        ProdutoDAO.criarProduto("MUSE","BRANCA","UPRISING",30,preco);
        ProdutoDAO.criarProduto("MUSE","PRETA","UPRISING",30,preco);
        ProdutoDAO.criarProduto("MUSE","PRETA","PSYCHO",70,preco);
        ProdutoDAO.criarProduto("MUSE","CINZA","HYSTERIA",35,preco);
        ProdutoDAO.criarProduto("MCR","BRANCA","THE BLACK PARADE",75,preco);
        ProdutoDAO.criarProduto("MCR","PRETA","THE BLACK PARADE",70,preco);
        ProdutoDAO.criarProduto("KISS","PRETA","DYNASTY",60,preco);
        ProdutoDAO.criarProduto("KISS","BRANCA","DYNASTY",60,preco);
        ProdutoDAO.criarProduto("ACDC","PRETA","HIGHWAY TO HELL",80,preco);
        ProdutoDAO.criarProduto("ACDC","VINHO","HIGHWAY TO HELL",80,preco);
        ProdutoDAO.criarProduto("ACDC","PRETA","BACK IN BLACK",70,preco);
        ProdutoDAO.criarProduto("ACDC","CINZA","BACK IN BLACK",70,preco);
    
    }
    
    
    public static void main(String[] args) {
        JanelaEstoque estq = new JanelaEstoque();
        estq.setVisible(true);
        
    } 
}
package a3psc;



public class Produto extends Estoque{
 
    /* ------------ ATRIBUTOS ------------ */
    private int idProduto;
    private String nomeProduto;
    // ^^ gerados automaticamente
    
    private static int lastID = 100;
    
    
    private String setorProduto;                                      // nome da banda
    private String corProduto;                                        // cor da camiseta
    private String tam;
    private int qtdeProduto;
 
    
    /* ------------ MÉTODO CONSTRUTOR ------------ */
    // Adicionar produtos
    public Produto(String setorProduto, String corProduto,String tam ){
        //this.idProduto = gerarID();
        this.nomeProduto = gerarNome(corProduto, setorProduto, tam);
        this.qtdeProduto = 0;
        
        System.out.println("Produto criado: " + this.nomeProduto);
    }
    
    public Produto(String setorProduto, String corProduto, String tam, int qtdeProduto){
        //this.idProduto = gerarID();;
        this.nomeProduto = gerarNome(corProduto, setorProduto, tam);
        this.qtdeProduto = qtdeProduto;
    }
    
    
    /* ------------ OUTROS MÉTODOS ------------ */
       
    public int gerarID(int pos, String tam,String setor){
        int numT = -1;
        switch(tam){
            case "P":
                numT = 0;
            case "M":
                numT = 1;
            case "G":
                numT = 2;
        }
        String temp = String.valueOf(Estoque.pos) + String.valueOf(numT) + String.valueOf(Estoque.getSetor(setor));
        int id = Integer.valueOf(temp);
        return id;
    }

    // PRECISA TERMINAR AQ
    public String gerarNome(String cor, String setor, String tam){
        String nome = "";
        nome = "CAMISETA " + setor.toUpperCase() + " ESTAMPA #" +  cor.toUpperCase() + " TAM " + tam.toUpperCase();
        return nome;
    }
    
    public int getIdProduto() {
        return idProduto;
    }

    public void alterarProduto(){      
    }

}

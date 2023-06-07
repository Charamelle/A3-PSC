package a3psc;



public class Produto{
 
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
        this.idProduto = gerarID();;
        this.nomeProduto = gerarNome(corProduto, setorProduto, tam);
        this.qtdeProduto = 0;
        
        System.out.println("Produto criado: " + this.nomeProduto);
    }
    
    public Produto(String setorProduto, String corProduto, String tam, int qtdeProduto){
        this.idProduto = gerarID();;
        this.nomeProduto = gerarNome(corProduto, setorProduto, tam);
        this.qtdeProduto = qtdeProduto;
    }
    
    
    /* ------------ OUTROS MÉTODOS ------------ */
       
    public int gerarID(){
        // por enquanto vai ficar assim, mas tava querendo fazer: 1a letra da banda + 
        lastID++;
        int id = lastID;
        return id;
    }

    public String gerarNome(String cor, String setor, String tam){
        String nome = "";
        nome = "CAMISETA " + setor.toUpperCase() + " " + cor.toUpperCase() + " TAM " + tam.toUpperCase();
        return nome;
    }
    
    

    public int getIdProduto() {
        return idProduto;
    }

    
    public void removerProduto(){
    }
    public void alterarProduto(){      
    }

}

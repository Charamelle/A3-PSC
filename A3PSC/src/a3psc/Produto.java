package a3psc;



public class Produto extends Estoque{
 
    /* ------------ ATRIBUTOS ------------ */
    private int idProduto;
    private String nomeProduto;
    // ^^ gerados automaticamente    
    private String setorProduto;                                      // nome da banda
    private String corProduto;                                        // cor da camiseta
    private String tam;                                               // P, M ou G
    private int qtdeProduto;
 
    
    /* ------------ MÉTODO CONSTRUTOR ------------ */
    // Adicionar produtos - MAS NA VDD EH PRA USAR O .ADDPRODUTO DO ESTOQUE
    public Produto(){}
    
    public Produto(String setorProduto, String corProduto,String tam ){
        this.tam = tam;
        this.idProduto = gerarID(tam, setorProduto);
        this.nomeProduto = gerarNome(corProduto, setorProduto, tam);
        this.qtdeProduto = 0;
        
        System.out.println("Produto criado: " + this.nomeProduto + "\nID: " + this.idProduto);
    }
    
    public Produto(String setorProduto, String corProduto, String tam, int qtdeProduto){
        this.idProduto = gerarID(tam, setorProduto);
        this.nomeProduto = gerarNome(corProduto, setorProduto, tam);
        this.qtdeProduto = qtdeProduto;
    }
    
    
    /* ------------ OUTROS MÉTODOS ------------ */
       
    public int gerarID(String tam,String setor){
        int numT = -1;
        int id = 0;
        
        if (tam == "P"){                // por algum motivo o switch case nn tava funcionando (tava fazendo cm se todas fossem G)
            numT = 1;
        } else if (tam == "M"){
            numT = 2;
        } else if (tam == "G"){
            numT = 3;
        }
  
        id = Estoque.pos*100 + numT*10 + Estoque.getSetor(setor);
        return id;
    }

    // PRECISA TERMINAR ESSA PARTE AQ
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

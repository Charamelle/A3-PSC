package a3psc;

/* ---------- FUNÇÕES QUE PRECISA FAZER ----------
 * add Produto
 * > gerar ID auto                  OK
 * > gerar nome auto                OK
 * alterar produto
 * > nome do produto, preço e qtde
 * remover produto
 */


public class Produto extends Estoque{
 
    /* ------------ ATRIBUTOS ------------ */
    private int idProduto;
    private String nomeProduto;
    // ^^ gerados automaticamente    
    private String setorProduto;                                      // nome da banda
    private String corProduto;                                        // cor da camiseta
    private String tam;                                               // P, M ou G
    private String estampa;                                           // nome da estampa (dá pra mudar)
    private int idEstampa;                                            // id da estampa daquele setor (imutável)
    private int qtdeProduto;
 
    
    /* ------------ MÉTODO CONSTRUTOR ------------ */
    // Pra adicionar produtos, é pra usar o método addProduto do Estoque
    public Produto(){}
    
    public Produto(String setorProduto, String corProduto, int idEstampa, String tam ){
        this.tam = tam;
        this.estampa = super.getEstampa(setorProduto, idEstampa);
        this.idProduto = gerarID(tam, setorProduto);
        this.nomeProduto = gerarNome(corProduto, setorProduto, tam);
        this.qtdeProduto = 0;
        System.out.println("Produto criado: " + this.nomeProduto + "\nID: " + this.idProduto);
    }
    
    /* ------------ OUTROS MÉTODOS ------------ */
    
    // MÉTODO: gerar automaticamente o código identificador do produto
    public int gerarID(String tam,String setor){
        int numT = -1;
        int id = 0;
        
        if (tam == "P"){                         // por algum motivo o switch case não tava funcionando (tava dando como se todas fossem G) então foi de if else mesmo 
            numT = 1;
        } else if (tam == "M"){
            numT = 2;
        } else if (tam == "G"){
            numT = 3;
        }
  
        id = numT + super.pos*10 ;               // ID: POS na lista de produtos + TAMANHO (é o que precisa pra localizar a instância de "Produto" na lista)
        return id;
    }

    // MÉTODO: gerar automaticamente o nome do produto
    public String gerarNome(String cor, String setor, String tam){
        String nome = "CAMISETA " + setor.toUpperCase() + " " + this.estampa.toUpperCase() + " " + cor.toUpperCase() + " TAM " + tam.toUpperCase();
        return nome;
    }
    

}

package a3psc;

/* ---------- FUNÇÕES QUE PRECISA FAZER ----------
 * add Produto                                       OK
 * > gerar ID auto                                   OK
 * > gerar nome auto                                 OK
 * alterar produto                                   OK
 * > nome (da estampa) do produto, preço e qtde      OK
 * remover produto                              
 */


public class Produto extends Estoque{
 
    /* ------------ ATRIBUTOS ------------ */
    private String idProduto;
    private String nomeProduto;
    // ^^ gerados automaticamente    
    private String setorProduto;                                      // nome da banda
    private String corProduto;                                        // cor da camiseta
    private String tam;                                               // P, M ou G
    private String estampa;                                           // nome da estampa (dá pra mudar)
    private int idEstampa;                                            // id da estampa daquele setor (imutável)
    private int qtdeProduto;
    private double preco;
    private static double precoBase = 40;                             // produtos ao serem criados vão ter esse preço
 
    
    /* ------------ MÉTODO CONSTRUTOR ------------ */
    // Pra adicionar produtos, é pra usar o método addProduto do Estoque
    public Produto(){}
    
    // Criar produto sem declarar quantidades (qtde zerada)
    public Produto(String setorProduto, String corProduto, int idEstampa, String tam ){
        this.setorProduto = setorProduto;                                                           // setar o setor/banda
        this.corProduto = corProduto;                                                               // setar a cor
        this.tam = tam;                                                                             // setar tamanho
        this.estampa = super.getEstampa(setorProduto, idEstampa);                                   // setar NOME da estampa
        this.idEstampa = Estoque.idEstampa;                                                         // setar ID da estampa
        this.idProduto = gerarID(tam, setorProduto);                                                // gerar automaticamente o ID do produto
        this.nomeProduto = gerarNome(corProduto, setorProduto, tam);                                // gerar automaticamente o nome do produto
        this.preco = Produto.precoBase;
        this.qtdeProduto = 0;                                                                      

        System.out.println("Produto criado: " + this.nomeProduto + "\nID: " + this.idProduto+"\nID da estampa: "+ this.idEstampa);      // APAGAR DEPOIS: só pra testes
    }

    // Criar produto declarando as quantidades iniciais
    public Produto(String setorProduto, String corProduto, int idEstampa, String tam, int qtdeProduto){
        this.setorProduto = setorProduto;                                                           // setar o setor/banda
        this.corProduto = corProduto;                                                               // setar a cor
        this.tam = tam;                                                                             // setar tamanho
        this.estampa = super.getEstampa(setorProduto, idEstampa);                                   // setar NOME da estampa
        this.idEstampa = Estoque.idEstampa;                                                         // setar ID da estampa
        this.idProduto = gerarID(tam, setorProduto);                                                // gerar automaticamente o ID do produto
        this.nomeProduto = gerarNome(corProduto, setorProduto, tam);                                // gerar automaticamente o nome do produto
        this.preco = Produto.precoBase;
        this.qtdeProduto = qtdeProduto;                                                            

        System.out.println("Produto criado: " + this.nomeProduto + "\nID: " + this.idProduto+"\nID da estampa: "+ this.idEstampa);      // APAGAR DEPOIS: só pra testes
    }
    

    /* ------------ OUTROS MÉTODOS ------------ */
    
    // MÉTODO: gerar automaticamente o código identificador do produto
    public String gerarID(String tam,String setor){
        int numT = -1;
        
        if (tam == "P"){                         // pegando o número referente ao tamanho da camiseta
            numT = 0;                            // por algum motivo o switch case não tava funcionando (tava dando como se todas fossem G) então foi de if else mesmo
        } else if (tam == "M"){
            numT = 1;
        } else if (tam == "G"){
            numT = 2;
        }
  
        String id = Estoque.pos + "#" + numT + "#" + super.getSetor(setor) + "#" + this.idEstampa;              // ID: POS na lista de produtos + TAMANHO (é o que precisa pra localizar a instância de "Produto" na lista)
        return id;                                                                                              // + SETOR + IDESTAMPA
    }

    // MÉTODO: gerar automaticamente o nome do produto
    public String gerarNome(String cor, String setor, String tam){
        String nome = "CAMISETA " + setor.toUpperCase() + " " + this.estampa.toUpperCase() + " " + cor.toUpperCase() + " TAM " + tam.toUpperCase();
        return nome;
    }
    
    // MÉTODO: alterar preço base
    public static void precoBase(int novoPreco){
        Produto.precoBase = novoPreco;
    }

    
    /* ------------ MÉTODOS SUPORTE ------------ */
    // OS MÉTODOS DAQUI PRA BAIXO SÃO SÓ PRA SEREM USADOS NA CLASSE ESTOQUE (QUE É A CLASSE CHEFE)


    // MÉTODO: alterar preço do produto
    public void editaProduto(double novoPreco){
        this.preco = novoPreco;
    }

    // MÉTODO: alterar quantidade do produto (set)
    public void editaProduto(int novaQtde){
        this.qtdeProduto = novaQtde;
    }

    // MÉTODO: alterar quantidade do produto (add ou remove 1)
    public void editaProduto(char operacao){
        switch(operacao){
            case '+':
            this.qtdeProduto++;
            case '-':
            this.qtdeProduto--;
        }
    }

    // MÉTODO: alterar nome da estampa do produto
    public void editaProduto(String novaEstampa){
        this.estampa = novaEstampa;
        this.nomeProduto = gerarNome(this.corProduto, this.setorProduto, this.tam);
    }


    // MÉTODO: limpar dados/desativar produto
    public void deletarProduto(){
        this.idProduto = null;
        this.nomeProduto = this.nomeProduto + " PRODUTO INDISPONÍVEL";
        this.qtdeProduto = 0;
    }

    // MÉTODOS: GETTERS
    public String getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getSetorProduto() {
        return setorProduto;
    }

    public String getCorProduto() {
        return corProduto;
    }

    public String getTam() {
        return tam;
    }

    public String getEstampa() {
        return estampa;
    }

    public int getIdEstampa() {
        return idEstampa;
    }

    public int getQtdeProduto() {
        return qtdeProduto;
    }

    public double getPreco() {
        return preco;
    }

    
}

package a3psc;

public class Estoque {
    /* --------- ATRIBUTOS --------- */
    protected static Produto [][] produtos = new Produto[100][3];            // produtos ativos x tamanhos
    protected static String [][] setores = new String[20][20];               // setores x estampas
    protected static int pos = 1;                                            // indica a última posição em produtos[][]
    protected static int numSetor = 1;                                       // quantidade de setores/bandas que tem
    protected static int idEstampa;

    
    
    /* ------- MÉTODO CONSTRUTOR ------- */
    public Estoque(){
        setores[0][0] = "#";                                                  // pra que no ID setores seja != 0 (e funcionar direitinho)
    }
    
    
    
    /* -------- MÉTODOS: CRIAR PRODUTOS -------- */
    
    // CRIAR PRODUTO: nova estampa, sem declarar quantidades
    public void addProduto(String setor, String cor){                         
        temSetor(setor);                                                      // checa se o produto é de um setor já existente ou novo
        setEstampa(setor);
        Estoque.produtos[pos][0] = new Produto(setor,cor,Estoque.idEstampa,"P");
        Estoque.produtos[pos][1] = new Produto(setor,cor,Estoque.idEstampa,"M");            // já cria 3 produtos (um de cada tamanho)
        Estoque.produtos[pos][2] = new Produto(setor,cor,Estoque.idEstampa,"G");
        pos++;                                                                // pra mover +1 pos na lista de produtos/pra nn sobrescrever

    }

    // CRIAR PRODUTO: estampa já existente (também tem certeza que o setor já existe), sem declarar quantidades
    public void addProduto(String setor, int idEstampa, String cor){                         
        Estoque.idEstampa = idEstampa;
        Estoque.produtos[pos][0] = new Produto(setor,cor,Estoque.idEstampa,"P");
        Estoque.produtos[pos][1] = new Produto(setor,cor,Estoque.idEstampa,"M");            // já cria 3 produtos (um de cada tamanho)
        Estoque.produtos[pos][2] = new Produto(setor,cor,Estoque.idEstampa,"G");
        pos++;                                                                // pra mover +1 pos na lista de produtos/pra nn sobrescrever

    }
    

    /* -------- OUTROS MÉTODOS -------- */

    // MÉTODO: pesquisar se o setor do produto cadastrado já existe
    public void temSetor(String setor){
        
        boolean igual = false;
        for (int i = 0; i<setores.length;i++){
                if (setor.equalsIgnoreCase(setores[i][0])){
                    igual = true;                                             // se já existir o setor do produto: para de procurar por ele                                        
                    break;                                                    // ^-----^-----^-----^-----^-----^-----^-----^-----^-----^
                }
        }
        if(igual == false){                                                   // caso não encontrar a banda/setor do produto (novo setor):
            Estoque.setores[numSetor][0] = setor.toUpperCase();               // cria um novo setor, com o nome do setor do produto cadastrado (tudo em letras maiúsculas)
            Estoque.numSetor++;                                               // adiciona mais 1 no contador de número de bandas
        }
    }
    

    // MÉTODO: pegar o # do setor
    public static int getSetor(String setor){
        int numSetor = -1;                                                   // só um número inicial que com certeza não é o número de um setor de verdade
        for (int i = 0; i<setores.length; i++){
            if (setores[i] != null){
                if (setor.equalsIgnoreCase(setores[i][0])){
                    numSetor = i;                                            // acha o número do setor
                    break;
                }
            }
        }
        return numSetor;
    }


    // MÉTODO: setar o id e nome da estampa nova
    public void setEstampa(String setor){
        int idEstampa = -1;
        
        for (int i = 1;i<20;i++){
            if (setores[getSetor(setor)][i] == null){
                Estoque.setores[getSetor(setor)][i] = "ESTAMPA #"+Integer.toString(i);          // seta o nome da estampa (pode mudar dps)
                Estoque.idEstampa = i;                                                          // seta o ID da estampa (imutável - atributo do produto)
                break;
            }
        }

        System.out.println("id estampa FINAL: "+idEstampa);
    }


    // MÉTODO: pegar o nome da estampa
    public String getEstampa(String setor, int idEstampa){
        return Estoque.setores[getSetor(setor)][Estoque.idEstampa];                         // nome por default é só o número, mas pode mudar
    }


    // MÉTODO: listar todos os setores cadastrados (mais pra testes)
    public void listarSetores(){
        System.out.println("Setores: ");
        for (int i = 0; i<setores.length;i++){
            if (setores[i] == null){                                                  // pra ele não sair printando nullnullnullnull...
                break;  
            }
            else{
                System.out.print(setores[i]+" ");
            }
        }
        
    }
    

}       

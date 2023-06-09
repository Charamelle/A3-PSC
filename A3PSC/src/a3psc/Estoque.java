package a3psc;

public class Estoque {
    /* --------- ATRIBUTOS --------- */
    public static Produto [][] produtos = new Produto[100][3];            // produtos ativos x tamanhos
    protected static String [][] setores = new String[20][20];               // setores x estampas
    protected static int pos = 1;                                            // indica a última posição em produtos[][]
    protected static int qtdeSetor = 1;                                       // quantidade de setores/bandas que tem
    protected static int idEstampa;

    
    
    /* ------- MÉTODO CONSTRUTOR ------- */
    public Estoque(){
        setores[0][0] = "#";                                                  // pra que no ID setores seja != 0 (e funcionar direitinho)
    }
    
    
    
    /* -------- MÉTODOS: CRIAR PRODUTOS -------- */
    
    // CRIAR PRODUTO: nova estampa, sem declarar quantidades
    public void addProduto(String setor, String cor){                         
        temSetor(setor);                                                                        // checa se o produto é de um setor já existente ou novo
        setEstampa(setor);
        Estoque.produtos[pos][0] = new Produto(setor,cor,Estoque.idEstampa,"P");
        Estoque.produtos[pos][1] = new Produto(setor,cor,Estoque.idEstampa,"M");            // já cria 3 produtos (um de cada tamanho)
        Estoque.produtos[pos][2] = new Produto(setor,cor,Estoque.idEstampa,"G");
        pos++;                                                                                  // pra mover +1 pos na lista de produtos/pra nn sobrescrever

    }

    // CRIAR PRODUTO: nova estampa, declarando quantidades
    public void addProduto(String setor, String cor, int qtdeProdutoP, int qtdeProdutoM, int qtdeProdutoG){                         
        temSetor(setor);                                                                        // checa se o produto é de um setor já existente ou novo
        setEstampa(setor);
        Estoque.produtos[pos][0] = new Produto(setor,cor,Estoque.idEstampa,"P", qtdeProdutoP);
        Estoque.produtos[pos][1] = new Produto(setor,cor,Estoque.idEstampa,"M", qtdeProdutoM);            // já cria 3 produtos (um de cada tamanho)
        Estoque.produtos[pos][2] = new Produto(setor,cor,Estoque.idEstampa,"G", qtdeProdutoG);
        pos++;                                                                                  // pra mover +1 pos na lista de produtos/pra nn sobrescrever

    }

    // CRIAR PRODUTO: estampa já existente (também tem certeza que o setor já existe), sem declarar quantidades
    public void addProduto(String setor, int idEstampa, String cor){                         
        Estoque.idEstampa = idEstampa;
        temSetor(setor);
        setEstampa(setor, idEstampa);                                                                   // definir estampa da camiseta
        Estoque.produtos[pos][0] = new Produto(setor,cor,Estoque.idEstampa,"P");
        Estoque.produtos[pos][1] = new Produto(setor,cor,Estoque.idEstampa,"M");                    // já cria 3 produtos (um de cada tamanho)
        Estoque.produtos[pos][2] = new Produto(setor,cor,Estoque.idEstampa,"G");
        pos++;                                                                                          // pra mover +1 pos na lista de produtos/pra nn sobrescrever

    }

    // CRIAR PRODUTO: estampa já existente (também tem certeza que o setor já existe), declarando quantidades
    public void addProduto(String setor, int idEstampa, String cor, int qtdeProdutoP, int qtdeProdutoM, int qtdeProdutoG){                         
        Estoque.idEstampa = idEstampa;
        temSetor(setor);
        setEstampa(setor, idEstampa);                                                                   // definir estampa da camiseta
        Estoque.produtos[pos][0] = new Produto(setor,cor,Estoque.idEstampa,"P", qtdeProdutoP);
        Estoque.produtos[pos][1] = new Produto(setor,cor,Estoque.idEstampa,"M", qtdeProdutoM);      // já cria 3 produtos (um de cada tamanho)
        Estoque.produtos[pos][2] = new Produto(setor,cor,Estoque.idEstampa,"G", qtdeProdutoG);
        pos++;                                                                                          // pra mover +1 pos na lista de produtos/pra nn sobrescrever

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
            Estoque.setores[qtdeSetor][0] = setor.toUpperCase();               // cria um novo setor, com o nome do setor do produto cadastrado (tudo em letras maiúsculas)
            Estoque.qtdeSetor++;                                               // adiciona mais 1 no contador de número de bandas
        }
    }
    

    // MÉTODO: pegar o # do setor
    public static int getSetor(String setor){
        int numSetor = -5;                                                   // só um número inicial que com certeza não é o número de um setor de verdade
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
        for (int i = 1;i<20;i++){
            if (setores[getSetor(setor)][i] == null){
                Estoque.setores[getSetor(setor)][i] = "ESTAMPA #"+Integer.toString(i);          // seta o nome da estampa (pode mudar dps)
                Estoque.idEstampa = i;                                                          // seta o ID da estampa (imutável - atributo do produto)
                break;
            }
        }
    }

    // MÉTODO: setar a estampa quando já tem o ID
    public void setEstampa(String setor, int idEstampa){
        Estoque.idEstampa = idEstampa;
        if (Estoque.setores[getSetor(setor)][idEstampa] == null){
            Estoque.setores[getSetor(setor)][idEstampa] = "ESTAMPA #"+Integer.toString(idEstampa);
        }
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
    
    // MÉTODO: pegar alguma informação (pos, tam, setor ou estampa) pelo ID do produto
    // LEMBRETE: FAZER TRATAMENTO DE EXCESSÃO AQUI!!!
    // cpa fazer algo pra caso colocar um ID inválido tbm (?)
    public int getFromID(String info, String idProduto){
        info = info.toUpperCase();
        String temp [] = idProduto.split("#");
        switch(info){
            case "POS":
                return Integer.parseInt(temp[0]);
            case "TAM":
                return Integer.parseInt(temp[1]);
            case "SETOR":
                return Integer.parseInt(temp[2]);
            case "ESTAMPA":
                return Integer.parseInt(temp[3]);
            default:
                return -1;
        }
    }

    // MÉTODO: editar o nome da estampa
    public void editarEstampa(String idProduto, String novaEstampa){ 
        int setor = getFromID("setor", idProduto);
        int estampa = getFromID("estampa", idProduto);

        Estoque.setores[setor][estampa] = novaEstampa;

        for (int i = 1; i < produtos.length; i++){
            if (produtos[i][0] != null){
                if(produtos[i][0].getIdEstampa() == estampa && produtos[i][0].getSetorProduto().equalsIgnoreCase(setores[setor][0])){
                    produtos[i][0].editaProduto(novaEstampa);
                    produtos[i][1].editaProduto(novaEstampa);
                    produtos[i][2].editaProduto(novaEstampa);
                }
             }
        }



    }

    // MÉTODO: editar a quantidade de um produto (set)
    public void setQtde(String idProduto, int novaQtde){
        Estoque.produtos[getFromID("pos", idProduto)][getFromID("tam", idProduto)].editaProduto(novaQtde);
    }

    // MÉTODO: editar a quantidade de um produto (add 1)
    public void addQtde(String idProduto){
        Estoque.produtos[getFromID("pos", idProduto)][getFromID("tam", idProduto)].editaProduto('+');
    }

    // MÉTODO: editar a quantidade de um produto (remove 1)
    public void removeQtde(String idProduto){
        Estoque.produtos[getFromID("pos", idProduto)][getFromID("tam", idProduto)].editaProduto('-');
    }

    // MÉTODO: alterar o preço de um produto (muda o preço de todos os tamanhos e cores)
    public void editaPreco(String idProduto, double novoPreco){
        int setor = getFromID("setor", idProduto);                              // só pra ficar mais fácil de visualizar
        int estampa = getFromID("estrampa", idProduto);                         // ^----^----^----^----^----^----^----^

        for (int i = 1; i < produtos.length; i++){
            if (produtos[i][0] != null){
                if(produtos[i][0].getIdEstampa() == estampa && produtos[i][0].getSetorProduto().equalsIgnoreCase(setores[setor][0])){       // vai mudar de todos os produtos que têm a mesma estampa
                    produtos[i][0].editaProduto(novoPreco);
                    produtos[i][1].editaProduto(novoPreco);
                    produtos[i][2].editaProduto(novoPreco);
                }
             }
        }
        
    }
}       

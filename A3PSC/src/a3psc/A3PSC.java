package a3psc;

import java.util.Scanner;

public class A3PSC {

    
    public static void main(String[] args) {
        
        //int idProduto, String nomeProduto, int quantidadeProduto 
        Scanner sc = new Scanner(System.in);
        Estoque Estoque = new Estoque();
        
        // testes
            
        Estoque.addProduto("kiss", 1, "preta");
        Estoque.addProduto("kiss", 2, "branca");
        Estoque.addProduto("melanie", 1, "branca");
            //for (int i=0;i<3;i++){
            System.out.println("setor:");
            String setor = sc.nextLine();

            System.out.println("cor:");
            String cor = sc.nextLine();
            
            System.out.println("estampa: ");
            int idEstampa = sc.nextInt();

            Estoque.addProduto(setor, idEstampa, cor);
            //}
            

    } 
}






/* -------- COISAS DE TESTE -------- */
        /*
        Produto[] produtos = new Produto[2];
        Produto teste1= new Produto(1, "Blusa", 2);
        Produto teste2= new Produto(2, "Blusa2", 2);
        produtos[0]= teste1;
        produtos[1]= teste2;

        System.out.println("Bem-vindo a loja de camisetas de bandas de rock!");
        System.out.println("Deseja ver as opcoes de camisetas disponiveis? (s/n)");
        char resposta= sc.next().charAt(0);
        if (resposta== 'S' || resposta== 's'){
            Produto.exibirProdutos(produtos);
        }
        else{
           System.out.println("Programa encerrado:"); 
        }
        System.out.println("Deseja comprar algum item? (s/n)");
     while (resposta== 'S' || resposta== 's'){
     boolean id_existe;
         System.out.println("Digite o ID do produto que deseja comprar: [0] para parar a compra");
    int id = sc.nextInt();
    if (id==0){
        break;
    }
    for(int i=0;i<produtos.length;i++){
        if (produtos[i].getIdProduto() == id) {
            id_existe = true;
            System.out.println("Produto adicionado");
            break;
        }
        else{
            System.out.println("Id invalido");
        }
    }
     }
     */ 
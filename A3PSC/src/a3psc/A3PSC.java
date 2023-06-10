package a3psc;

import java.util.Scanner;

public class A3PSC {

    
    public static void main(String[] args) {
        
        //int idProduto, String nomeProduto, int quantidadeProduto 
        Scanner sc = new Scanner(System.in);
        Estoque Estoque = new Estoque();
        
        // testes
            
        Estoque.addProduto("kiss", 1, "preta");
        System.out.println(Estoque.produtos[1][0].getSetorProduto());
        Estoque.getFromID("pos", "1#1#1#1");
        //Estoque.editarEstampa("1.1.1.1", "cu");
            /*for (int i=0;i<3;i++){
            System.out.println("setor:");
            String setor = sc.nextLine();

            System.out.println("cor:");
            String cor = sc.nextLine();
            

            Estoque.addProduto(setor, cor);
            }*/
            

    } 
}
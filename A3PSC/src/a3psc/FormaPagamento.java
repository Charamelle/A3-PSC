package a3psc;

import java.util.Scanner;


public class FormaPagamento extends Pedido{
    Scanner sc = new Scanner(System.in);
    
/*public FormaPagamento(int idProduto,String nomeProduto,int quantidadeProduto,int idPedido,float orcamento, int idFormPgto, String formaPgto){
super(idProduto,nomeProduto,quantidadeProduto, idPedido, orcamento);
}*/

public void escolheForma(){
    double total = getOrcamento();
    System.out.println("Valor da compra: " + total);
    System.out.println("Escolha o metodo de pagamento:");
    System.out.println("1- Cartao de Credito");
    System.out.println("2- Dinheiro");
    int op = sc.nextInt();

if(op==2){
System.out.println("Digite o valor para pagar a compra:");
double valor = sc.nextDouble();

if (total < valor){
double troco = (valor-total);
    System.out.println("Troco: " + troco);
    System.out.println("Compra realizada com sucesso");
} else if (total > valor){
    System.out.println("Saldo insuficiente");
} else{
    System.out.println("Compra realizada com sucesso");
}
} else if (op == 1){
    System.out.println("Digite a senha:");
String senha= sc.next();
    System.out.println("Compra realizada com sucesso");
} else{
    System.out.println("Opção inválida");
}
}

}

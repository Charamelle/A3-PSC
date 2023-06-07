/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loja.de.roupas;

/**
 *
 * @author anapb
 */
public class Produto{
 private int idProduto;
 private String nomeProduto;
 private int quantidadeProduto;
 
 public Produto(int idProduto, String nomeProduto, int quantidadeProduto){
     this.idProduto=idProduto;
     this.nomeProduto=nomeProduto;
     this.quantidadeProduto=quantidadeProduto;
 }
    public int getIdProduto(){
        return idProduto;
    }

    public void setIdProduto(int idProduto){
        this.idProduto = idProduto;
    }

    public String getNomeProduto(){
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidadeProduto(){
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto){
        this.quantidadeProduto = quantidadeProduto;
    }
      public static void exibirProdutos(Produto[] produtos){
        for(int i=0;i<produtos.length;i++){
        Produto produto = produtos[i];
            System.out.println("ID:" + produto.getIdProduto());
            System.out.println("Nome:" + produto.getNomeProduto());
            System.out.println("Quantidade:" + produto.getQuantidadeProduto());
            System.out.println();
    }
      }
            
    public void adicionarProduto(){       
    }
    public void removerProduto(){
    }
    public void alterarProduto(){      
    }
         
}

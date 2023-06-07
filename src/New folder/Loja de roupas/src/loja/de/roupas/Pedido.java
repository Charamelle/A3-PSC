/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loja.de.roupas;

/**
 *
 * @author anapb
 */
public class Pedido extends Produto{
    private int idPedido;
    private float orcamento;
     public Pedido(int idProduto, String nomeProduto, int quantidadeProduto, int idPedido, float orcamento){
        super(idProduto,nomeProduto,quantidadeProduto);
        this.idPedido=idPedido;
        this.orcamento=orcamento;
    }
    public int getIdPedido(){
        return idPedido;
    }

    public void setIdPedido(int idPedido){
        this.idPedido = idPedido;
    }

    public float getOrcamento(){
        return orcamento;
    }

    public void setOrcamento(float orcamento){
        this.orcamento = orcamento;
    }
    public double calculaTotal(){
        return orcamento;
    }
    
    public void fechaPedido(){
        
    }
    @Override
    public void adicionarProduto(){
        
    }
    @Override
    public void removerProduto(){
        
    }
}

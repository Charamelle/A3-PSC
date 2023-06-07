package a3psc;


public class Pedido{

    /* -------- ATRIBUTOS -------- */
    private int idPedido;
    private float orcamento;
    
    /* -------- MÉTODO CONSTRUTOR -------- */
    public Pedido(){}
     
     
    /* -------- OUTROS MÉTODOS -------- */
     
    public int getIdPedido(){
        return idPedido;
    }

    public void setIdPedido(int idPedido){
        this.idPedido = idPedido;
    }

    public float getOrcamento(){
        return orcamento;
    }

    public double calculaTotal(){
        return orcamento;
    }
    
    public void fechaPedido(){}

    public void adicionarProduto(){}

    public void removerProduto(){}
}
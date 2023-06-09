package a3psc;

/* ----------- FUNÇÕES QUE PRECISA TER -----------
* abrir pedido
> cpa só criar
* editar pedido
* > produtos, qtdes
* concluir pedido
* cancelar pedido
*/


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
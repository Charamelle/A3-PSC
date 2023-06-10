package a3psc;

/* ----------- FUNÇÕES QUE PRECISA TER -----------
* abrir pedido                          OK
* add produto
* editar quantidade de cada produto
* remover produto
* selecionar a forma de pagamento
* concluir pedido
* cancelar pedido
*/


public class Pedido{

    /* -------- ATRIBUTOS -------- */
    private String idPedido;                    // numPedido#cliente --> Ex. 100#0
    private int idCliente;                      // se 0 = cliente não cadastrado
    private double orcamento;                   // valor total a ser pago
    private String produtosPedido[][];          // id produto x qtde
    private static int numPedidos = 0;          // número total de pedidos (incluindo cancelados)
    private String status;                      // se o pedido tá aberto/concluído/cancelado
    
    /* -------- MÉTODO CONSTRUTOR -------- */
    // abrir pedidos
    public Pedido(){                                        // cliente não cadastrado
        this.idCliente = 0;
        this.idPedido = gerarIdPedido(this.idCliente);
        this.orcamento = 0;
    }

    public Pedido(int idCliente){                           // cliente cadastrado
        this.idCliente = idCliente;
        this.idPedido = gerarIdPedido(this.idCliente);
        this.orcamento = 0;
    }     
    /* -------- OUTROS MÉTODOS -------- */
    
    // MÉTODOS: criar id
     public String gerarIdPedido(int idCliente){
        Pedido.numPedidos++;
        String id = (Pedido.numPedidos) + "#" + idCliente;
        return id;
    }








    // MÉTODOS: getters
    public double getOrcamento(){
        return orcamento;
    }
    
}
package a3psc;

/* --- O QUE PRECISA TER ---
 * cadastrar novo                               OK
 * > gerar ID (número que vai incrementando)    OK
 * remover
 * ver pedidos
 */

public class Cliente extends Pessoa {
    /* --------- ATRIBUTOS --------- */
    private int idCliente;
    private String [] pedidos;
    private static int qtdeCliente = 0;

    /* ------- MÉTODOS CONSTRUTORES ------- */
    public Cliente(String nome, long cpf,String dataNascimento, String endereco, long telefone){
        super(nome, cpf, dataNascimento, endereco, telefone);
        this.idCliente = gerarIdCliente();
    }

    /* -------- OUTROS MÉTODOS -------- */

    public int gerarIdCliente(){
        Cliente.qtdeCliente++;
        return Cliente.qtdeCliente;
    }
}

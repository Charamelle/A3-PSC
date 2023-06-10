package a3psc;
/* --- OQ PRECISA TER ---
 * cadastrar novo
 * > gerar ID (pode ser só um número que vai incrementando)
 * remover
 * alterar dados
 * 
 */
public class Empregado extends Pessoa{
    
    /* --------- ATRIBUTOS --------- */
    private String idEmpregado;
    private String usuario;
    private String senha;
    private static int qtdeEmpregado;

    /* ------- MÉTODOS CONSTRUTORES ------- */
    public Empregado(String nome, long cpf,String dataNascimento, String endereco, long telefone, String usuario, String senha){
        super(nome, cpf, dataNascimento, endereco, telefone);
        this.usuario = usuario;
        this.senha = senha;
    }
    /* -------- OUTROS MÉTODOS -------- */
}

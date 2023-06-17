package a3psc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produto {
    
    /* ------------ ATRIBUTOS ------------ */
    protected int id;
    protected String nome;
    // ^^ gerados automaticamente    
    protected String setor;                                         // nome da banda
    protected String cor;                                           // cor da camiseta
    protected String tamanho;                                       // P, M ou G
    protected String estampa;                                       // nome da estampa (dá pra mudar)
    protected int idEstampa;                                        // id da estampa daquele setor (imutável)
    protected int qtde;
    protected double preco;
    protected static double precoBase = 40;   
    
    
    /* ------------ CONSTRUTORES ------------ */
    protected Produto(){}

    // Criar produto -- protegido pra que só dê pra criar pela ProdutoDAO
    protected Produto(String setor, String cor, String tamanho, int idEstampa, String estampa, int qtde){
        this.setor = setor;
        this.cor = cor;
        this.tamanho = tamanho;
        this.estampa = estampa;
        this.idEstampa = idEstampa;
        this.qtde = qtde;
        this.preco = precoBase;
        this.nome = gerarNome();
    }
    
    /* -------------- MÉTODOS -------------- */
    
    // MÉTODO: gerar automaticamente o nome do produto
    protected String gerarNome(){
        String nome = "CAMISETA " + this.setor.toUpperCase() + " " + this.estampa.toUpperCase() + " " + this.cor.toUpperCase() + " TAM " + this.tamanho.toUpperCase();
        return nome;
    }
     
    
    // MÉTODO: pegar o tamanho da camiseta - pra criação
    protected static String getTamanho(int i){
        return switch (i) {
            case 0 -> "P";
            case 1 -> "M";
            case 2 -> "G";
            default -> "#";
        };
    }
    
    // MÉTODO: pra poder printar a info
    protected String toStringInfo(){
        String txt = "Nome: " + this.nome + "\nSetor: " + this.setor + "\nCor: "+this.cor+"\nTamanho: "+this.tamanho+"\nEstampa: "+this.estampa+" (ID: "+this.idEstampa+")\nQuantidade: "+this.qtde+"\nPreco: "+this.preco+"\n----+---";
        return txt;
    }
    
    // MÉTODO: get preço
    protected double getPreco(){
        return this.preco;
    }
    
    // MÉTODO: get qtde
    protected int getQtde(){
        return this.qtde;
    }
}

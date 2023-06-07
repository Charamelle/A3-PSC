package a3psc;

public class Estoque {
     /* --------- ATRIBUTOS --------- */
        private static  Produto [][] produtos = new Produto[100][3];            // lista de produtos ativos 
        private static int pos = 1;
        
     /* ------- MÉTODO CONSTRUTOR ------- */
        public Estoque(){}
        
     /* -------- OUTROS MÉTODOS -------- */
        public void addProduto(String setor, String cor){
            this.produtos[pos][0] = new Produto(setor,cor,"P");
            this.produtos[pos][1] = new Produto(setor,cor,"M");
            this.produtos[pos][2] = new Produto(setor,cor,"G");
        }

}       

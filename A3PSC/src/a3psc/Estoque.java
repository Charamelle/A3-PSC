package a3psc;

public class Estoque {
     /* --------- ATRIBUTOS --------- */
        private static  Produto [][] produtos = new Produto[100][3];            // lista de produtos ativos 
        private static  String [] bandas = new String[20];
        protected static int pos = 1;
        private static int numBandas = 0;
        
        
     /* ------- MÉTODO CONSTRUTOR ------- */
        public Estoque(){}
        
        
     /* -------- OUTROS MÉTODOS -------- */
        public void addProduto(String setor, String cor){
            this.produtos[pos][0] = new Produto(setor,cor,"P");
            this.produtos[pos][1] = new Produto(setor,cor,"M");
            this.produtos[pos][2] = new Produto(setor,cor,"G");
            temSetor(setor);
        }
        
        public void temSetor(String setor){
            boolean igual = false;
            for (int i = 0; i<bandas.length;i++){
                    if (setor.equalsIgnoreCase(bandas[i])){
                        igual = true;
                        break;
                    }
            }
            if(igual == false){
                this.bandas[numBandas] = setor.toUpperCase();
                this.numBandas++;
            }
        }
        
        public static int getSetor(String setor){
            int numSetor = -1;
            
            for (int i = 0; i<bandas.length; i++){
                if (bandas[i] != null){
                    if (setor.equalsIgnoreCase(bandas[i])){
                        numSetor = i;
                        break;
                    }
                }
            }
            
            return numSetor;
        }
        
        public void listarSetores(){
            System.out.println("Setores: ");
            for (int i = 0; i<bandas.length;i++){
                if (bandas[i] == null){
                    break;
                }
                else{
                    System.out.print(bandas[i]+" ");
                }
            }
          
        }
        
        public int getPos(){
            return this.pos;
        }
}       

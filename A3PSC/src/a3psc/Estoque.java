package a3psc;

public class Estoque {
     /* --------- ATRIBUTOS --------- */
        public static  Produto [][] produtos = new Produto[100][3];            // lista de produtos ativos 
        private static  String [] setores = new String[20];
        protected static int pos = 1;
        private static int numBandas = 1;
        
        
     /* ------- MÉTODO CONSTRUTOR ------- */
        public Estoque(){
            setores[0] = "#";
        }
        
        
     /* -------- OUTROS MÉTODOS -------- */
        public void addProduto(String setor, String cor){
            temSetor(setor);
            this.produtos[pos][0] = new Produto(setor,cor,"P");
            this.produtos[pos][1] = new Produto(setor,cor,"M");
            this.produtos[pos][2] = new Produto(setor,cor,"G");
            pos++;
   
        }
        
        public void temSetor(String setor){
            
            boolean igual = false;
            for (int i = 0; i<setores.length;i++){
                    if (setor.equalsIgnoreCase(setores[i])){
                        igual = true;
                        break;
                    }
            }
            if(igual == false){
                this.setores[numBandas] = setor.toUpperCase();
                this.numBandas++;
            }
        }
        
        public static int getSetor(String setor){
            int numSetor = -1;
            
            for (int i = 0; i<setores.length; i++){
                if (setores[i] != null){
                    if (setor.equalsIgnoreCase(setores[i])){
                        numSetor = i;
                        break;
                    }
                }
            }
            
            return numSetor;
        }
        
        public void listarSetores(){
            System.out.println("Setores: ");
            for (int i = 0; i<setores.length;i++){
                if (setores[i] == null){
                    break;
                }
                else{
                    System.out.print(setores[i]+" ");
                }
            }
          
        }
        
        public int getPos(){
            return this.pos;
        }
}       

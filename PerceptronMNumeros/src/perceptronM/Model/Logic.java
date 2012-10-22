
package perceptronM.Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import perceptronM.Common.Matriz;
import perceptronM.GUI.GUI;

/**
 *
 * @author PRETXEL-H
 * @author imarban
 */
public class Logic {
    
//      La estructura de la red es:
//      W1 = [20x40]
//      b1 = [20x1]
//      W2 = [10x20]
//      b2 = [1x10]
//      a0 = [40x1]
//      a1 = [20x1]
//      a2 = [10x1]
    
    
    private float W1[][] = new float[Const.TotalPatrones/2][Const.TotalPatrones];
    private float b1[][] = new float[Const.TotalPatrones/2][1];
    private float W2[][] = new float[Const.TotalPatrones/4][Const.TotalPatrones/2];
    private float b2[][] = new float[Const.TotalPatrones/4][1];
    private float a1[][];
    private float a2[][];
    private float s2[][] = new float[Const.TotalPatrones/4][1];
    private float s1[][] = new float[Const.TotalPatrones/2][1];
    private float errorRMS[][] = new float[Const.TotalDigitos][1];
    public static boolean aprendio = false;
    public static int aciertos_Fijos = 0;
    private float resul[][];
    private float error[][][] = new float[Const.NumJuegos*10][Const.TotalPatrones/4][1];
    private short aciertos = 0;
    public static int NumEpocas = 0;
    
    private String CLASSNAME = Logic.class.getName();
    
    public Logic(){
        //this.pesos=Const.pesosFijo;   
        //this.b2=Const.umbralFijo;
                
    }
    
    public void setAciertos(short ac){
        this.aciertos = ac;
    }
    
    public short getAciertos(){
        return this.aciertos;
    }
    
    public float[][] getUmbral_b1(){
        return b1;
    }
    
    public float[][] getUmbral_b2(){
        return b2;
    }
    
    public float[][] getPesos_w1(){
        return W1;
    }
    
     public float[][] getPesos_w2(){
        return W2;
    }
     
    public void setB(float b[][]){
        this.b2 = b;
    }
    
    public void setPesos(float w1[][], float w2[][]){
        this.W1 = w1;
        this.W2 = w2;
    }
    
    public  void init(){
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Init Generator Pesos y b\n");
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
        Random generator = new Random();
        
        //Inicializa el Peso W1
        for(int i=0;i<Const.TotalPatrones/2;i++){
            for(int j=0;j<Const.TotalPatrones;j++){
                W1[i][j] = generator.nextFloat();
            }
        }
        
         //Inicializa el Peso W2
        for(int i=0;i<Const.TotalPatrones/4;i++){
            for(int j=0;j<Const.TotalPatrones/2;j++){
                W2[i][j] = generator.nextFloat();
            }
        }
        
         //Inicializa el Umbral b1
        for(int i=0;i<Const.TotalPatrones/2;i++){
            b1[i][0] = generator.nextFloat();
        }
        
         //Inicializa el Umbral b2
        for(int i=0;i<Const.TotalPatrones/4;i++){
            b2[i][0] = generator.nextFloat();
        }
    }
    
    
    //inicia Entrenamiento
    public void train(){
        
        int count = 0;
        int numTotalEpoch = 1;
        
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Train\n");
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
       
        
        
        while(Const.epoch>0){
        
            //Realiza todas las propagaciones hacia adelante y guarda los errores
            for (int i=0;i<Const.NumJuegos*Const.TotalDigitos;i++){
      
                    propagacion_adelante(i);
            }
            //Calcula el error cuadratico medio de los 30 errores
            RMS();
            
            //Verifica si el error cumple con el error objetivo
             if (verificaError() == false){
                        //Calcula las sensibilidades
                        retropropagacion();
                        //Actualiza los pesos y los umbrales
                        W2 = updatePesos_W2();
                        b2 = updateB2();
                        W1 = updatePesos_W1();
                        b1 = updateB1();
                    }else{
                        aprendio = true;
                        break;
                    }
        
        Const.epoch--;
        numTotalEpoch++;
        }
        
        Mostrar_Resultados(numTotalEpoch); 
        NumEpocas = numTotalEpoch;
    }
    
    //Muestra los Resultados en el Logger
    public void Mostrar_Resultados(int epoch){
        
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Mostrar Resultados\n");
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Aprendio: ").append(aprendio).append("\n");
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Num de Epocas: ").append(epoch).append("\n");
        
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Matriz de Pesos W1: \n");
        for (int i=0;i<W1.length;i++){
            for(int j=0;j<W1[0].length;j++){
                Const.LogTexto.append(W1[i][j]).append(" - ");
            }
            Const.LogTexto.append("\n");
        }
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        
         Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Matriz de Umbral b1: \n");
        for (int i=0;i<b1.length;i++){
            for(int j=0;j<b1[0].length;j++){
                Const.LogTexto.append(b1[i][j]).append(" - ");
            }
            Const.LogTexto.append("\n");
        }
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        
         Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Matriz de Pesos W2: \n");
        for (int i=0;i<W2.length;i++){
            for(int j=0;j<W2[0].length;j++){
                Const.LogTexto.append(W2[i][j]).append(" - ");
            }
            Const.LogTexto.append("\n");
        }
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        
         Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Matriz de Umbral b2: \n");
        for (int i=0;i<b2.length;i++){
            for(int j=0;j<b2[0].length;j++){
                Const.LogTexto.append(b2[i][j]).append(" - ");
            }
            Const.LogTexto.append("\n");
        }
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        
          Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Matriz de Errores Cuadraticos Medios: \n");
        for (int i=0;i<errorRMS.length;i++){
            for(int j=0;j<errorRMS[0].length;j++){
                Const.LogTexto.append(errorRMS[i][j]).append(" - ");
            }
            Const.LogTexto.append("\n");
        }
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        
        
    }
    
    //Metodo que Realiza la propagacion hacia adelante de todos los numeros
    public void propagacion_adelante(int index){
        Matriz.zeros(error[0]);
        if (index >= 0 && index < 10)
        {
            float en[][] = Matriz.copy(Const.entradas_1, index);
            a1 = logsig(Matriz.suma(Matriz.producto(W1, en),b1));
            a2 = Matriz.suma(Matriz.producto(W2, a1),b2);      
        //float a2[][] = Matriz.producto(W2, a2)
            error[index] = error(Const.target_1, a2, index);
        }else if (index >=10 && index <20){
            float en[][] = Matriz.copy(Const.entradas_2, (index-10));
            a1 = logsig(Matriz.suma(Matriz.producto(W1, en),b1));
            a2 = Matriz.suma(Matriz.producto(W2, a1),b2);      
        //float a2[][] = Matriz.producto(W2, a2)
            error[index] = error(Const.target_2, a2, (index-10));
        }else{
            float en[][] = Matriz.copy(Const.entradas_3, (index-20));
            a1 = logsig(Matriz.suma(Matriz.producto(W1, en),b1));
            a2 = Matriz.suma(Matriz.producto(W2, a1),b2);      
        //float a2[][] = Matriz.producto(W2, a2)
            error[index] = error(Const.target_3, a2, (index-20));
        }
        
    }
    
    //Metodo que raliza la retropropagacion y calcula las sensibilidades
    public void retropropagacion(){
        
        for(int i=0;i<Const.TotalDigitos;i++){
            s2[i][0] = -2 * 1 * errorRMS[i][0]; 
         }
        
        float iden[][] = Matriz.identidad(a1);
        s1=Matriz.producto(Matriz.producto(Matriz.producto(Matriz.producto(Matriz.resta(1, a1),a1), iden), Matriz.transpuesta(W2)), s2);
        //s1 = Matriz.producto(Matriz.producto(iden, Matriz.transpuesta(W2)),s2);
    }
    
    //Metodo  que calcula el error medio cuadratico
    public void RMS(){
        float sum;
            for(int j=0;j<Const.TotalDigitos;j++){
              sum=0f;
                for (int i=0;i<Const.TotalDigitos*Const.NumJuegos;i++){
                
                    //sum = (float) (sum + Math.exp(error[i][j][0]));
                    sum = (float) (sum + Math.pow(error[i][j][0],2));
            }
            //errorRMS[j][0] = (float) (sum/Const.TotalDigitos);
            errorRMS[j][0] = (float) (sum/Const.TotalDigitos*Const.NumJuegos);
        }
        
    }
    
    
    public float[][] error (float t[][], float a[][], int numero){
        return Matriz.resta(t, a, numero);
    }
    
    
    public float[][] hardlim(float a[][]){
        float res[][] = new float[a.length][1];
        for(int i=0;i<a.length;i++){
            //System.out.println("Resultado antes de ser evaluado"+a[i][0]);
            if (a[i][0] >= 0){
                res[i][0] = 1;
            }else if (a[i][0] < 0){
                res[i][0] = 0;
            }
        }
        return res;
    }
    
    //Metodo que calcula la función logsig
    public float[][] logsig(float a[][]){
        float res[][] = new float[a.length][1];
        for(int i=0;i<a.length;i++){
            //System.out.println("Resultado antes de ser evaluado"+a[i][0]); 
                res[i][0] = (float) (1/(1+Math.exp(a[i][0])));
        }
        return res;
    }
    
    //Metodo que verifica si el error cumple con lo deseado
    public boolean verificaError(){
        boolean flag = false;
        short ve = 0;
        for(int i=0;i<Const.TotalDigitos;i++){
            if(errorRMS[i][0] <= Const.errorObjt){
                ve++;
            }
        }
        
        if (ve == Const.TotalDigitos){
            flag = true;
        }
        
        return flag;
    }
    
    public boolean verificaError(float a[][]){
        boolean flag = true;
        for(int i=0;i<a.length;i++){
            double b=Math.sqrt(Math.pow(((double)a[i][0]),2));
            if (b>Const.errorObjt){
                flag = false;
                break;
            }
        }
        return flag;
    }

    //Metodo que actualiza el Peso W2
    public float[][] updatePesos_W2(){
        
        return Matriz.resta_M(W2,Matriz.producto(Matriz.producto_escalar(s2, Const.alpha),Matriz.transpuesta(a1)));
         
    }
    
    //Metodo que Actualiza el Peso W1
    public float[][] updatePesos_W1(){
        
        int numJuego = (int) Math.floor(Math.random()*4);
        int numPatron = (int) Math.floor(Math.random()*10);
        float a0[][];
        
        if (numJuego == 0){
            a0 = Matriz.copy(Const.entradas_1, numPatron);
        }else if (numJuego == 1){
            a0 = Matriz.copy(Const.entradas_2, numPatron);
        }else{
            a0 = Matriz.copy(Const.entradas_3, numPatron);
        }
        
        return Matriz.resta_M(W1, Matriz.producto(Matriz.producto_escalar(s1, Const.alpha),Matriz.transpuesta(a0)));
         
    }
    
    //Metodo que actualiza el umbral b2
    public float[][] updateB2(){
        return Matriz.resta_M(b2,Matriz.producto_escalar(s2, Const.alpha));
    }
    
    //Metodo que actualiza el umbral b1
    public float[][] updateB1(){
        return Matriz.resta_M(b1,Matriz.producto_escalar(s1, Const.alpha));
    }
    
    
    public  void Test(){
            float en[][];
            float eval[][];
            float sh[][];
            float sf[][];
            
            Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Evaluar\n");
            
            
            for (int i=0; i<Const.entradas_1[0].length;i++){
                Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Evaluar Numero : ").append(Const.numeros[i]).append("\n"); 
                en = Matriz.copy(Const.entradas_1, i);
                sh = logsig(Matriz.suma(Matriz.producto(W1, en),b1));
                sf = Matriz.suma(Matriz.producto(W2, sh),b2);
                
                for(int j=0;j<sf.length;j++){
                    //System.out.println(eval[i][0]+"\n");
                    Const.LogTexto.append(sf[j][0]).append("\n");
                    
                }
                
            }
  
            GUI.txtLogger.append(Const.LogTexto.toString());
            Const.LogTexto.setLength(0);
            //Const.Log(Const.LogTexto.toString());
    }
    
    
    public int TestGrid(float p[][]){
        float en[][], fn[][];
        en = logsig(Matriz.suma(Matriz.producto(W1, p),b1));
        fn = Matriz.suma(Matriz.producto(W2, en),b2);
        /*for(int i=0;i<fn.length;i++)
            for(int j=0;j<fn[0].length;j++)
              System.out.println("Salida "+ fn[i][j]);*/
        
        for(int i=0;i<Const.target_1.length;i++){
            if(verificaError(Matriz.resta(Const.target_1, fn, i))){
                return i;
            }
        }  
         for(int j=0;j<Const.target_2.length;j++){
            if(verificaError(Matriz.resta(Const.target_2, fn,j))){
                return j;
            }
         }
            
         for(int k=0;k<Const.target_3.length;k++){
            if(verificaError(Matriz.resta(Const.target_3, fn, k))){
                return k;
            }
        }
        
      return -1; 
    }

    
     public float[][] TestGrid2(float p[][]){
        float en[][], fn[][];
        en = logsig(Matriz.suma(Matriz.producto(W1, p),b1));
        fn = Matriz.suma(Matriz.producto(W2, en),b2);
        return fn;
    }
     
    /*
     public boolean fijarValores_Properties() throws FileNotFoundException, IOException{
        //Propiedades props=new Propiedades("fijos.properties");
         
         Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Write Values Properties\n");
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
         
         Propiedades p = new Propiedades("fijos.properties");
         p.abrirPropiedad();
        for(int i=0;i<Const.TotalDigitos;i++){
             for(int j=0;j<(Const.ROW_COUNT*Const.ROW_COUNT);j++){
                p.cambiarPropiedad("pesosFijo["+i+"]["+j+"]", String.valueOf(pesos[i][j]));
             }
        }
        for(int i=0;i<Const.TotalDigitos;i++){
            p.cambiarPropiedad("umbralFijo["+i+"][0]", String.valueOf(b[i][0]));
        }
        
        p.cerrarPropiedad();
        return true;
     }
     */
     /*
     public void Evalua(){
         int index_vocal;
         int aciertos_eval = 0;
         float pr[][] = new float[Const.ROW_COUNT*Const.ROW_COUNT][1];
                 
         for(int i=0;i<Const.getMaxSet();i++){
            
            for(int u=0;u<Const.ROW_COUNT*Const.ROW_COUNT;u++){
             pr[u][0] = Test.pesos[u][i];
        }
        
            index_vocal = TestGrid(pr);
            
            if(index_vocal>=0){
        //Const.LogTexto.append(Const.LogDate()+" "+CLASSNAME+" - Letra Detectada: "+Const.vocales[index_vocal]+"\n");
        //Const.LogTexto.append(Const.LogDate()+" "+CLASSNAME+" - target: "+Test.targets[i]+"\n");
        if (Test.targets[i] == Const.abecedario[index_vocal]){
            //Const.LogTexto.append(Const.LogDate()+" "+CLASSNAME+" - Acierto \n");
            aciertos_eval++;
        }
        
        //Draw_Grid(2);
        //System.out.println("Letra detectada: "+Const.abecedario[TestGrid(pr)]);
        //Const.LogTexto.append(Const.LogDate()+" "+CLASSNAME+" - Dibujar en Grid_Out\n");
        //Draw_Grid(index_vocal);
        }//else {
            float ap[][] = TestGrid2(pr);
            //System.out.println("Salida Hardlim ");
            //Const.LogTexto.append(Const.LogDate()+" "+CLASSNAME+"- Salida Hardlim: \n");
            //for(int j=0;j<ap.length;j++){
                //System.out.println(ap[j][0]);
                //Const.LogTexto.append(ap[j][0] +"\n");
                
            //}
        //}
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
            
            
        }
         
         Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" ------------Aciertos Valores Fijos  : ").append(aciertos_eval).append(" / ").append(Const.getMaxSet()).append("---------\n");
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        aciertos_Fijos = aciertos_eval;
     }
     */
}

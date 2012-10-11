
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
    
    private float pesos[][] = new float[Const.TotalAbecedario][Const.ROW_COUNT*Const.ROW_COUNT];
    private float b[][] = new float[Const.TotalAbecedario][1];
    public static boolean aprendio = false;
    public static int aciertos_Fijos = 0;
    private float resul[][];
    private float error[][];
    private short aciertos = 0;
    
    
    private String CLASSNAME = Logic.class.getName();
    
    public Logic(){
        this.pesos=Const.pesosFijo;   
        this.b=Const.umbralFijo;
                
    }
    
    public void setAciertos(short ac){
        this.aciertos = ac;
    }
    
    public short getAciertos(){
        return this.aciertos;
    }
    
    public float[][] getUmbral(){
        return b;
    }
    
     public float[][] getPesos(){
        return pesos;
    }
    
    public void setB(float b[][]){
        this.b = b;
    }
    
    public void setPesos(float pe[][]){
        this.pesos = pe;
    }
    
    public  void init(){
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Init Generator Pesos y b\n");
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
        //Const.Log(Const.LogTexto.toString());
        Random generator = new Random();
        for(int i=0;i<Const.TotalAbecedario;i++){
            for(int j=0;j<(Const.ROW_COUNT*Const.ROW_COUNT);j++){
                pesos[i][j] = generator.nextFloat();
            }
        }
        
        for(int i=0;i<Const.TotalAbecedario;i++){
            b[i][0] = generator.nextFloat();
        }
    }
    
    public void train(){
        
        float en[][]; 
        int count = 0;
        int numTotalEpoch = 1;
        
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Train\n");
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        //Const.Log(Const.LogTexto.toString());
        
        
        while(Const.epoch>0){
        count = 0;
            Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - ****Epoca**** : ").append(numTotalEpoch).append("\n");
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        //Const.Log(Const.LogTexto.toString());
        
        for (int i=0;i<Const.entradas[0].length;i++){
            en = Matriz.copy(Const.entradas, i);
            resul = Matriz.producto(pesos, en);
            resul = Matriz.suma(resul, b);
        
    
        resul = hardlim(resul);
        //System.out.println("Hardlim"+ resul.toString());
        
        error = error(Const.target, resul, i);
                Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Error\n");
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
        //Const.Log(Const.LogTexto.toString());
       
        
        if (verificaError(error)==false){
            System.out.println("VerificaError"); 
            pesos = updatePesos(pesos, error, Matriz.transpuesta(en));
            //System.out.println("UpdatePesos");
            b = updateB(b, error);
            //System.out.println("UpdateB");
                    Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - UpdatePesos, UpdateB\n");
             GUI.txtLogger.append(Const.LogTexto.toString());
             Const.LogTexto.setLength(0);
            //Const.Log(Const.LogTexto.toString());
        }else{
            count++;
                    Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Verificar True\n");
             GUI.txtLogger.append(Const.LogTexto.toString());
             Const.LogTexto.setLength(0);
            //Const.Log(Const.LogTexto.toString());
        }
        
        }
        
        if (count == Const.entradas[0].length){
            aprendio = true;
            break;
        }
        
        Const.epoch--;
        numTotalEpoch++;
        }
        
       // System.out.println("Aprendio = "+aprendio);
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Aprendio = ").append(aprendio).append("\n");
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
        //Const.Log(Const.LogTexto.toString());
        
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Pesos: \n");
        for (int k=0;k<pesos.length;k++){
            Const.LogTexto.append("[ "); 
            for(int j=0;j<pesos[0].length;j++){
                    Const.LogTexto.append(pesos[k][j]).append(", ");
            }
            Const.LogTexto.append(" ]"); 
            Const.LogTexto.append("\n");
        }
        
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - b: \n");
        
       for (int j=0;j<b.length;j++){
            Const.LogTexto.append(b[j][0]).append("\n");
           
       } 
        
        
        
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
        //Const.Log(Const.LogTexto.toString());

       
    
    
    }
    
    
    public float[][] error (float t[][], float a[][], int letra){
        return Matriz.resta(t, a, letra);
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
    
    public boolean verificaError(float a[][]){
        boolean flag = true;
        for(int i=0;i<a.length;i++){
            if(a[i][0]!=0){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public float[][] updatePesos(float pesos[][], float error[][], float trans[][]){
        return Matriz.suma(Matriz.producto(error, trans),pesos);
    }
    
    public float[][] updateB(float b[][], float error[][]){
        return Matriz.suma(b, error);
    }
    
    
    public  void Test(){
            float en[][];
            float eval[][];
            
            Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Evaluar\n");
            
            
            for(int j=0;j<Const.entradas[0].length;j++){
            Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Evaluar Letra : ").append(Const.abecedario[j]).append("\n");  
            en = Matriz.copy(Const.entradas, j);
            eval = hardlim(Matriz.suma(Matriz.producto(pesos, en),b));
                for(int i=0;i<eval.length;i++){
                    //System.out.println(eval[i][0]+"\n");
                    Const.LogTexto.append(eval[i][0]).append("\n");
                    
                }
            
            }
            GUI.txtLogger.append(Const.LogTexto.toString());
            Const.LogTexto.setLength(0);
            //Const.Log(Const.LogTexto.toString());
    }
    
    
    public int TestGrid(float p[][]){
        float en[][];
        en = hardlim(Matriz.suma(Matriz.producto(pesos, p),b));
        /*for(int i=0;i<en.length;i++)
            for(int j=0;j<en[0].length;j++)
                System.out.println("Salida "+ en[i][j]);*/
        
        for(int i=0;i<Const.target.length;i++){
            if(verificaError(Matriz.resta(Const.target, en, i))){
                return i;
            }
        }
        
      return -1; 
    }
    
    
     public float[][] TestGrid2(float p[][]){
        
        return hardlim(Matriz.suma(Matriz.producto(pesos, p),b));
    }
     
     public boolean fijarValores_Properties() throws FileNotFoundException, IOException{
        //Propiedades props=new Propiedades("fijos.properties");
         
         Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Write Values Properties\n");
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
         
         Propiedades p = new Propiedades("fijos.properties");
         p.abrirPropiedad();
        for(int i=0;i<Const.TotalAbecedario;i++){
             for(int j=0;j<(Const.ROW_COUNT*Const.ROW_COUNT);j++){
                p.cambiarPropiedad("pesosFijo["+i+"]["+j+"]", String.valueOf(pesos[i][j]));
             }
        }
        for(int i=0;i<Const.TotalAbecedario;i++){
            p.cambiarPropiedad("umbralFijo["+i+"][0]", String.valueOf(b[i][0]));
        }
        
        p.cerrarPropiedad();
        return true;
     }
     
     
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
     
}


package perceptronM.Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import perceptronM.GUI.GUI;
import perceptronM.GUI.Testing;

/**
 *
 * @author PRETXEL-H
 */
public class Test {
    
    public static int pesos[][] = new int[Const.ROW_COUNT*Const.ROW_COUNT][Const.getMaxSet()];
    public static char targets[] = new char[Const.getMaxSet()];
    public static int patron[][] = new int[Const.ROW_COUNT*Const.ROW_COUNT][1];
    public static short index = 0;
    public static String CLASSNAME = Test.class.getName();
    
    
    public static int getValorActualSet(Propiedades p)
    {
            int max;
           // if(p.cargarPropiedades()){
                try{
                    max=p.leerPropiedad_Int("max");
                    return max;
                }catch (Exception e){
                    max=0;
                    return max;
                }
            /*}
            else
                max=0;
            return max;*/
    }
    
    
    public static void fijarPatrones_Properties(){
        
        Const.LogTexto.append(Const.LogDate()).append(CLASSNAME).append(" Escribe Set Pruebas\n");
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);   
        try {
            Propiedades p = new Propiedades("SetPruebas.properties");
                if(!p.existeArchivo())
                        p.abrirPropiedad();
                p.cargarPropiedades();
                int max=Const.getMaxSet();
                for(int k=0, n=k+max;k<index;k++, n=k+max){
                    
                    for(int h=0;h<Const.ROW_COUNT*Const.ROW_COUNT;h++){
                        p.cambiarPropiedad("entradasSet["+h+"]["+n+"]", String.valueOf(Test.pesos[h][k]));
                    }
                }
                                
                for(int g=0, n=g+max;g<index;g++, n=g+max){
                    p.cambiarPropiedad("VocalSet["+n+"]", String.valueOf(Test.targets[g]));
                }
            p.abrirPropiedad();
            p.cerrarPropiedad();
            Const.setMaxSet(index+max);
        } catch (IOException ex) {
            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void obtenerPatrones_Properties(){
        
        Const.LogTexto.append(Const.LogDate()).append(CLASSNAME).append(" Carga Set Pruebas\n");
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        int max=Const.getMaxSet();
        
        Propiedades p = new Propiedades("ArchivosConf\\SetPruebas.properties");
        
        if(p.cargarPropiedades()){
            for(int i=0;i<max;i++)
                for(int j=0;j<(Const.ROW_COUNT*Const.ROW_COUNT);j++)
                    pesos[j][i] =p.leerPropiedad_Int("entradasSet["+j+"]["+i+"]");

            for(int i=0;i<max;i++)
                targets[i] = p.leerPropiedad_Char("VocalSet["+i+"]");
        }
        else{
            JOptionPane.showConfirmDialog(null, "Error al cargar el archivo de propiedades" ,"ERROR",JOptionPane.PLAIN_MESSAGE,0);
        }
        
        
    }
    
    
    public static void imprime(){
        
        for(int i=0;i<Const.getMaxSet();i++){
            
            for(int j=0;j<Const.ROW_COUNT*Const.ROW_COUNT;j++){
                System.out.print(pesos[j][i]+", ");
                
            }
            System.out.println("\n");
            System.out.println(targets[i]);
            System.out.println("\n");
        }
    }
    
    public static void Eval_Pesos() throws FileNotFoundException, IOException{
        int index_vocal;
        Muestras m = null; 
        Logic l = null;
        int aciertos = 0;
        int aux_acie = 0;
        short ind_pesos = 0;
        float pr[][] = new float[Const.ROW_COUNT*Const.ROW_COUNT][1];
        
        
        
        for(int i=0;i<10;i++){
        m = GUI.stack.get(i);
        l = m.getLogic();
        
        aciertos = 0;
        
        for (int f=0;f<Const.getMaxSet();f++){
            
            for(int u=0;u<Const.ROW_COUNT*Const.ROW_COUNT;u++){
             pr[u][0] = pesos[u][f];
        }
        
            index_vocal = l.TestGrid(pr);
            
            if(index_vocal>=0){
                    Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Letra Detectada: ").append(Const.abecedario[index_vocal]).append("\n");
                    Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - target: ").append(targets[f]).append("\n");
        if (targets[f] == Const.abecedario[index_vocal]){
                        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Acierto \n");
            aciertos++;
        }
        
        //Draw_Grid(2);
        //System.out.println("Letra detectada: "+Const.abecedario[l.TestGrid(pr)]);
                    Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Dibujar en Grid_Out\n");
        //Draw_Grid(index_vocal);
        }//else {
            float ap[][] = l.TestGrid2(pr);
            //System.out.println("Salida Hardlim ");
                Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append("- Salida Hardlim: \n");
            for(int j=0;j<ap.length;j++){
                //System.out.println(ap[j][0]);
                    Const.LogTexto.append(ap[j][0]).append("\n");
                
            //}
        }
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
            
            
        }
       
        //Const.LogTexto.append(Const.LogDate()+" "+CLASSNAME+" - Aciertos Peso "+i+": "+aciertos+"---------\n");
        //GUI.txtLogger.append(Const.LogTexto.toString());
        //Const.LogTexto.setLength(0);
        l.setAciertos((short)aciertos); //Se almacena los aciertos
        
        
        if(aciertos > aux_acie){
            aux_acie = aciertos;
            ind_pesos = (short) i;
        }
        
        }
        
        short acie =0;
        for(int h=0;h<10;h++){
            m = GUI.stack.get(h);
            l = m.getLogic();
            acie = l.getAciertos();
            Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Aciertos del Conjunto ").append(h+1).append(" : ").append(acie).append(" / ").append(Const.getMaxSet()).append("\n");
        }
        
        
        
        Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append("------------Maximo de Aciertos ").append(ind_pesos+1).append(" : ").append(aux_acie).append(" / ").append(Const.getMaxSet()).append("---------\n");
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
     
        
        l = new Logic();
        //l_fijo.setB(Const.umbralFijo);
        //l_fijo.setPesos(Const.pesosFijo);
        aciertos = 0;
        
        
        
        
        
        if (aux_acie > Logic.aciertos_Fijos){
            Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Encontro un Conjunto Mejor de Pesos\n");   
            Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - Escribe Valores Properties\n");
         GUI.txtLogger.append(Const.LogTexto.toString());
         Const.LogTexto.setLength(0);
         
         Propiedades p = new Propiedades("ArchivosConf\\fijos.properties");
         float pe_pr[][] = GUI.stack.get(ind_pesos).getLogic().getPesos();
         float um_pr[][] = GUI.stack.get(ind_pesos).getLogic().getUmbral();
         
         p.abrirPropiedad();
        for(int i=0;i<Const.TotalDigitos;i++){
             for(int j=0;j<(Const.ROW_COUNT*Const.ROW_COUNT);j++){
                p.cambiarPropiedad("pesosFijo["+i+"]["+j+"]", String.valueOf(pe_pr[i][j]));
             }
        }
        for(int i=0;i<Const.TotalDigitos;i++){
            p.cambiarPropiedad("umbralFijo["+i+"][0]", String.valueOf(um_pr[i][0]));
        }
        
        p.cerrarPropiedad();
        Const.valoresFijos();
            
        }else{
            Const.LogTexto.append(Const.LogDate()).append(" ").append(CLASSNAME).append(" - No Encontro ningun Conjunto Mayor al Archivo Fijo\n");
            GUI.txtLogger.append(Const.LogTexto.toString());
            Const.LogTexto.setLength(0);
        }    
        
        
    }
    
    
    
}

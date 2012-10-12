
package perceptronM.Model;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import perceptronM.GUI.GUI;

/**
 *
 * @author PRETXEL-H
 * @author imarban
 */
public class Const {
    public static final int ROW_COUNT = 8;
    public static final int COLUMN_COUNT = 5;
    public static final int W = 50;
    public static final int H = W;
    public static int epoch = 1000;
    public static final int TotalDigitos = 10;
    public static String CLASSNAME = Const.class.getName();
    public static final float entradas[][] = new float[ROW_COUNT*COLUMN_COUNT][TotalDigitos];
    public static final float entradasTimes[][] = new float[ROW_COUNT*COLUMN_COUNT][TotalDigitos];
    public static final float entradasCentury[][] = new float[ROW_COUNT*COLUMN_COUNT][TotalDigitos];
    public static final float target[][] = new float[TotalDigitos][TotalDigitos];
    public static final float prueba[][] = new float[Const.ROW_COUNT*Const.COLUMN_COUNT][1];
    public static final StringBuilder LogTexto = new StringBuilder();
    private static Calendar calendario;
    public static final char vocales[] = {'a','e','i','o','u'};
    public static final char abecedario[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static final float pesosFijo[][]= new float[Const.TotalDigitos][Const.COLUMN_COUNT*Const.ROW_COUNT];
    public static final float umbralFijo[][]= new float[Const.TotalDigitos][1];
    public static final short patrones_Test = 40;
    static Propiedades p = new Propiedades("ArchivosConf\\maxSet.properties");
    
    public static String LogDate(){
        StringBuilder b = new StringBuilder();
        calendario = new GregorianCalendar();
        int hora =calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        b.append("[").append(hora).append(":").append(minutos).append(":").append(segundos).append("]");
        return b.toString();
    }
    
    public static void Log(String na){
        GUI.txtLogger.setText(na);
        GUI.txtLogger.append(na);
    }
    
    
    
    
    
    public static void definirEntradas(){
    
        LogTexto.append(LogDate()).append(" ").append(CLASSNAME).append(" - Definir Letras Abecedario\n");
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        
        //Digito 0
        entradas[0][0] = 0;
        entradas[1][0] = 1;
        entradas[2][0] = 1;
        entradas[3][0] = 1;
        entradas[4][0] = 0;
        entradas[5][0] = 1;
        entradas[6][0] = 1;
        entradas[7][0] = 0;
        entradas[8][0] = 1;
        entradas[9][0] = 1;
        entradas[10][0] = 1;
        entradas[11][0] = 1;
        entradas[12][0] = 0;
        entradas[13][0] = 1;
        entradas[14][0] = 1;
        entradas[15][0] = 1;
        entradas[16][0] = 1;
        entradas[17][0] = 0;
        entradas[18][0] = 1;
        entradas[19][0] = 1;
        entradas[20][0] = 1;
        entradas[21][0] = 1;
        entradas[22][0] = 0;
        entradas[23][0] = 1;
        entradas[24][0] = 1;
        entradas[25][0] = 1;
        entradas[26][0] = 1;
        entradas[27][0] = 0;
        entradas[28][0] = 1;
        entradas[29][0] = 1;
        entradas[30][0] = 1;
        entradas[31][0] = 1;
        entradas[32][0] = 0;
        entradas[33][0] = 1;
        entradas[34][0] = 1;
        entradas[35][0] = 0;
        entradas[36][0] = 1;
        entradas[37][0] = 1;
        entradas[38][0] = 1;
        entradas[39][0] = 0;
        
        //DIGITO 1 Arial
        entradas[0][1] = 0;
        entradas[1][1] = 0;
        entradas[2][1] = 1;
        entradas[3][1] = 1;
        entradas[4][1] = 0;
        entradas[5][1] = 0;
        entradas[6][1] = 1;
        entradas[7][1] = 1;
        entradas[8][1] = 1;
        entradas[9][1] = 0;
        entradas[10][1] = 1;
        entradas[11][1] = 1;
        entradas[12][1] = 1;
        entradas[13][1] = 1;
        entradas[14][1] = 0;
        entradas[15][1] = 1;
        entradas[16][1] = 0;
        entradas[17][1] = 1;
        entradas[18][1] = 1;
        entradas[19][1] = 0;
        entradas[20][1] = 0;
        entradas[21][1] = 0;
        entradas[22][1] = 1;
        entradas[23][1] = 1;
        entradas[24][1] = 0;
        entradas[25][1] = 0;
        entradas[26][1] = 0;
        entradas[27][1] = 1;
        entradas[28][1] = 1;
        entradas[29][1] = 0;
        entradas[30][1] = 0;
        entradas[31][1] = 0;
        entradas[32][1] = 1;
        entradas[33][1] = 1;
        entradas[34][1] = 0;
        entradas[35][1] = 0;
        entradas[36][1] = 0;
        entradas[37][1] = 1;
        entradas[38][1] = 1;
        entradas[39][1] = 0;
       
        //Digito 2 Arial
        entradas[0][2] = 0;
        entradas[1][2] = 1;
        entradas[2][2] = 1;
        entradas[3][2] = 1;
        entradas[4][2] = 0;
        entradas[5][2] = 1;
        entradas[6][2] = 1;
        entradas[7][2] = 0;
        entradas[8][2] = 1;
        entradas[9][2] = 1;
        entradas[10][2] = 0;
        entradas[11][2] = 0;
        entradas[12][2] = 0;
        entradas[13][2] = 1;
        entradas[14][2] = 1;
        entradas[15][2] = 0;
        entradas[16][2] = 0;
        entradas[17][2] = 0;
        entradas[18][2] = 1;
        entradas[19][2] = 1;
        entradas[20][2] = 0;
        entradas[21][2] = 0;
        entradas[22][2] = 1;
        entradas[23][2] = 1;
        entradas[24][2] = 0;
        entradas[25][2] = 0;
        entradas[26][2] = 1;
        entradas[27][2] = 1;
        entradas[28][2] = 0;
        entradas[29][2] = 0;
        entradas[30][2] = 1;
        entradas[31][2] = 1;
        entradas[32][2] = 0;
        entradas[33][2] = 0;
        entradas[34][2] = 0;
        entradas[35][2] = 1;
        entradas[36][2] = 1;
        entradas[37][2] = 1;
        entradas[38][2] = 1;
        entradas[39][2] = 1;
                
        //Digito 3 Arial
        entradas[0][3] = 0;
        entradas[1][3] = 1;
        entradas[2][3] = 1;
        entradas[3][3] = 1;
        entradas[4][3] = 0;
        entradas[5][3] = 1;
        entradas[6][3] = 1;
        entradas[7][3] = 0;
        entradas[8][3] = 1;
        entradas[9][3] = 1;
        entradas[10][3] = 0;
        entradas[11][3] = 0;
        entradas[12][3] = 0;
        entradas[13][3] = 1;
        entradas[14][3] = 1;
        entradas[15][3] = 0;
        entradas[16][3] = 0;
        entradas[17][3] = 1;
        entradas[18][3] = 1;
        entradas[19][3] = 0;
        entradas[20][3] = 0;
        entradas[21][3] = 0;
        entradas[22][3] = 0;
        entradas[23][3] = 1;
        entradas[24][3] = 1;
        entradas[25][3] = 0;
        entradas[26][3] = 0;
        entradas[27][3] = 0;
        entradas[28][3] = 1;
        entradas[29][3] = 1;
        entradas[30][3] = 1;
        entradas[31][3] = 1;
        entradas[32][3] = 0;
        entradas[33][3] = 1;
        entradas[34][3] = 1;
        entradas[35][3] = 0;
        entradas[36][3] = 1;
        entradas[37][3] = 1;
        entradas[38][3] = 1;
        entradas[39][3] = 0;
        
        //Digito 4 Arial
        entradas[0][4] = 0;
        entradas[1][4] = 0;
        entradas[2][4] = 0;
        entradas[3][4] = 1;
        entradas[4][4] = 1;
        entradas[5][4] = 0;
        entradas[6][4] = 0;
        entradas[7][4] = 1;
        entradas[8][4] = 1;
        entradas[9][4] = 1;
        entradas[10][4] = 0;
        entradas[11][4] = 1;
        entradas[12][4] = 0;
        entradas[13][4] = 1;
        entradas[14][4] = 1;
        entradas[15][4] = 0;
        entradas[16][4] = 1;
        entradas[17][4] = 0;
        entradas[18][4] = 1;
        entradas[19][4] = 1;
        entradas[20][4] = 1;
        entradas[21][4] = 0;
        entradas[22][4] = 0;
        entradas[23][4] = 1;
        entradas[24][4] = 1;
        entradas[25][4] = 1;
        entradas[26][4] = 1;
        entradas[27][4] = 1;
        entradas[28][4] = 1;
        entradas[29][4] = 1;
        entradas[30][4] = 0;
        entradas[31][4] = 0;
        entradas[32][4] = 0;
        entradas[33][4] = 1;
        entradas[34][4] = 1;
        entradas[35][4] = 0;
        entradas[36][4] = 0;
        entradas[37][4] = 0;
        entradas[38][4] = 1;
        entradas[39][4] = 1;
        
        //Digito 5 Arial
        entradas[0][5] = 0;
        entradas[1][5] = 1;
        entradas[2][5] = 1;
        entradas[3][5] = 1;
        entradas[4][5] = 1;
        entradas[5][5] = 0;
        entradas[6][5] = 1;
        entradas[7][5] = 1;
        entradas[8][5] = 0;
        entradas[9][5] = 0;
        entradas[10][5] = 1;
        entradas[11][5] = 1;
        entradas[12][5] = 0;
        entradas[13][5] = 0;
        entradas[14][5] = 0;
        entradas[15][5] = 1;
        entradas[16][5] = 1;
        entradas[17][5] = 1;
        entradas[18][5] = 1;
        entradas[19][5] = 0;
        entradas[20][5] = 1;
        entradas[21][5] = 0;
        entradas[22][5] = 0;
        entradas[23][5] = 1;
        entradas[24][5] = 1;
        entradas[25][5] = 0;
        entradas[26][5] = 0;
        entradas[27][5] = 0;
        entradas[28][5] = 1;
        entradas[29][5] = 1;
        entradas[30][5] = 1;
        entradas[31][5] = 1;
        entradas[32][5] = 0;
        entradas[33][5] = 1;
        entradas[34][5] = 1;
        entradas[35][5] = 0;
        entradas[36][5] = 1;
        entradas[37][5] = 1;
        entradas[38][5] = 1;
        entradas[39][5] = 0;
        
        //Digito 6 Arial
        entradas[0][6] = 0;
        entradas[1][6] = 1;
        entradas[2][6] = 1;
        entradas[3][6] = 1;
        entradas[4][6] = 0;
        entradas[5][6] = 1;
        entradas[6][6] = 1;
        entradas[7][6] = 0;
        entradas[8][6] = 1;
        entradas[9][6] = 1;
        entradas[10][6] = 1;
        entradas[11][6] = 1;
        entradas[12][6] = 0;
        entradas[13][6] = 0;
        entradas[14][6] = 0;
        entradas[15][6] = 1;
        entradas[16][6] = 1;
        entradas[17][6] = 1;
        entradas[18][6] = 1;
        entradas[19][6] = 0;
        entradas[20][6] = 1;
        entradas[21][6] = 1;
        entradas[22][6] = 0;
        entradas[23][6] = 1;
        entradas[24][6] = 1;
        entradas[25][6] = 1;
        entradas[26][6] = 1;
        entradas[27][6] = 0;
        entradas[28][6] = 1;
        entradas[29][6] = 1;
        entradas[30][6] = 1;
        entradas[31][6] = 1;
        entradas[32][6] = 0;
        entradas[33][6] = 1;
        entradas[34][6] = 1;
        entradas[35][6] = 0;
        entradas[36][6] = 1;
        entradas[37][6] = 1;
        entradas[38][6] = 1;
        entradas[39][6] = 0;
        
        //Digito 7 Arial
        entradas[0][7] = 1;
        entradas[1][7] = 1;
        entradas[2][7] = 1;
        entradas[3][7] = 1;
        entradas[4][7] = 1;
        entradas[5][7] = 0;
        entradas[6][7] = 0;
        entradas[7][7] = 0;
        entradas[8][7] = 1;
        entradas[9][7] = 1;
        entradas[10][7] = 0;
        entradas[11][7] = 0;
        entradas[12][7] = 1;
        entradas[13][7] = 1;
        entradas[14][7] = 0;
        entradas[15][7] = 0;
        entradas[16][7] = 0;
        entradas[17][7] = 1;
        entradas[18][7] = 1;
        entradas[19][7] = 0;
        entradas[20][7] = 0;
        entradas[21][7] = 1;
        entradas[22][7] = 1;
        entradas[23][7] = 0;
        entradas[24][7] = 0;
        entradas[25][7] = 0;
        entradas[26][7] = 1;
        entradas[27][7] = 1;
        entradas[28][7] = 0;
        entradas[29][7] = 0;
        entradas[30][7] = 0;
        entradas[31][7] = 1;
        entradas[32][7] = 1;
        entradas[33][7] = 0;
        entradas[34][7] = 0;
        entradas[35][7] = 0;
        entradas[36][7] = 1;
        entradas[37][7] = 1;
        entradas[38][7] = 0;
        entradas[39][7] = 0;
        
        //Digito 8 Arial
        entradas[0][8] = 0;
        entradas[1][8] = 1;
        entradas[2][8] = 1;
        entradas[3][8] = 1;
        entradas[4][8] = 0;
        entradas[5][8] = 1;
        entradas[6][8] = 1;
        entradas[7][8] = 0;
        entradas[8][8] = 1;
        entradas[9][8] = 1;
        entradas[10][8] = 1;
        entradas[11][8] = 1;
        entradas[12][8] = 0;
        entradas[13][8] = 1;
        entradas[14][8] = 1;
        entradas[15][8] = 0;
        entradas[16][8] = 1;
        entradas[17][8] = 1;
        entradas[18][8] = 1;
        entradas[19][8] = 0;
        entradas[20][8] = 1;
        entradas[21][8] = 1;
        entradas[22][8] = 0;
        entradas[23][8] = 1;
        entradas[24][8] = 1;
        entradas[25][8] = 1;
        entradas[26][8] = 1;
        entradas[27][8] = 0;
        entradas[28][8] = 1;
        entradas[29][8] = 1;
        entradas[30][8] = 1;
        entradas[31][8] = 1;
        entradas[32][8] = 0;
        entradas[33][8] = 1;
        entradas[34][8] = 1;
        entradas[35][8] = 0;
        entradas[36][8] = 1;
        entradas[37][8] = 1;
        entradas[38][8] = 1;
        entradas[39][8] = 0;
        
         //Digito 9 Arial
        entradas[0][9] = 0;
        entradas[1][9] = 1;
        entradas[2][9] = 1;
        entradas[3][9] = 1;
        entradas[4][9] = 0;
        entradas[5][9] = 1;
        entradas[6][9] = 1;
        entradas[7][9] = 0;
        entradas[8][9] = 1;
        entradas[9][9] = 1;
        entradas[10][9] = 1;
        entradas[11][9] = 1;
        entradas[12][9] = 0;
        entradas[13][9] = 1;
        entradas[14][9] = 1;
        entradas[15][9] = 1;
        entradas[16][9] = 1;
        entradas[17][9] = 0;
        entradas[18][9] = 1;
        entradas[19][9] = 1;
        entradas[20][9] = 0;
        entradas[21][9] = 1;
        entradas[22][9] = 1;
        entradas[23][9] = 1;
        entradas[24][9] = 1;
        entradas[25][9] = 0;
        entradas[26][9] = 0;
        entradas[27][9] = 0;
        entradas[28][9] = 1;
        entradas[29][9] = 1;
        entradas[30][9] = 1;
        entradas[31][9] = 1;
        entradas[32][9] = 0;
        entradas[33][9] = 1;
        entradas[34][9] = 1;
        entradas[35][9] = 0;
        entradas[36][9] = 1;
        entradas[37][9] = 1;
        entradas[38][9] = 1;
        entradas[39][9] = 0;
        
		//TARGET 0 ARIAL
        target[0][0] = 1;
        target[1][0] = 0;
        target[2][0] = 0;
        target[3][0] = 0;
        target[4][0] = 0;
        target[5][0] = 0;
        target[6][0] = 0;
        target[7][0] = 0;
        target[8][0] = 0;
        target[9][0] = 0;
        
        //TARGET 1 ARIAL
        target[0][1] = 0;
        target[1][1] = 1;
        target[2][1] = 0;
        target[3][1] = 0;
        target[4][1] = 0;
        target[5][1] = 0;
        target[6][1] = 0;
        target[7][1] = 0;
        target[8][1] = 0;
        target[9][1] = 0;
        
        //TARGET 2 ARIAL
        target[0][2] = 0;
        target[1][2] = 0;
        target[2][2] = 1;
        target[3][2] = 0;
        target[4][2] = 0;
        target[5][2] = 0;
        target[6][2] = 0;
        target[7][2] = 0;
        target[8][2] = 0;
        target[9][2] = 0;
        
        //TARGET 3 ARIAL
        target[0][3] = 0;
        target[1][3] = 0;
        target[2][3] = 0;
        target[3][3] = 1;
        target[4][3] = 0;
        target[5][3] = 0;
        target[6][3] = 0;
        target[7][3] = 0;
        target[8][3] = 0;
        target[9][3] = 0;
        
        //TARGET 4 ARIAL
        target[0][4] = 0;
        target[1][4] = 0;
        target[2][4] = 0;
        target[3][4] = 0;
        target[4][4] = 1;
        target[5][4] = 0;
        target[6][4] = 0;
        target[7][4] = 0;
        target[8][4] = 0;
        target[9][4] = 0;
        
        //TARGET 5 ARIAL
        target[0][5] = 0;
        target[1][5] = 0;
        target[2][5] = 0;
        target[3][5] = 0;
        target[4][5] = 0;
        target[5][5] = 1;
        target[6][5] = 0;
        target[7][5] = 0;
        target[8][5] = 0;
        target[9][5] = 0;
        
        //TARGET 6 ARIAL
        target[0][6] = 0;
        target[1][6] = 0;
        target[2][6] = 0;
        target[3][6] = 0;
        target[4][6] = 0;
        target[5][6] = 0;
        target[6][6] = 1;
        target[7][6] = 0;
        target[8][6] = 0;
        target[9][6] = 0;
        
        //TARGET 7 ARIAL
        target[0][7] = 0;
        target[1][7] = 0;
        target[2][7] = 0;
        target[3][7] = 0;
        target[4][7] = 0;
        target[5][7] = 0;
        target[6][7] = 0;
        target[7][7] = 1;
        target[8][7] = 0;
        target[9][7] = 0;
        
        //TARGET 8 ARIAL
        target[0][8] = 0;
        target[1][8] = 0;
        target[2][8] = 0;
        target[3][8] = 0;
        target[4][8] = 1;
        target[5][8] = 0;
        target[6][8] = 0;
        target[7][8] = 0;
        target[8][8] = 1;
        target[9][8] = 0;
        
        //TARGET 9 ARIAL
        target[0][9] = 0;
        target[1][9] = 0;
        target[2][9] = 0;
        target[3][9] = 0;
        target[4][9] = 0;
        target[5][9] = 0;
        target[6][9] = 0;
        target[7][9] = 0;
        target[8][9] = 0;
        target[9][9] = 9;
        
    }
    
    
    public static void clean(){
        for(int i=0;i<ROW_COUNT*ROW_COUNT;i++){
            prueba[i][0] = 0;
        }
    }
        
    public static void valoresFijos()
    {
        LogTexto.append(LogDate()).append(" ").append(CLASSNAME).append(" - Carga Valores Fijos\n");
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        
        Propiedades p_fijos = new Propiedades("ArchivosConf\\fijos.properties");
        
        if(p_fijos.cargarPropiedades()){
            for(int i=0;i<Const.TotalDigitos;i++)
                for(int j=0;j<(Const.ROW_COUNT*Const.ROW_COUNT);j++)
                    pesosFijo[i][j] =p_fijos.leerPropiedad("pesosFijo["+i+"]["+j+"]");

            for(int i=0;i<Const.TotalDigitos;i++)
                umbralFijo[i][0] = p_fijos.leerPropiedad("umbralFijo["+i+"][0]");
        }
        else{
            JOptionPane.showConfirmDialog(null, "Error al cargar el archivo de propiedades" ,"ERROR",JOptionPane.PLAIN_MESSAGE,0);
        }
        
                
    }
    
    public static int getMaxSet(){
        int max;
        if(p.cargarPropiedades()){
            max=p.leerPropiedad_Int("max");
        }
        else
            max=0;
        return max;
    }
    
    public static void setMaxSet(int max) throws IOException{
        p.cambiarPropiedad("max", String.valueOf(max));
        p.abrirPropiedad();
        p.cerrarPropiedad();
    }
    
    
    
}

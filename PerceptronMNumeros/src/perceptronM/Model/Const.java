
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
    public static float alpha = 0.1f;
    public static float errorObjt = 0.1f;
    public static int epoch = 1000;
    public static final int NumJuegos = 3;
    public static final int TotalPatrones = ROW_COUNT*COLUMN_COUNT;
    public static final int TotalDigitos = 10;
    public static String CLASSNAME = Const.class.getName();
    public static final float entradas_1[][] = new float[ROW_COUNT*COLUMN_COUNT][TotalDigitos];
    public static final float entradas_2[][] = new float[ROW_COUNT*COLUMN_COUNT][TotalDigitos];
    public static final float entradas_3[][] = new float[ROW_COUNT*COLUMN_COUNT][TotalDigitos];
    public static final float entradasTimes[][] = new float[ROW_COUNT*COLUMN_COUNT][TotalDigitos];
    public static final float entradasCentury[][] = new float[ROW_COUNT*COLUMN_COUNT][TotalDigitos];
    public static final float target_1[][] = new float[TotalDigitos][TotalDigitos];
    public static final float target_2[][] = new float[TotalDigitos][TotalDigitos];
    public static final float target_3[][] = new float[TotalDigitos][TotalDigitos];
    public static final float prueba[][] = new float[Const.ROW_COUNT*Const.COLUMN_COUNT][1];
    public static final StringBuilder LogTexto = new StringBuilder();
    private static Calendar calendario;
    public static final char vocales[] = {'a','e','i','o','u'};
    public static final char abecedario[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static final char numeros[] = {'0','1','2','3','4','5','6','7','8','9'};
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
    
        LogTexto.append(LogDate()).append(" ").append(CLASSNAME).append(" - Definir Numeros de 0-9\n");
        GUI.txtLogger.append(Const.LogTexto.toString());
        Const.LogTexto.setLength(0);
        
        //DIGITO 0 Arial
        entradas_1[0][0] = 0;
        entradas_1[1][0] = 1;
        entradas_1[2][0] = 1;
        entradas_1[3][0] = 1;
        entradas_1[4][0] = 0;
        entradas_1[5][0] = 1;
        entradas_1[6][0] = 1;
        entradas_1[7][0] = 0;
        entradas_1[8][0] = 1;
        entradas_1[9][0] = 1;
        entradas_1[10][0] = 1;
        entradas_1[11][0] = 1;
        entradas_1[12][0] = 0;
        entradas_1[13][0] = 1;
        entradas_1[14][0] = 1;
        entradas_1[15][0] = 1;
        entradas_1[16][0] = 1;
        entradas_1[17][0] = 0;
        entradas_1[18][0] = 1;
        entradas_1[19][0] = 1;
        entradas_1[20][0] = 1;
        entradas_1[21][0] = 1;
        entradas_1[22][0] = 0;
        entradas_1[23][0] = 1;
        entradas_1[24][0] = 1;
        entradas_1[25][0] = 1;
        entradas_1[26][0] = 1;
        entradas_1[27][0] = 0;
        entradas_1[28][0] = 1;
        entradas_1[29][0] = 1;
        entradas_1[30][0] = 1;
        entradas_1[31][0] = 1;
        entradas_1[32][0] = 0;
        entradas_1[33][0] = 1;
        entradas_1[34][0] = 1;
        entradas_1[35][0] = 0;
        entradas_1[36][0] = 1;
        entradas_1[37][0] = 1;
        entradas_1[38][0] = 1;
        entradas_1[39][0] = 0;
        
        //DIGITO 1 Arial
        entradas_1[0][1] = 0;
        entradas_1[1][1] = 0;
        entradas_1[2][1] = 1;
        entradas_1[3][1] = 1;
        entradas_1[4][1] = 0;
        entradas_1[5][1] = 0;
        entradas_1[6][1] = 1;
        entradas_1[7][1] = 1;
        entradas_1[8][1] = 1;
        entradas_1[9][1] = 0;
        entradas_1[10][1] = 1;
        entradas_1[11][1] = 1;
        entradas_1[12][1] = 1;
        entradas_1[13][1] = 1;
        entradas_1[14][1] = 0;
        entradas_1[15][1] = 1;
        entradas_1[16][1] = 0;
        entradas_1[17][1] = 1;
        entradas_1[18][1] = 1;
        entradas_1[19][1] = 0;
        entradas_1[20][1] = 0;
        entradas_1[21][1] = 0;
        entradas_1[22][1] = 1;
        entradas_1[23][1] = 1;
        entradas_1[24][1] = 0;
        entradas_1[25][1] = 0;
        entradas_1[26][1] = 0;
        entradas_1[27][1] = 1;
        entradas_1[28][1] = 1;
        entradas_1[29][1] = 0;
        entradas_1[30][1] = 0;
        entradas_1[31][1] = 0;
        entradas_1[32][1] = 1;
        entradas_1[33][1] = 1;
        entradas_1[34][1] = 0;
        entradas_1[35][1] = 0;
        entradas_1[36][1] = 0;
        entradas_1[37][1] = 1;
        entradas_1[38][1] = 1;
        entradas_1[39][1] = 0;
       
        //DIGITO 2 Arial
        entradas_1[0][2] = 0;
        entradas_1[1][2] = 1;
        entradas_1[2][2] = 1;
        entradas_1[3][2] = 1;
        entradas_1[4][2] = 0;
        entradas_1[5][2] = 1;
        entradas_1[6][2] = 1;
        entradas_1[7][2] = 0;
        entradas_1[8][2] = 1;
        entradas_1[9][2] = 1;
        entradas_1[10][2] = 0;
        entradas_1[11][2] = 0;
        entradas_1[12][2] = 0;
        entradas_1[13][2] = 1;
        entradas_1[14][2] = 1;
        entradas_1[15][2] = 0;
        entradas_1[16][2] = 0;
        entradas_1[17][2] = 0;
        entradas_1[18][2] = 1;
        entradas_1[19][2] = 1;
        entradas_1[20][2] = 0;
        entradas_1[21][2] = 0;
        entradas_1[22][2] = 1;
        entradas_1[23][2] = 1;
        entradas_1[24][2] = 0;
        entradas_1[25][2] = 0;
        entradas_1[26][2] = 1;
        entradas_1[27][2] = 1;
        entradas_1[28][2] = 0;
        entradas_1[29][2] = 0;
        entradas_1[30][2] = 1;
        entradas_1[31][2] = 1;
        entradas_1[32][2] = 0;
        entradas_1[33][2] = 0;
        entradas_1[34][2] = 0;
        entradas_1[35][2] = 1;
        entradas_1[36][2] = 1;
        entradas_1[37][2] = 1;
        entradas_1[38][2] = 1;
        entradas_1[39][2] = 1;
                
        //DIGITO 3 Arial
        entradas_1[0][3] = 0;
        entradas_1[1][3] = 1;
        entradas_1[2][3] = 1;
        entradas_1[3][3] = 1;
        entradas_1[4][3] = 0;
        entradas_1[5][3] = 1;
        entradas_1[6][3] = 1;
        entradas_1[7][3] = 0;
        entradas_1[8][3] = 1;
        entradas_1[9][3] = 1;
        entradas_1[10][3] = 0;
        entradas_1[11][3] = 0;
        entradas_1[12][3] = 0;
        entradas_1[13][3] = 1;
        entradas_1[14][3] = 1;
        entradas_1[15][3] = 0;
        entradas_1[16][3] = 0;
        entradas_1[17][3] = 1;
        entradas_1[18][3] = 1;
        entradas_1[19][3] = 0;
        entradas_1[20][3] = 0;
        entradas_1[21][3] = 0;
        entradas_1[22][3] = 0;
        entradas_1[23][3] = 1;
        entradas_1[24][3] = 1;
        entradas_1[25][3] = 0;
        entradas_1[26][3] = 0;
        entradas_1[27][3] = 0;
        entradas_1[28][3] = 1;
        entradas_1[29][3] = 1;
        entradas_1[30][3] = 1;
        entradas_1[31][3] = 1;
        entradas_1[32][3] = 0;
        entradas_1[33][3] = 1;
        entradas_1[34][3] = 1;
        entradas_1[35][3] = 0;
        entradas_1[36][3] = 1;
        entradas_1[37][3] = 1;
        entradas_1[38][3] = 1;
        entradas_1[39][3] = 0;
        
        //DIGITO 4 Arial
        entradas_1[0][4] = 0;
        entradas_1[1][4] = 0;
        entradas_1[2][4] = 0;
        entradas_1[3][4] = 1;
        entradas_1[4][4] = 1;
        entradas_1[5][4] = 0;
        entradas_1[6][4] = 0;
        entradas_1[7][4] = 1;
        entradas_1[8][4] = 1;
        entradas_1[9][4] = 1;
        entradas_1[10][4] = 0;
        entradas_1[11][4] = 1;
        entradas_1[12][4] = 0;
        entradas_1[13][4] = 1;
        entradas_1[14][4] = 1;
        entradas_1[15][4] = 0;
        entradas_1[16][4] = 1;
        entradas_1[17][4] = 0;
        entradas_1[18][4] = 1;
        entradas_1[19][4] = 1;
        entradas_1[20][4] = 1;
        entradas_1[21][4] = 0;
        entradas_1[22][4] = 0;
        entradas_1[23][4] = 1;
        entradas_1[24][4] = 1;
        entradas_1[25][4] = 1;
        entradas_1[26][4] = 1;
        entradas_1[27][4] = 1;
        entradas_1[28][4] = 1;
        entradas_1[29][4] = 1;
        entradas_1[30][4] = 0;
        entradas_1[31][4] = 0;
        entradas_1[32][4] = 0;
        entradas_1[33][4] = 1;
        entradas_1[34][4] = 1;
        entradas_1[35][4] = 0;
        entradas_1[36][4] = 0;
        entradas_1[37][4] = 0;
        entradas_1[38][4] = 1;
        entradas_1[39][4] = 1;
        
        //DIGITO 5 Arial
        entradas_1[0][5] = 0;
        entradas_1[1][5] = 1;
        entradas_1[2][5] = 1;
        entradas_1[3][5] = 1;
        entradas_1[4][5] = 1;
        entradas_1[5][5] = 0;
        entradas_1[6][5] = 1;
        entradas_1[7][5] = 1;
        entradas_1[8][5] = 0;
        entradas_1[9][5] = 0;
        entradas_1[10][5] = 1;
        entradas_1[11][5] = 1;
        entradas_1[12][5] = 0;
        entradas_1[13][5] = 0;
        entradas_1[14][5] = 0;
        entradas_1[15][5] = 1;
        entradas_1[16][5] = 1;
        entradas_1[17][5] = 1;
        entradas_1[18][5] = 1;
        entradas_1[19][5] = 0;
        entradas_1[20][5] = 1;
        entradas_1[21][5] = 0;
        entradas_1[22][5] = 0;
        entradas_1[23][5] = 1;
        entradas_1[24][5] = 1;
        entradas_1[25][5] = 0;
        entradas_1[26][5] = 0;
        entradas_1[27][5] = 0;
        entradas_1[28][5] = 1;
        entradas_1[29][5] = 1;
        entradas_1[30][5] = 1;
        entradas_1[31][5] = 1;
        entradas_1[32][5] = 0;
        entradas_1[33][5] = 1;
        entradas_1[34][5] = 1;
        entradas_1[35][5] = 0;
        entradas_1[36][5] = 1;
        entradas_1[37][5] = 1;
        entradas_1[38][5] = 1;
        entradas_1[39][5] = 0;
        
        //DIGITO 6 Arial
        entradas_1[0][6] = 0;
        entradas_1[1][6] = 1;
        entradas_1[2][6] = 1;
        entradas_1[3][6] = 1;
        entradas_1[4][6] = 0;
        entradas_1[5][6] = 1;
        entradas_1[6][6] = 1;
        entradas_1[7][6] = 0;
        entradas_1[8][6] = 1;
        entradas_1[9][6] = 1;
        entradas_1[10][6] = 1;
        entradas_1[11][6] = 1;
        entradas_1[12][6] = 0;
        entradas_1[13][6] = 0;
        entradas_1[14][6] = 0;
        entradas_1[15][6] = 1;
        entradas_1[16][6] = 1;
        entradas_1[17][6] = 1;
        entradas_1[18][6] = 1;
        entradas_1[19][6] = 0;
        entradas_1[20][6] = 1;
        entradas_1[21][6] = 1;
        entradas_1[22][6] = 0;
        entradas_1[23][6] = 1;
        entradas_1[24][6] = 1;
        entradas_1[25][6] = 1;
        entradas_1[26][6] = 1;
        entradas_1[27][6] = 0;
        entradas_1[28][6] = 1;
        entradas_1[29][6] = 1;
        entradas_1[30][6] = 1;
        entradas_1[31][6] = 1;
        entradas_1[32][6] = 0;
        entradas_1[33][6] = 1;
        entradas_1[34][6] = 1;
        entradas_1[35][6] = 0;
        entradas_1[36][6] = 1;
        entradas_1[37][6] = 1;
        entradas_1[38][6] = 1;
        entradas_1[39][6] = 0;
        
        //DIGITO 7 Arial
        entradas_1[0][7] = 1;
        entradas_1[1][7] = 1;
        entradas_1[2][7] = 1;
        entradas_1[3][7] = 1;
        entradas_1[4][7] = 1;
        entradas_1[5][7] = 0;
        entradas_1[6][7] = 0;
        entradas_1[7][7] = 0;
        entradas_1[8][7] = 1;
        entradas_1[9][7] = 1;
        entradas_1[10][7] = 0;
        entradas_1[11][7] = 0;
        entradas_1[12][7] = 1;
        entradas_1[13][7] = 1;
        entradas_1[14][7] = 0;
        entradas_1[15][7] = 0;
        entradas_1[16][7] = 0;
        entradas_1[17][7] = 1;
        entradas_1[18][7] = 1;
        entradas_1[19][7] = 0;
        entradas_1[20][7] = 0;
        entradas_1[21][7] = 1;
        entradas_1[22][7] = 1;
        entradas_1[23][7] = 0;
        entradas_1[24][7] = 0;
        entradas_1[25][7] = 0;
        entradas_1[26][7] = 1;
        entradas_1[27][7] = 1;
        entradas_1[28][7] = 0;
        entradas_1[29][7] = 0;
        entradas_1[30][7] = 0;
        entradas_1[31][7] = 1;
        entradas_1[32][7] = 1;
        entradas_1[33][7] = 0;
        entradas_1[34][7] = 0;
        entradas_1[35][7] = 0;
        entradas_1[36][7] = 1;
        entradas_1[37][7] = 1;
        entradas_1[38][7] = 0;
        entradas_1[39][7] = 0;
        
        //DIGITO 8 Arial
        entradas_1[0][8] = 0;
        entradas_1[1][8] = 1;
        entradas_1[2][8] = 1;
        entradas_1[3][8] = 1;
        entradas_1[4][8] = 0;
        entradas_1[5][8] = 1;
        entradas_1[6][8] = 1;
        entradas_1[7][8] = 0;
        entradas_1[8][8] = 1;
        entradas_1[9][8] = 1;
        entradas_1[10][8] = 1;
        entradas_1[11][8] = 1;
        entradas_1[12][8] = 0;
        entradas_1[13][8] = 1;
        entradas_1[14][8] = 1;
        entradas_1[15][8] = 0;
        entradas_1[16][8] = 1;
        entradas_1[17][8] = 1;
        entradas_1[18][8] = 1;
        entradas_1[19][8] = 0;
        entradas_1[20][8] = 1;
        entradas_1[21][8] = 1;
        entradas_1[22][8] = 0;
        entradas_1[23][8] = 1;
        entradas_1[24][8] = 1;
        entradas_1[25][8] = 1;
        entradas_1[26][8] = 1;
        entradas_1[27][8] = 0;
        entradas_1[28][8] = 1;
        entradas_1[29][8] = 1;
        entradas_1[30][8] = 1;
        entradas_1[31][8] = 1;
        entradas_1[32][8] = 0;
        entradas_1[33][8] = 1;
        entradas_1[34][8] = 1;
        entradas_1[35][8] = 0;
        entradas_1[36][8] = 1;
        entradas_1[37][8] = 1;
        entradas_1[38][8] = 1;
        entradas_1[39][8] = 0;
        
         //DIGITO 9 Arial
        entradas_1[0][9] = 0;
        entradas_1[1][9] = 1;
        entradas_1[2][9] = 1;
        entradas_1[3][9] = 1;
        entradas_1[4][9] = 0;
        entradas_1[5][9] = 1;
        entradas_1[6][9] = 1;
        entradas_1[7][9] = 0;
        entradas_1[8][9] = 1;
        entradas_1[9][9] = 1;
        entradas_1[10][9] = 1;
        entradas_1[11][9] = 1;
        entradas_1[12][9] = 0;
        entradas_1[13][9] = 1;
        entradas_1[14][9] = 1;
        entradas_1[15][9] = 1;
        entradas_1[16][9] = 1;
        entradas_1[17][9] = 0;
        entradas_1[18][9] = 1;
        entradas_1[19][9] = 1;
        entradas_1[20][9] = 0;
        entradas_1[21][9] = 1;
        entradas_1[22][9] = 1;
        entradas_1[23][9] = 1;
        entradas_1[24][9] = 1;
        entradas_1[25][9] = 0;
        entradas_1[26][9] = 0;
        entradas_1[27][9] = 0;
        entradas_1[28][9] = 1;
        entradas_1[29][9] = 1;
        entradas_1[30][9] = 1;
        entradas_1[31][9] = 1;
        entradas_1[32][9] = 0;
        entradas_1[33][9] = 1;
        entradas_1[34][9] = 1;
        entradas_1[35][9] = 0;
        entradas_1[36][9] = 1;
        entradas_1[37][9] = 1;
        entradas_1[38][9] = 1;
        entradas_1[39][9] = 0;
        
	//TARGET 0 Arial
        target_1[0][0] = 1;
        target_1[1][0] = 0;
        target_1[2][0] = 0;
        target_1[3][0] = 0;
        target_1[4][0] = 0;
        target_1[5][0] = 0;
        target_1[6][0] = 0;
        target_1[7][0] = 0;
        target_1[8][0] = 0;
        target_1[9][0] = 0;
        
        //TARGET 1 Arial
        target_1[0][1] = 0;
        target_1[1][1] = 1;
        target_1[2][1] = 0;
        target_1[3][1] = 0;
        target_1[4][1] = 0;
        target_1[5][1] = 0;
        target_1[6][1] = 0;
        target_1[7][1] = 0;
        target_1[8][1] = 0;
        target_1[9][1] = 0;
        
        //TARGET 2 Arial
        target_1[0][2] = 0;
        target_1[1][2] = 0;
        target_1[2][2] = 1;
        target_1[3][2] = 0;
        target_1[4][2] = 0;
        target_1[5][2] = 0;
        target_1[6][2] = 0;
        target_1[7][2] = 0;
        target_1[8][2] = 0;
        target_1[9][2] = 0;
        
        //TARGET 3 Arial
        target_1[0][3] = 0;
        target_1[1][3] = 0;
        target_1[2][3] = 0;
        target_1[3][3] = 1;
        target_1[4][3] = 0;
        target_1[5][3] = 0;
        target_1[6][3] = 0;
        target_1[7][3] = 0;
        target_1[8][3] = 0;
        target_1[9][3] = 0;
        
        //TARGET 4 Arial
        target_1[0][4] = 0;
        target_1[1][4] = 0;
        target_1[2][4] = 0;
        target_1[3][4] = 0;
        target_1[4][4] = 1;
        target_1[5][4] = 0;
        target_1[6][4] = 0;
        target_1[7][4] = 0;
        target_1[8][4] = 0;
        target_1[9][4] = 0;
        
        //TARGET 5 Arial
        target_1[0][5] = 0;
        target_1[1][5] = 0;
        target_1[2][5] = 0;
        target_1[3][5] = 0;
        target_1[4][5] = 0;
        target_1[5][5] = 1;
        target_1[6][5] = 0;
        target_1[7][5] = 0;
        target_1[8][5] = 0;
        target_1[9][5] = 0;
        
        //TARGET 6 Arial
        target_1[0][6] = 0;
        target_1[1][6] = 0;
        target_1[2][6] = 0;
        target_1[3][6] = 0;
        target_1[4][6] = 0;
        target_1[5][6] = 0;
        target_1[6][6] = 1;
        target_1[7][6] = 0;
        target_1[8][6] = 0;
        target_1[9][6] = 0;
        
        //TARGET 7 Arial
        target_1[0][7] = 0;
        target_1[1][7] = 0;
        target_1[2][7] = 0;
        target_1[3][7] = 0;
        target_1[4][7] = 0;
        target_1[5][7] = 0;
        target_1[6][7] = 0;
        target_1[7][7] = 1;
        target_1[8][7] = 0;
        target_1[9][7] = 0;
        
        //TARGET 8 Arial
        target_1[0][8] = 0;
        target_1[1][8] = 0;
        target_1[2][8] = 0;
        target_1[3][8] = 0;
        target_1[4][8] = 0;
        target_1[5][8] = 0;
        target_1[6][8] = 0;
        target_1[7][8] = 0;
        target_1[8][8] = 1;
        target_1[9][8] = 0;
        
        //TARGET 9 Arial
        target_1[0][9] = 0;
        target_1[1][9] = 0;
        target_1[2][9] = 0;
        target_1[3][9] = 0;
        target_1[4][9] = 0;
        target_1[5][9] = 0;
        target_1[6][9] = 0;
        target_1[7][9] = 0;
        target_1[8][9] = 0;
        target_1[9][9] = 1;
        
        //----------------
        
        //DIGITO 0 AgencyFB
        entradas_2[0][0] = 1;
        entradas_2[1][0] = 1;
        entradas_2[2][0] = 1;
        entradas_2[3][0] = 1;
        entradas_2[4][0] = 1;
        entradas_2[5][0] = 1;
        entradas_2[6][0] = 0;
        entradas_2[7][0] = 0;
        entradas_2[8][0] = 0;
        entradas_2[9][0] = 1;
        entradas_2[10][0] = 1;
        entradas_2[11][0] = 0;
        entradas_2[12][0] = 0;
        entradas_2[13][0] = 0;
        entradas_2[14][0] = 1;
        entradas_2[15][0] = 1;
        entradas_2[16][0] = 0;
        entradas_2[17][0] = 0;
        entradas_2[18][0] = 0;
        entradas_2[19][0] = 1;
        entradas_2[20][0] = 1;
        entradas_2[21][0] = 0;
        entradas_2[22][0] = 0;
        entradas_2[23][0] = 0;
        entradas_2[24][0] = 1;
        entradas_2[25][0] = 1;
        entradas_2[26][0] = 0;
        entradas_2[27][0] = 0;
        entradas_2[28][0] = 0;
        entradas_2[29][0] = 1;
        entradas_2[30][0] = 1;
        entradas_2[31][0] = 0;
        entradas_2[32][0] = 0;
        entradas_2[33][0] = 0;
        entradas_2[34][0] = 1;
        entradas_2[35][0] = 1;
        entradas_2[36][0] = 1;
        entradas_2[37][0] = 1;
        entradas_2[38][0] = 1;
        entradas_2[39][0] = 1;
        
        //DIGITO 1 AgencyFB
        entradas_2[0][1] = 0;
        entradas_2[1][1] = 0;
        entradas_2[2][1] = 1;
        entradas_2[3][1] = 0;
        entradas_2[4][1] = 0;
        entradas_2[5][1] = 0;
        entradas_2[6][1] = 1;
        entradas_2[7][1] = 1;
        entradas_2[8][1] = 0;
        entradas_2[9][1] = 0;
        entradas_2[10][1] = 0;
        entradas_2[11][1] = 0;
        entradas_2[12][1] = 1;
        entradas_2[13][1] = 0;
        entradas_2[14][1] = 0;
        entradas_2[15][1] = 0;
        entradas_2[16][1] = 0;
        entradas_2[17][1] = 1;
        entradas_2[18][1] = 0;
        entradas_2[19][1] = 0;
        entradas_2[20][1] = 0;
        entradas_2[21][1] = 0;
        entradas_2[22][1] = 1;
        entradas_2[23][1] = 0;
        entradas_2[24][1] = 0;
        entradas_2[25][1] = 0;
        entradas_2[26][1] = 0;
        entradas_2[27][1] = 1;
        entradas_2[28][1] = 0;
        entradas_2[29][1] = 0;
        entradas_2[30][1] = 0;
        entradas_2[31][1] = 0;
        entradas_2[32][1] = 1;
        entradas_2[33][1] = 0;
        entradas_2[34][1] = 0;
        entradas_2[35][1] = 0;
        entradas_2[36][1] = 0;
        entradas_2[37][1] = 1;
        entradas_2[38][1] = 0;
        entradas_2[39][1] = 0;
       
        //DIGITO 2 AgencyFB
        entradas_2[0][2] = 1;
        entradas_2[1][2] = 1;
        entradas_2[2][2] = 1;
        entradas_2[3][2] = 1;
        entradas_2[4][2] = 1;
        entradas_2[5][2] = 1;
        entradas_2[6][2] = 0;
        entradas_2[7][2] = 0;
        entradas_2[8][2] = 0;
        entradas_2[9][2] = 1;
        entradas_2[10][2] = 0;
        entradas_2[11][2] = 0;
        entradas_2[12][2] = 0;
        entradas_2[13][2] = 0;
        entradas_2[14][2] = 1;
        entradas_2[15][2] = 0;
        entradas_2[16][2] = 0;
        entradas_2[17][2] = 0;
        entradas_2[18][2] = 1;
        entradas_2[19][2] = 1;
        entradas_2[20][2] = 0;
        entradas_2[21][2] = 0;
        entradas_2[22][2] = 1;
        entradas_2[23][2] = 0;
        entradas_2[24][2] = 0;
        entradas_2[25][2] = 0;
        entradas_2[26][2] = 1;
        entradas_2[27][2] = 0;
        entradas_2[28][2] = 0;
        entradas_2[29][2] = 0;
        entradas_2[30][2] = 1;
        entradas_2[31][2] = 0;
        entradas_2[32][2] = 0;
        entradas_2[33][2] = 0;
        entradas_2[34][2] = 0;
        entradas_2[35][2] = 1;
        entradas_2[36][2] = 1;
        entradas_2[37][2] = 1;
        entradas_2[38][2] = 1;
        entradas_2[39][2] = 1;
                
        //DIGITO 3 AgencyFB
        entradas_2[0][3] = 1;
        entradas_2[1][3] = 1;
        entradas_2[2][3] = 1;
        entradas_2[3][3] = 1;
        entradas_2[4][3] = 1;
        entradas_2[5][3] = 1;
        entradas_2[6][3] = 0;
        entradas_2[7][3] = 0;
        entradas_2[8][3] = 0;
        entradas_2[9][3] = 1;
        entradas_2[10][3] = 0;
        entradas_2[11][3] = 0;
        entradas_2[12][3] = 0;
        entradas_2[13][3] = 0;
        entradas_2[14][3] = 1;
        entradas_2[15][3] = 0;
        entradas_2[16][3] = 0;
        entradas_2[17][3] = 0;
        entradas_2[18][3] = 1;
        entradas_2[19][3] = 1;
        entradas_2[20][3] = 0;
        entradas_2[21][3] = 0;
        entradas_2[22][3] = 0;
        entradas_2[23][3] = 1;
        entradas_2[24][3] = 1;
        entradas_2[25][3] = 0;
        entradas_2[26][3] = 0;
        entradas_2[27][3] = 0;
        entradas_2[28][3] = 0;
        entradas_2[29][3] = 1;
        entradas_2[30][3] = 1;
        entradas_2[31][3] = 0;
        entradas_2[32][3] = 0;
        entradas_2[33][3] = 0;
        entradas_2[34][3] = 1;
        entradas_2[35][3] = 1;
        entradas_2[36][3] = 1;
        entradas_2[37][3] = 1;
        entradas_2[38][3] = 1;
        entradas_2[39][3] = 1;
        
        //DIGITO 4 AgencyFB
        entradas_2[0][4] = 0;
        entradas_2[1][4] = 0;
        entradas_2[2][4] = 0;
        entradas_2[3][4] = 1;
        entradas_2[4][4] = 0;
        entradas_2[5][4] = 0;
        entradas_2[6][4] = 0;
        entradas_2[7][4] = 1;
        entradas_2[8][4] = 0;
        entradas_2[9][4] = 0;
        entradas_2[10][4] = 0;
        entradas_2[11][4] = 1;
        entradas_2[12][4] = 0;
        entradas_2[13][4] = 1;
        entradas_2[14][4] = 0;
        entradas_2[15][4] = 1;
        entradas_2[16][4] = 0;
        entradas_2[17][4] = 0;
        entradas_2[18][4] = 1;
        entradas_2[19][4] = 0;
        entradas_2[20][4] = 1;
        entradas_2[21][4] = 1;
        entradas_2[22][4] = 1;
        entradas_2[23][4] = 1;
        entradas_2[24][4] = 1;
        entradas_2[25][4] = 0;
        entradas_2[26][4] = 0;
        entradas_2[27][4] = 0;
        entradas_2[28][4] = 1;
        entradas_2[29][4] = 0;
        entradas_2[30][4] = 0;
        entradas_2[31][4] = 0;
        entradas_2[32][4] = 0;
        entradas_2[33][4] = 1;
        entradas_2[34][4] = 0;
        entradas_2[35][4] = 0;
        entradas_2[36][4] = 0;
        entradas_2[37][4] = 0;
        entradas_2[38][4] = 1;
        entradas_2[39][4] = 0;
        
        //DIGITO 5 AgencyFB
        entradas_2[0][5] = 1;
        entradas_2[1][5] = 1;
        entradas_2[2][5] = 1;
        entradas_2[3][5] = 1;
        entradas_2[4][5] = 1;
        entradas_2[5][5] = 1;
        entradas_2[6][5] = 0;
        entradas_2[7][5] = 0;
        entradas_2[8][5] = 0;
        entradas_2[9][5] = 0;
        entradas_2[10][5] = 1;
        entradas_2[11][5] = 0;
        entradas_2[12][5] = 0;
        entradas_2[13][5] = 0;
        entradas_2[14][5] = 0;
        entradas_2[15][5] = 1;
        entradas_2[16][5] = 1;
        entradas_2[17][5] = 1;
        entradas_2[18][5] = 1;
        entradas_2[19][5] = 1;
        entradas_2[20][5] = 0;
        entradas_2[21][5] = 0;
        entradas_2[22][5] = 0;
        entradas_2[23][5] = 0;
        entradas_2[24][5] = 1;
        entradas_2[25][5] = 0;
        entradas_2[26][5] = 0;
        entradas_2[27][5] = 0;
        entradas_2[28][5] = 0;
        entradas_2[29][5] = 1;
        entradas_2[30][5] = 1;
        entradas_2[31][5] = 0;
        entradas_2[32][5] = 0;
        entradas_2[33][5] = 0;
        entradas_2[34][5] = 1;
        entradas_2[35][5] = 1;
        entradas_2[36][5] = 1;
        entradas_2[37][5] = 1;
        entradas_2[38][5] = 1;
        entradas_2[39][5] = 1;
        
        //DIGITO 6 AgencyFB
        entradas_2[0][6] = 1;
        entradas_2[1][6] = 1;
        entradas_2[2][6] = 1;
        entradas_2[3][6] = 1;
        entradas_2[4][6] = 1;
        entradas_2[5][6] = 1;
        entradas_2[6][6] = 0;
        entradas_2[7][6] = 0;
        entradas_2[8][6] = 0;
        entradas_2[9][6] = 1;
        entradas_2[10][6] = 1;
        entradas_2[11][6] = 0;
        entradas_2[12][6] = 0;
        entradas_2[13][6] = 0;
        entradas_2[14][6] = 0;
        entradas_2[15][6] = 1;
        entradas_2[16][6] = 1;
        entradas_2[17][6] = 1;
        entradas_2[18][6] = 1;
        entradas_2[19][6] = 1;
        entradas_2[20][6] = 1;
        entradas_2[21][6] = 0;
        entradas_2[22][6] = 0;
        entradas_2[23][6] = 0;
        entradas_2[24][6] = 1;
        entradas_2[25][6] = 1;
        entradas_2[26][6] = 0;
        entradas_2[27][6] = 0;
        entradas_2[28][6] = 0;
        entradas_2[29][6] = 1;
        entradas_2[30][6] = 1;
        entradas_2[31][6] = 0;
        entradas_2[32][6] = 0;
        entradas_2[33][6] = 0;
        entradas_2[34][6] = 1;
        entradas_2[35][6] = 1;
        entradas_2[36][6] = 1;
        entradas_2[37][6] = 1;
        entradas_2[38][6] = 1;
        entradas_2[39][6] = 1;
        
        //DIGITO 7 AgencyFB
        entradas_2[0][7] = 1;
        entradas_2[1][7] = 1;
        entradas_2[2][7] = 1;
        entradas_2[3][7] = 1;
        entradas_2[4][7] = 1;
        entradas_2[5][7] = 1;
        entradas_2[6][7] = 0;
        entradas_2[7][7] = 0;
        entradas_2[8][7] = 0;
        entradas_2[9][7] = 1;
        entradas_2[10][7] = 0;
        entradas_2[11][7] = 0;
        entradas_2[12][7] = 0;
        entradas_2[13][7] = 1;
        entradas_2[14][7] = 1;
        entradas_2[15][7] = 0;
        entradas_2[16][7] = 0;
        entradas_2[17][7] = 0;
        entradas_2[18][7] = 1;
        entradas_2[19][7] = 0;
        entradas_2[20][7] = 0;
        entradas_2[21][7] = 0;
        entradas_2[22][7] = 1;
        entradas_2[23][7] = 1;
        entradas_2[24][7] = 0;
        entradas_2[25][7] = 0;
        entradas_2[26][7] = 0;
        entradas_2[27][7] = 1;
        entradas_2[28][7] = 0;
        entradas_2[29][7] = 0;
        entradas_2[30][7] = 0;
        entradas_2[31][7] = 1;
        entradas_2[32][7] = 1;
        entradas_2[33][7] = 0;
        entradas_2[34][7] = 0;
        entradas_2[35][7] = 0;
        entradas_2[36][7] = 1;
        entradas_2[37][7] = 0;
        entradas_2[38][7] = 0;
        entradas_2[39][7] = 0;
        
        //DIGITO 8 AgencyFB
        entradas_2[0][8] = 1;
        entradas_2[1][8] = 1;
        entradas_2[2][8] = 1;
        entradas_2[3][8] = 1;
        entradas_2[4][8] = 1;
        entradas_2[5][8] = 1;
        entradas_2[6][8] = 0;
        entradas_2[7][8] = 0;
        entradas_2[8][8] = 0;
        entradas_2[9][8] = 1;
        entradas_2[10][8] = 1;
        entradas_2[11][8] = 0;
        entradas_2[12][8] = 0;
        entradas_2[13][8] = 0;
        entradas_2[14][8] = 1;
        entradas_2[15][8] = 0;
        entradas_2[16][8] = 1;
        entradas_2[17][8] = 1;
        entradas_2[18][8] = 1;
        entradas_2[19][8] = 0;
        entradas_2[20][8] = 0;
        entradas_2[21][8] = 1;
        entradas_2[22][8] = 1;
        entradas_2[23][8] = 1;
        entradas_2[24][8] = 0;
        entradas_2[25][8] = 1;
        entradas_2[26][8] = 0;
        entradas_2[27][8] = 0;
        entradas_2[28][8] = 0;
        entradas_2[29][8] = 1;
        entradas_2[30][8] = 1;
        entradas_2[31][8] = 0;
        entradas_2[32][8] = 0;
        entradas_2[33][8] = 0;
        entradas_2[34][8] = 1;
        entradas_2[35][8] = 1;
        entradas_2[36][8] = 1;
        entradas_2[37][8] = 1;
        entradas_2[38][8] = 1;
        entradas_2[39][8] = 1;
       
        //DIGITO 9 AgencyFB
        entradas_2[0][9] = 1;
        entradas_2[1][9] = 1;
        entradas_2[2][9] = 1;
        entradas_2[3][9] = 1;
        entradas_2[4][9] = 1;
        entradas_2[5][9] = 1;
        entradas_2[6][9] = 0;
        entradas_2[7][9] = 0;
        entradas_2[8][9] = 0;
        entradas_2[9][9] = 1;
        entradas_2[10][9] = 1;
        entradas_2[11][9] = 0;
        entradas_2[12][9] = 0;
        entradas_2[13][9] = 0;
        entradas_2[14][9] = 1;
        entradas_2[15][9] = 1;
        entradas_2[16][9] = 1;
        entradas_2[17][9] = 1;
        entradas_2[18][9] = 1;
        entradas_2[19][9] = 1;
        entradas_2[20][9] = 0;
        entradas_2[21][9] = 0;
        entradas_2[22][9] = 0;
        entradas_2[23][9] = 0;
        entradas_2[24][9] = 1;
        entradas_2[25][9] = 0;
        entradas_2[26][9] = 0;
        entradas_2[27][9] = 0;
        entradas_2[28][9] = 0;
        entradas_2[29][9] = 1;
        entradas_2[30][9] = 1;
        entradas_2[31][9] = 0;
        entradas_2[32][9] = 0;
        entradas_2[33][9] = 0;
        entradas_2[34][9] = 1;
        entradas_2[35][9] = 1;
        entradas_2[36][9] = 1;
        entradas_2[37][9] = 1;
        entradas_2[38][9] = 1;
        entradas_2[39][9] = 1;
        
	//TARGET 0 AgencyFB
        target_2[0][0] = 1;
        target_2[1][0] = 0;
        target_2[2][0] = 0;
        target_2[3][0] = 0;
        target_2[4][0] = 0;
        target_2[5][0] = 0;
        target_2[6][0] = 0;
        target_2[7][0] = 0;
        target_2[8][0] = 0;
        target_2[9][0] = 0;
        
        //TARGET 1 AgencyFB
        target_2[0][1] = 0;
        target_2[1][1] = 1;
        target_2[2][1] = 0;
        target_2[3][1] = 0;
        target_2[4][1] = 0;
        target_2[5][1] = 0;
        target_2[6][1] = 0;
        target_2[7][1] = 0;
        target_2[8][1] = 0;
        target_2[9][1] = 0;
        
        //TARGET 2 AgencyFB
        target_2[0][2] = 0;
        target_2[1][2] = 0;
        target_2[2][2] = 1;
        target_2[3][2] = 0;
        target_2[4][2] = 0;
        target_2[5][2] = 0;
        target_2[6][2] = 0;
        target_2[7][2] = 0;
        target_2[8][2] = 0;
        target_2[9][2] = 0;
        
        //TARGET 3 AgencyFB
        target_2[0][3] = 0;
        target_2[1][3] = 0;
        target_2[2][3] = 0;
        target_2[3][3] = 1;
        target_2[4][3] = 0;
        target_2[5][3] = 0;
        target_2[6][3] = 0;
        target_2[7][3] = 0;
        target_2[8][3] = 0;
        target_2[9][3] = 0;
        
        //TARGET 4 AgencyFB
        target_2[0][4] = 0;
        target_2[1][4] = 0;
        target_2[2][4] = 0;
        target_2[3][4] = 0;
        target_2[4][4] = 1;
        target_2[5][4] = 0;
        target_2[6][4] = 0;
        target_2[7][4] = 0;
        target_2[8][4] = 0;
        target_2[9][4] = 0;
        
        //TARGET 5 AgencyFB
        target_2[0][5] = 0;
        target_2[1][5] = 0;
        target_2[2][5] = 0;
        target_2[3][5] = 0;
        target_2[4][5] = 0;
        target_2[5][5] = 1;
        target_2[6][5] = 0;
        target_2[7][5] = 0;
        target_2[8][5] = 0;
        target_2[9][5] = 0;
        
        //TARGET 6 AgencyFB
        target_2[0][6] = 0;
        target_2[1][6] = 0;
        target_2[2][6] = 0;
        target_2[3][6] = 0;
        target_2[4][6] = 0;
        target_2[5][6] = 0;
        target_2[6][6] = 1;
        target_2[7][6] = 0;
        target_2[8][6] = 0;
        target_2[9][6] = 0;
        
        //TARGET 7 AgencyFB
        target_2[0][7] = 0;
        target_2[1][7] = 0;
        target_2[2][7] = 0;
        target_2[3][7] = 0;
        target_2[4][7] = 0;
        target_2[5][7] = 0;
        target_2[6][7] = 0;
        target_2[7][7] = 1;
        target_2[8][7] = 0;
        target_2[9][7] = 0;
        
        //TARGET 8 AgencyFB
        target_2[0][8] = 0;
        target_2[1][8] = 0;
        target_2[2][8] = 0;
        target_2[3][8] = 0;
        target_2[4][8] = 0;
        target_2[5][8] = 0;
        target_2[6][8] = 0;
        target_2[7][8] = 0;
        target_2[8][8] = 1;
        target_2[9][8] = 0;
        
        //TARGET 9 AgencyFB
        target_2[0][9] = 0;
        target_2[1][9] = 0;
        target_2[2][9] = 0;
        target_2[3][9] = 0;
        target_2[4][9] = 0;
        target_2[5][9] = 0;
        target_2[6][9] = 0;
        target_2[7][9] = 0;
        target_2[8][9] = 0;
        target_2[9][9] = 1;
        
        //----------------
        
        //DIGITO 0 Times New Roman
        entradas_3[0][0] = 0;
        entradas_3[1][0] = 1;
        entradas_3[2][0] = 1;
        entradas_3[3][0] = 1;
        entradas_3[4][0] = 0;
        entradas_3[5][0] = 1;
        entradas_3[6][0] = 0;
        entradas_3[7][0] = 0;
        entradas_3[8][0] = 0;
        entradas_3[9][0] = 1;
        entradas_3[10][0] = 1;
        entradas_3[11][0] = 0;
        entradas_3[12][0] = 0;
        entradas_3[13][0] = 0;
        entradas_3[14][0] = 1;
        entradas_3[15][0] = 1;
        entradas_3[16][0] = 0;
        entradas_3[17][0] = 0;
        entradas_3[18][0] = 0;
        entradas_3[19][0] = 1;
        entradas_3[20][0] = 1;
        entradas_3[21][0] = 0;
        entradas_3[22][0] = 0;
        entradas_3[23][0] = 0;
        entradas_3[24][0] = 1;
        entradas_3[25][0] = 1;
        entradas_3[26][0] = 0;
        entradas_3[27][0] = 0;
        entradas_3[28][0] = 0;
        entradas_3[29][0] = 1;
        entradas_3[30][0] = 1;
        entradas_3[31][0] = 0;
        entradas_3[32][0] = 0;
        entradas_3[33][0] = 0;
        entradas_3[34][0] = 1;
        entradas_3[35][0] = 0;
        entradas_3[36][0] = 1;
        entradas_3[37][0] = 1;
        entradas_3[38][0] = 1;
        entradas_3[39][0] = 0;
        
        //DIGITO 1 Times New Roman
        entradas_3[0][1] = 0;
        entradas_3[1][1] = 0;
        entradas_3[2][1] = 1;
        entradas_3[3][1] = 0;
        entradas_3[4][1] = 0;
        entradas_3[5][1] = 0;
        entradas_3[6][1] = 1;
        entradas_3[7][1] = 1;
        entradas_3[8][1] = 0;
        entradas_3[9][1] = 0;
        entradas_3[10][1] = 0;
        entradas_3[11][1] = 0;
        entradas_3[12][1] = 1;
        entradas_3[13][1] = 0;
        entradas_3[14][1] = 0;
        entradas_3[15][1] = 0;
        entradas_3[16][1] = 0;
        entradas_3[17][1] = 1;
        entradas_3[18][1] = 0;
        entradas_3[19][1] = 0;
        entradas_3[20][1] = 0;
        entradas_3[21][1] = 0;
        entradas_3[22][1] = 1;
        entradas_3[23][1] = 0;
        entradas_3[24][1] = 0;
        entradas_3[25][1] = 0;
        entradas_3[26][1] = 0;
        entradas_3[27][1] = 1;
        entradas_3[28][1] = 0;
        entradas_3[29][1] = 0;
        entradas_3[30][1] = 0;
        entradas_3[31][1] = 0;
        entradas_3[32][1] = 1;
        entradas_3[33][1] = 0;
        entradas_3[34][1] = 0;
        entradas_3[35][1] = 0;
        entradas_3[36][1] = 1;
        entradas_3[37][1] = 1;
        entradas_3[38][1] = 1;
        entradas_3[39][1] = 0;
       
        //DIGITO 2 Times New Roman
        entradas_3[0][2] = 0;
        entradas_3[1][2] = 1;
        entradas_3[2][2] = 1;
        entradas_3[3][2] = 1;
        entradas_3[4][2] = 0;
        entradas_3[5][2] = 1;
        entradas_3[6][2] = 0;
        entradas_3[7][2] = 0;
        entradas_3[8][2] = 0;
        entradas_3[9][2] = 1;
        entradas_3[10][2] = 1;
        entradas_3[11][2] = 0;
        entradas_3[12][2] = 0;
        entradas_3[13][2] = 0;
        entradas_3[14][2] = 1;
        entradas_3[15][2] = 0;
        entradas_3[16][2] = 0;
        entradas_3[17][2] = 0;
        entradas_3[18][2] = 1;
        entradas_3[19][2] = 0;
        entradas_3[20][2] = 0;
        entradas_3[21][2] = 0;
        entradas_3[22][2] = 1;
        entradas_3[23][2] = 0;
        entradas_3[24][2] = 0;
        entradas_3[25][2] = 0;
        entradas_3[26][2] = 1;
        entradas_3[27][2] = 0;
        entradas_3[28][2] = 0;
        entradas_3[29][2] = 0;
        entradas_3[30][2] = 1;
        entradas_3[31][2] = 0;
        entradas_3[32][2] = 0;
        entradas_3[33][2] = 0;
        entradas_3[34][2] = 0;
        entradas_3[35][2] = 1;
        entradas_3[36][2] = 1;
        entradas_3[37][2] = 1;
        entradas_3[38][2] = 1;
        entradas_3[39][2] = 1;
                
        //DIGITO 3 Times New Roman
        entradas_3[0][3] = 0;
        entradas_3[1][3] = 1;
        entradas_3[2][3] = 1;
        entradas_3[3][3] = 1;
        entradas_3[4][3] = 0;
        entradas_3[5][3] = 1;
        entradas_3[6][3] = 0;
        entradas_3[7][3] = 0;
        entradas_3[8][3] = 0;
        entradas_3[9][3] = 1;
        entradas_3[10][3] = 0;
        entradas_3[11][3] = 0;
        entradas_3[12][3] = 0;
        entradas_3[13][3] = 0;
        entradas_3[14][3] = 1;
        entradas_3[15][3] = 0;
        entradas_3[16][3] = 0;
        entradas_3[17][3] = 1;
        entradas_3[18][3] = 1;
        entradas_3[19][3] = 0;
        entradas_3[20][3] = 0;
        entradas_3[21][3] = 0;
        entradas_3[22][3] = 1;
        entradas_3[23][3] = 1;
        entradas_3[24][3] = 0;
        entradas_3[25][3] = 0;
        entradas_3[26][3] = 0;
        entradas_3[27][3] = 0;
        entradas_3[28][3] = 0;
        entradas_3[29][3] = 1;
        entradas_3[30][3] = 1;
        entradas_3[31][3] = 0;
        entradas_3[32][3] = 0;
        entradas_3[33][3] = 0;
        entradas_3[34][3] = 1;
        entradas_3[35][3] = 0;
        entradas_3[36][3] = 1;
        entradas_3[37][3] = 1;
        entradas_3[38][3] = 1;
        entradas_3[39][3] = 0;
        
        //DIGITO 4 Times New Roman
        entradas_3[0][4] = 0;
        entradas_3[1][4] = 0;
        entradas_3[2][4] = 0;
        entradas_3[3][4] = 1;
        entradas_3[4][4] = 0;
        entradas_3[5][4] = 0;
        entradas_3[6][4] = 0;
        entradas_3[7][4] = 1;
        entradas_3[8][4] = 1;
        entradas_3[9][4] = 0;
        entradas_3[10][4] = 0;
        entradas_3[11][4] = 1;
        entradas_3[12][4] = 0;
        entradas_3[13][4] = 1;
        entradas_3[14][4] = 0;
        entradas_3[15][4] = 1;
        entradas_3[16][4] = 0;
        entradas_3[17][4] = 0;
        entradas_3[18][4] = 1;
        entradas_3[19][4] = 0;
        entradas_3[20][4] = 1;
        entradas_3[21][4] = 1;
        entradas_3[22][4] = 1;
        entradas_3[23][4] = 1;
        entradas_3[24][4] = 1;
        entradas_3[25][4] = 0;
        entradas_3[26][4] = 0;
        entradas_3[27][4] = 0;
        entradas_3[28][4] = 1;
        entradas_3[29][4] = 0;
        entradas_3[30][4] = 0;
        entradas_3[31][4] = 0;
        entradas_3[32][4] = 0;
        entradas_3[33][4] = 1;
        entradas_3[34][4] = 0;
        entradas_3[35][4] = 0;
        entradas_3[36][4] = 0;
        entradas_3[37][4] = 0;
        entradas_3[38][4] = 1;
        entradas_3[39][4] = 0;
        
        //DIGITO 5 Times New Roman
        entradas_3[0][5] = 0;
        entradas_3[1][5] = 0;
        entradas_3[2][5] = 1;
        entradas_3[3][5] = 1;
        entradas_3[4][5] = 1;
        entradas_3[5][5] = 0;
        entradas_3[6][5] = 1;
        entradas_3[7][5] = 0;
        entradas_3[8][5] = 0;
        entradas_3[9][5] = 0;
        entradas_3[10][5] = 1;
        entradas_3[11][5] = 0;
        entradas_3[12][5] = 0;
        entradas_3[13][5] = 0;
        entradas_3[14][5] = 0;
        entradas_3[15][5] = 1;
        entradas_3[16][5] = 1;
        entradas_3[17][5] = 1;
        entradas_3[18][5] = 1;
        entradas_3[19][5] = 0;
        entradas_3[20][5] = 0;
        entradas_3[21][5] = 0;
        entradas_3[22][5] = 0;
        entradas_3[23][5] = 0;
        entradas_3[24][5] = 1;
        entradas_3[25][5] = 0;
        entradas_3[26][5] = 0;
        entradas_3[27][5] = 0;
        entradas_3[28][5] = 0;
        entradas_3[29][5] = 1;
        entradas_3[30][5] = 1;
        entradas_3[31][5] = 0;
        entradas_3[32][5] = 0;
        entradas_3[33][5] = 0;
        entradas_3[34][5] = 1;
        entradas_3[35][5] = 0;
        entradas_3[36][5] = 1;
        entradas_3[37][5] = 1;
        entradas_3[38][5] = 1;
        entradas_3[39][5] = 0;
        
        //DIGITO 6 Times New Roman
        entradas_3[0][6] = 0;
        entradas_3[1][6] = 0;
        entradas_3[2][6] = 1;
        entradas_3[3][6] = 1;
        entradas_3[4][6] = 1;
        entradas_3[5][6] = 0;
        entradas_3[6][6] = 1;
        entradas_3[7][6] = 0;
        entradas_3[8][6] = 0;
        entradas_3[9][6] = 0;
        entradas_3[10][6] = 1;
        entradas_3[11][6] = 0;
        entradas_3[12][6] = 0;
        entradas_3[13][6] = 0;
        entradas_3[14][6] = 0;
        entradas_3[15][6] = 1;
        entradas_3[16][6] = 1;
        entradas_3[17][6] = 1;
        entradas_3[18][6] = 1;
        entradas_3[19][6] = 0;
        entradas_3[20][6] = 1;
        entradas_3[21][6] = 0;
        entradas_3[22][6] = 0;
        entradas_3[23][6] = 0;
        entradas_3[24][6] = 1;
        entradas_3[25][6] = 1;
        entradas_3[26][6] = 0;
        entradas_3[27][6] = 0;
        entradas_3[28][6] = 0;
        entradas_3[29][6] = 1;
        entradas_3[30][6] = 1;
        entradas_3[31][6] = 0;
        entradas_3[32][6] = 0;
        entradas_3[33][6] = 0;
        entradas_3[34][6] = 1;
        entradas_3[35][6] = 0;
        entradas_3[36][6] = 1;
        entradas_3[37][6] = 1;
        entradas_3[38][6] = 1;
        entradas_3[39][6] = 0;
        
        //DIGITO 7 Times New Roman
        entradas_3[0][7] = 0;
        entradas_3[1][7] = 1;
        entradas_3[2][7] = 1;
        entradas_3[3][7] = 1;
        entradas_3[4][7] = 1;
        entradas_3[5][7] = 1;
        entradas_3[6][7] = 0;
        entradas_3[7][7] = 0;
        entradas_3[8][7] = 0;
        entradas_3[9][7] = 1;
        entradas_3[10][7] = 0;
        entradas_3[11][7] = 0;
        entradas_3[12][7] = 0;
        entradas_3[13][7] = 1;
        entradas_3[14][7] = 1;
        entradas_3[15][7] = 0;
        entradas_3[16][7] = 0;
        entradas_3[17][7] = 1;
        entradas_3[18][7] = 1;
        entradas_3[19][7] = 0;
        entradas_3[20][7] = 0;
        entradas_3[21][7] = 0;
        entradas_3[22][7] = 1;
        entradas_3[23][7] = 0;
        entradas_3[24][7] = 0;
        entradas_3[25][7] = 0;
        entradas_3[26][7] = 1;
        entradas_3[27][7] = 1;
        entradas_3[28][7] = 0;
        entradas_3[29][7] = 0;
        entradas_3[30][7] = 0;
        entradas_3[31][7] = 1;
        entradas_3[32][7] = 0;
        entradas_3[33][7] = 0;
        entradas_3[34][7] = 0;
        entradas_3[35][7] = 0;
        entradas_3[36][7] = 1;
        entradas_3[37][7] = 0;
        entradas_3[38][7] = 0;
        entradas_3[39][7] = 0;
        
        //DIGITO 8 Times New Roman
        entradas_3[0][8] = 0;
        entradas_3[1][8] = 1;
        entradas_3[2][8] = 1;
        entradas_3[3][8] = 1;
        entradas_3[4][8] = 0;
        entradas_3[5][8] = 1;
        entradas_3[6][8] = 0;
        entradas_3[7][8] = 0;
        entradas_3[8][8] = 0;
        entradas_3[9][8] = 1;
        entradas_3[10][8] = 1;
        entradas_3[11][8] = 0;
        entradas_3[12][8] = 0;
        entradas_3[13][8] = 0;
        entradas_3[14][8] = 1;
        entradas_3[15][8] = 0;
        entradas_3[16][8] = 1;
        entradas_3[17][8] = 1;
        entradas_3[18][8] = 1;
        entradas_3[19][8] = 0;
        entradas_3[20][8] = 1;
        entradas_3[21][8] = 0;
        entradas_3[22][8] = 0;
        entradas_3[23][8] = 0;
        entradas_3[24][8] = 1;
        entradas_3[25][8] = 1;
        entradas_3[26][8] = 0;
        entradas_3[27][8] = 0;
        entradas_3[28][8] = 0;
        entradas_3[29][8] = 1;
        entradas_3[30][8] = 1;
        entradas_3[31][8] = 0;
        entradas_3[32][8] = 0;
        entradas_3[33][8] = 0;
        entradas_3[34][8] = 1;
        entradas_3[35][8] = 0;
        entradas_3[36][8] = 1;
        entradas_3[37][8] = 1;
        entradas_3[38][8] = 1;
        entradas_3[39][8] = 0;
       
        //DIGITO 9 Times New Roman
        entradas_3[0][9] = 0;
        entradas_3[1][9] = 1;
        entradas_3[2][9] = 1;
        entradas_3[3][9] = 1;
        entradas_3[4][9] = 0;
        entradas_3[5][9] = 1;
        entradas_3[6][9] = 0;
        entradas_3[7][9] = 0;
        entradas_3[8][9] = 0;
        entradas_3[9][9] = 1;
        entradas_3[10][9] = 1;
        entradas_3[11][9] = 0;
        entradas_3[12][9] = 0;
        entradas_3[13][9] = 0;
        entradas_3[14][9] = 1;
        entradas_3[15][9] = 0;
        entradas_3[16][9] = 1;
        entradas_3[17][9] = 1;
        entradas_3[18][9] = 1;
        entradas_3[19][9] = 1;
        entradas_3[20][9] = 0;
        entradas_3[21][9] = 0;
        entradas_3[22][9] = 0;
        entradas_3[23][9] = 0;
        entradas_3[24][9] = 1;
        entradas_3[25][9] = 0;
        entradas_3[26][9] = 0;
        entradas_3[27][9] = 0;
        entradas_3[28][9] = 1;
        entradas_3[29][9] = 1;
        entradas_3[30][9] = 0;
        entradas_3[31][9] = 0;
        entradas_3[32][9] = 1;
        entradas_3[33][9] = 1;
        entradas_3[34][9] = 0;
        entradas_3[35][9] = 0;
        entradas_3[36][9] = 1;
        entradas_3[37][9] = 1;
        entradas_3[38][9] = 0;
        entradas_3[39][9] = 0;
        
	//TARGET 0 Times New Roman
        target_3[0][0] = 1;
        target_3[1][0] = 0;
        target_3[2][0] = 0;
        target_3[3][0] = 0;
        target_3[4][0] = 0;
        target_3[5][0] = 0;
        target_3[6][0] = 0;
        target_3[7][0] = 0;
        target_3[8][0] = 0;
        target_3[9][0] = 0;
        
        //TARGET 1 Times New Roman
        target_3[0][1] = 0;
        target_3[1][1] = 1;
        target_3[2][1] = 0;
        target_3[3][1] = 0;
        target_3[4][1] = 0;
        target_3[5][1] = 0;
        target_3[6][1] = 0;
        target_3[7][1] = 0;
        target_3[8][1] = 0;
        target_3[9][1] = 0;
        
        //TARGET 2 Times New Roman
        target_3[0][2] = 0;
        target_3[1][2] = 0;
        target_3[2][2] = 1;
        target_3[3][2] = 0;
        target_3[4][2] = 0;
        target_3[5][2] = 0;
        target_3[6][2] = 0;
        target_3[7][2] = 0;
        target_3[8][2] = 0;
        target_3[9][2] = 0;
        
        //TARGET 3 Times New Roman
        target_3[0][3] = 0;
        target_3[1][3] = 0;
        target_3[2][3] = 0;
        target_3[3][3] = 1;
        target_3[4][3] = 0;
        target_3[5][3] = 0;
        target_3[6][3] = 0;
        target_3[7][3] = 0;
        target_3[8][3] = 0;
        target_3[9][3] = 0;
        
        //TARGET 4 Times New Roman
        target_3[0][4] = 0;
        target_3[1][4] = 0;
        target_3[2][4] = 0;
        target_3[3][4] = 0;
        target_3[4][4] = 1;
        target_3[5][4] = 0;
        target_3[6][4] = 0;
        target_3[7][4] = 0;
        target_3[8][4] = 0;
        target_3[9][4] = 0;
        
        //TARGET 5 Times New Roman
        target_3[0][5] = 0;
        target_3[1][5] = 0;
        target_3[2][5] = 0;
        target_3[3][5] = 0;
        target_3[4][5] = 0;
        target_3[5][5] = 1;
        target_3[6][5] = 0;
        target_3[7][5] = 0;
        target_3[8][5] = 0;
        target_3[9][5] = 0;
        
        //TARGET 6 Times New Roman
        target_3[0][6] = 0;
        target_3[1][6] = 0;
        target_3[2][6] = 0;
        target_3[3][6] = 0;
        target_3[4][6] = 0;
        target_3[5][6] = 0;
        target_3[6][6] = 1;
        target_3[7][6] = 0;
        target_3[8][6] = 0;
        target_3[9][6] = 0;
        
        //TARGET 7 Times New Roman
        target_3[0][7] = 0;
        target_3[1][7] = 0;
        target_3[2][7] = 0;
        target_3[3][7] = 0;
        target_3[4][7] = 0;
        target_3[5][7] = 0;
        target_3[6][7] = 0;
        target_3[7][7] = 1;
        target_3[8][7] = 0;
        target_3[9][7] = 0;
       
        //TARGET 8 Times New Roman
        target_3[0][8] = 0;
        target_3[1][8] = 0;
        target_3[2][8] = 0;
        target_3[3][8] = 0;
        target_3[4][8] = 0;
        target_3[5][8] = 0;
        target_3[6][8] = 0;
        target_3[7][8] = 0;
        target_3[8][8] = 1;
        target_3[9][8] = 0;
       
        //TARGET 9 Times New Roman
        target_3[0][9] = 0;
        target_3[1][9] = 0;
        target_3[2][9] = 0;
        target_3[3][9] = 0;
        target_3[4][9] = 0;
        target_3[5][9] = 0;
        target_3[6][9] = 0;
        target_3[7][9] = 0;
        target_3[8][9] = 0;
        target_3[9][9] = 1;
        
        
    }
    
    
    public static void clean(){
        for(int i=0;i<ROW_COUNT*COLUMN_COUNT;i++){
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

package perceptronM.Common;

import perceptronM.Model.Const;

/**
 *
 * @author PRETXEL-H
 */
public final class Matriz {  
    /** 
     * Multiplica dos matrices 
     * @param int[][] A 
     * @param int[][] B 
     * @return int[][] producto 
     */  
    public static float[][] producto(float A[][], float B[][]){  
        float suma = (float) 0.0;  
        int columnasa = A[0].length;
        float result[][] = new float[A.length][B[0].length];  
        for(int i = 0; i < A.length; i++){  
            for(int j = 0; j < B[0].length; j++){  
                suma = 0;  
                for(int k = 0; k < columnasa; k++){  
                    suma += A[i][k] * B[k][j];  
                }  
                result[i][j] = suma;  
            }  
        }  
        return result;  
    }
    
    
    public static float[][] copy(float A[][],int letra){
        
        float C[][] = new float[Const.ROW_COUNT*Const.ROW_COUNT][1];
        for (int i=0;i<(Const.ROW_COUNT*Const.ROW_COUNT);i++){
            C[i][0] = A[i][letra];
        }
        return C;
    }
    
    public static float[][] suma(float A[][], float B[][]){
        
        float result[][] = new float[A.length][A[0].length];
        for (int i=0;i<A[0].length;i++){
            for(int j=0;j<A.length;j++){
                result[j][i] = A[j][i] + B[j][i];
            }
        }
    return result;
    }
    
     public static float[][] resta(float A[][], float B[][], int letra){
        
        float result[][] = new float[A.length][B[0].length];
        for (int i=0;i<B[0].length;i++){
            for(int j=0;j<A.length;j++){
                result[j][i] = A[j][letra] - B[j][i];
            }
        }
    return result;
    }
    
    public static float[][] transpuesta(float T[][]){
        float result[][] = new float[T[0].length][T.length];
        
        for (int i=0;i<T[0].length;i++){
            for(int j=0;j<T.length;j++){
              result[i][j] = T[j][i];  
            }
        }
        return result;
    }
    
} 
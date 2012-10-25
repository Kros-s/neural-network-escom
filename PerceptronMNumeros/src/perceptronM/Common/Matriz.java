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
        
        float C[][] = new float[A.length][1];
        for (int i=0;i<(Const.ROW_COUNT*Const.COLUMN_COUNT);i++){
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
    
     public static float[][] resta(float A[][], float B[][], int numero){
        
        float result[][] = new float[A.length][B[0].length];
        for (int i=0;i<B[0].length;i++){
            for(int j=0;j<A.length;j++){
                result[j][i] = A[j][numero] - B[j][i];
            }
        }
    return result;
    }
     
      public static float[][] resta(int num, float A[][]){
        
        float result[][] = new float[A.length][A[0].length];
        for (int i=0;i<A[0].length;i++){
            for(int j=0;j<A.length;j++){
                result[j][i] = num - A[j][i];
            }
        }
    return result;
    }
    
     public static float[][] resta_M(float A[][], float B[][]){
        
        float result[][] = new float[A.length][B[0].length];
        for (int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                result[i][j] = A[i][j] - B[i][j];
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
    
    public static float[][] identidad(float a[][]){
        float result[][] = new float[a.length][a.length];
        
        for (int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                if (i==j){
                    //result[i][j] = a[i][0];
                    result[i][j] = (1-a[i][0]) * a[i][0];
                }else{
                    result[i][j] = 0;
                }
                
               }
        }
        return result;
    }
    
    public static float[][] producto_escalar(float a[][], float escalar){
        float [][] res = new float[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                res[i][j] = escalar * a[i][j]; 
            }
        }
        return res;
    }
    public static float[][] zeros(float a[][]){
        float [][] res = new float[a.length][a[0].length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                res[i][j]=0;
            }
        }
        return res;
    }
    
    public static float[][][] zeros(float a[][][]){
        float [][][] res = new float[a.length][a[0].length][a[0][0].length];
        for(int k=0;k<a.length;k++){
            for(int i=0;i<a[0].length;i++){
                for(int j=0;j<a[0][0].length;j++){
                    res[i][j][k]=0;
                }
            }
        }
        return res;
    }
} 
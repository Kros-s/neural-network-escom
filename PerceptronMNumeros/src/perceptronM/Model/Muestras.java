package perceptronM.Model;
/**
 *
 * @author Marko
 */
public class Muestras {
    private Logic data;
    // Guardo toda la clase Logic que contiene los pesos y el umbral
    // Permitiendome asi utilizar los datos para verificar cual es la 
    // Mejor implementacion del algoritmo
    public Muestras(Logic a){
        data = a;
    }

    public Logic getLogic(){
        return data;
    }

}

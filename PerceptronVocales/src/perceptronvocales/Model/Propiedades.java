
package perceptronvocales.Model;
import java.io.*;
import java.util.Properties;
/**
 *
 * @author Israel
 */
public class Propiedades {
    public Properties propiedades = null;
    private String archivo = null;
    public static FileOutputStream file = null;
    
    
    public Propiedades(String txt){
        this.archivo = txt;
        this.propiedades = new Properties();
    }
    
    /*public Propiedades(String archivo){
        propiedades = new Properties();
        this.archivo=archivo;
    }*/
    public  boolean cargarPropiedades(){
        try{
            propiedades.load(new FileInputStream(archivo));
            return true;
        } catch (IOException e){
            return false;
        }
    }
    
    public  float leerPropiedad(String propiedad){
        String v=new String(propiedades.getProperty(propiedad));
        return Float.parseFloat(v);
    
    }
    
    public int leerPropiedad_Int(String propiedad){
        String v=new String(propiedades.getProperty(propiedad));
        return Integer.parseInt(v);
    }
    
    public char leerPropiedad_Char(String propiedad){
        String v=new String(propiedades.getProperty(propiedad));
        return (v.charAt(0));
    }
    
    
    public  boolean abrirPropiedad() throws FileNotFoundException{
     
        file=new FileOutputStream(archivo.toString().replace("\\", "/"));
        if (file !=null){
            return false;
        }
        return true;
    }
    
    public boolean cerrarPropiedad() throws IOException{
        propiedades.store(file,null);
        file.close();
        return true;
    }
    
    
    public  boolean cambiarPropiedad(String propiedad, String valor){
        propiedades.setProperty(propiedad,valor);
        return true;
        
    }
    
    public boolean existeArchivo(){
        File file_ex=new File(archivo);
        return file_ex.exists();
    }
    
 }

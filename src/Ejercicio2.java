import java.io.File;
import java.io.InputStream;

public class Ejercicio2 {

    /*Partiendo del código anterior,
    crea un programa que muestre el árbol de carpetas de un directorio recibido como parámetro por la entrada estándar. */

    public static void main(String[] args) {
        Process proceso;
        File file = new File(".\\bin");

        ProcessBuilder processBuilder = new ProcessBuilder("java", "Ejercicio1", "..\\");
        processBuilder.directory(file);

        try {
            int caracterUnicode;
            proceso = processBuilder.start();

            InputStream inputStream = proceso.getInputStream(); 

            while ((caracterUnicode = inputStream.read())!= -1) {

                System.out.print((char)caracterUnicode);
                
            }
            
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}

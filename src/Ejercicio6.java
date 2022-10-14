import java.io.File;
import java.io.InputStream;

public class Ejercicio6 {
    /*Crea un programa para ejecutar Ejercicio5.
    Muestra por pantalla el valor de salida comprobando 
    tanto el caso correcto como el incorrecto. */
    public static void main(String[] args) {
        File file = new File(".\\bin");
        Process proceso;

        ProcessBuilder processBuilder = new ProcessBuilder("java","Ejercicio5");
        processBuilder.directory(file);

        try {
            int caracterUnicode;
            proceso = processBuilder.start();
            InputStream inputStream = proceso.getInputStream();

            while ((caracterUnicode = inputStream.read()) != -1) {
                System.out.print((char)caracterUnicode);
            }

            try {
                int valorDeSalida = proceso.waitFor();
                System.out.println("el valor de salida es: "+valorDeSalida);
            
            } catch (InterruptedException interruptedException) {
                
                interruptedException.printStackTrace();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}

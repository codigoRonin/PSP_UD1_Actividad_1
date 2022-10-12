import java.io.InputStream;

public class Ejercicio1 {

    /*Crea un programa que invoque al comando Tree sobre la carpeta del proyecto y muestra su salida.*/
    public static void main(String[] args) {

        ProcessBuilder processBuilder = new ProcessBuilder("cmd","/C","tree");
        Process process;

        try {

            int caracterUnicode;
            
            process = processBuilder.start();
            InputStream inputStream = process.getInputStream();

            while ((caracterUnicode = inputStream.read()) != -1) {
                
                System.out.print((char)caracterUnicode);
                
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}

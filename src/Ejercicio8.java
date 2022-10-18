import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio8 {
    public static void main(String[] args) {

        File directorio = new File(".\\bin");
        ProcessBuilder processBuilder = new ProcessBuilder("java","Ejercicio7","Jasi hhhn hhh");
        processBuilder.directory(directorio);
        Process proceso = null;

        try {

            proceso = processBuilder.start();
         
            //Creamos un inputStream para leer la salida 
            InputStream salida = proceso.getInputStream();
            int caracter;
            while ((caracter = salida.read()) != -1) {
                System.out.print((char) caracter);
            }
            salida.close();
            
            //Hacemos otro inputStream para leer en caso de que salga el error
            try {
                int valorSalida = proceso.waitFor();
                System.out.println(valorSalida);
                if (valorSalida != 0) {
                    InputStream errorSalida = proceso.getErrorStream();

                    BufferedReader bufferError = new BufferedReader(new InputStreamReader(errorSalida));
                    String linea;
                    while ((linea = bufferError.readLine()) != null) {
                        System.out.println("Error: " + linea);

                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
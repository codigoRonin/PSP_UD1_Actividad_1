import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio1 {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd","/c", "tree");

        Process proceso = null;

        try {
            proceso = processBuilder.start();
            InputStream inputStream = proceso.getInputStream();
            int caracter;
            while ((caracter = inputStream.read()) != -1) {
                System.out.print((char) caracter);
            }
            inputStream.close();

            try {
                int valorSalida = proceso.waitFor();

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

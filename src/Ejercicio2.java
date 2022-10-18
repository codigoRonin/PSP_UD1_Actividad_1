import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "tree");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduzca la ruta: ");
        String ruta = scanner.next();
        File file = new File(ruta);

        processBuilder.directory(file);

        try{
            Process process = processBuilder.start();

            InputStream inputStream = process.getInputStream();
            int byteInputStream;
            while((byteInputStream = inputStream.read()) != -1){
                System.out.print((char) byteInputStream);
            }
            inputStream.close();

            if(process.waitFor() != 0) {
                InputStream inputStreamError = process.getErrorStream();
                BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStreamError)
                );
                String linea;
                while((linea = bufferedReader.readLine()) != null) {
                    System.out.println("Error ->: " + linea);
                }
                inputStreamError.close();
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
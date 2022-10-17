import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        System.out.print("Introduzca la ruta: ");
        String ruta = stdin.next();

        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "tree", ruta);

        stdin.close();
        try{
            Process process = processBuilder.start();

            InputStream inputStream = process.getInputStream();
            int byteInputStream;
            while((byteInputStream = inputStream.read()) != -1){
                System.out.print((char) byteInputStream);
            }
            inputStream.close();

            if(process.waitFor() != 0) {
                InputStream inputStreamErr = process.getErrorStream();
                BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStreamErr)
                );
                String lineaInputStreamErr;
                while((lineaInputStreamErr = bufferedReader.readLine()) != null) {
                    System.out.println("Error ->: " + lineaInputStreamErr);
                }
                inputStreamErr.close();
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

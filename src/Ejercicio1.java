import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Ejercicio1 {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "treee");
        File file = new File(".");
        processBuilder.directory(file);
        Process process;

        try{
            process = processBuilder.start();
            InputStream inputStream = process.getInputStream();

            int byteInputStream;
            while((byteInputStream = inputStream.read()) != -1){
                System.out.print((char) byteInputStream);
            }
            inputStream.close();

            if (process.waitFor() != 0){
                InputStream inputStreamError = process.getErrorStream();
                int byteInputStreamError;
                System.out.print("Error ->: \n\t");
                while((byteInputStreamError = inputStreamError.read()) != -1){
                    System.out.print((char) byteInputStreamError);
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

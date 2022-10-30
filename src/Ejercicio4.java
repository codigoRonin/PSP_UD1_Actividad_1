import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio4 {
    private static final String RUTA = "./bin";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = obtenerNumero(scanner);
        
        String string = String.valueOf(num);
        File directorio = new File(RUTA);

        ProcessBuilder processBuilder = new ProcessBuilder("java", "Ejercicio3", string);
        processBuilder.directory(directorio);
        try{
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream)
            );
            String linea;
            while((linea = bufferedReader.readLine()) != null) {
                int numero = Integer.parseInt(linea);
                System.out.println(numero*numero);
            }
            inputStream.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }



    public static int obtenerNumero(Scanner scanner) {
        System.out.println("Introduzca un número: ");
        try {
            int num = scanner.nextInt();
            return num;
        } catch (NumberFormatException exNumberFormatException) {
            System.out.println("Debe introducir un número.");
            return obtenerNumero(scanner);
        }
    }
}

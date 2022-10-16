import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un numero");
        int numero = scanner.nextInt();
        scanner.close();

        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio3",String.valueOf(numero*numero));
        File directorio = new File(".\\bin");
        pb.directory(directorio);
        Process proceso = null;

        try {
            proceso = pb.start();

            InputStream readData = proceso.getInputStream();
            
            int byyte;
            while((byyte = readData.read()) != -1){
                //imprimir cada cracter
                System.out.print((char)byyte);
            }
            readData.close();
            int valorSalida = proceso.waitFor();
            System.out.println("El valor de salida es: " + valorSalida);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

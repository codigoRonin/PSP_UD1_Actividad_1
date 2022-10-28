import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.print("Introduzca información: ");
        String inputString = stdin.nextLine();
        stdin.close();

        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio7", inputString);
        pb.directory(new File("./bin"));

        try {
            Process proceso = pb.start();
            int valorSalida = proceso.waitFor();
            System.out.println("El valor de salida es: " + valorSalida);
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero");
        final int num = sc.nextInt();
        sc.close();

        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio3", String.valueOf(num*num));
        pb.directory(new File("./bin"));
        Process proceso = null;

        try {
            proceso = pb.start();
            InputStream is = proceso.getInputStream();
            int c = 0;
            while ((c = is.read()) != -1) {
                System.out.print((char) c);
            }
            is.close();

            int valorSalida = proceso.waitFor();
            System.out.println("El valor de salida es: " + valorSalida);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el directorio para ejecutar el comando TREE: ");
        String ruta= sc.nextLine();
        sc.close();

        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "Tree", ruta); //k para que no termine el cmd
        Process proceso;

        try {

            proceso = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea = null;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();

            System.out.println("El valor de salida es " + proceso.waitFor());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

}

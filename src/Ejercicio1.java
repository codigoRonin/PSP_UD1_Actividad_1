import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "Tree"); //k para que no termine el cmd
        
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

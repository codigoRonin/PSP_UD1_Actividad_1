import java.io.InputStream;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el directorio");
        String directorio = scanner.nextLine();
        scanner.close();
        
        ProcessBuilder pBuilder = new ProcessBuilder("cmd","/c", "tree", directorio);
        Process proceso = null;

        try {
            proceso = pBuilder.start();
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
            e.printStackTrace();
        }

        
    }
   
}

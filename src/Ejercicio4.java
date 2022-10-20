import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class Ejercicio4 {
    /*Crea un programa que, ejecutando Ejercicio3, nos calcule el cuadrado del factorial de un número dado por teclado.*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Process proceso;
       
        System.out.println("Introduce numero por teclado");
        String numeroTeclado = String.valueOf(scanner.nextInt());

        File file = new File(".\\bin");
        
        ProcessBuilder processBuilder = new ProcessBuilder("java", "Ejercicio3",numeroTeclado);

        processBuilder.directory(file);

        try {
            int caracterUnicode;
            proceso = processBuilder.start();

            InputStream inputStream = proceso.getInputStream();
            String output = "";

            while ((caracterUnicode = inputStream.read()) != -1) {
                //System.out.print((char)caracterUnicode);
                output =  output + (char)caracterUnicode;
                
            }

            inputStream.close();
            double numero = Double.parseDouble(output);
            
            //double numero = Double.parseDouble(output.split(": ")[1].replaceAll("\r\n", ""));

            // String [] cadena = output.split(": ");//guardado en dos posiciones en array
            // cadena[1] = cadena[1].replaceAll("\r\n","");//me quedo con posicion 1 y suprimo el ln
            // double numero = Double.parseDouble(cadena[1]);//transformo string a double
            
            System.out.println("el resultado al cuadrado es: " + numero*numero);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}

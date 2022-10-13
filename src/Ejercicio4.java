import java.io.File;
import java.io.InputStream;

public class Ejercicio4 {
    public static void main(String[] args) {
        
        /*Crea un programa que, ejecutando Ejercicio3, nos calcule el cuadrado del factorial de un número dado por teclado.*/
        Process proceso;
        File file = new File(".\\bin");

        ProcessBuilder processBuilder = new ProcessBuilder("java", "Ejercicio3","10");

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

            System.out.print(output);
            
            double numero = Integer.parseInt(output.split(": ")[1].replaceAll("\r\n", ""));

            // String [] cadena = output.split(": ");//guardado en dos posiciones en array
            // cadena[1] = cadena[1].replaceAll("\r\n","");//me quedo con posicion 1 y suprimo el ln
            // int numero = Integer.parseInt(cadena[1]);//transformo string a int
            
            System.out.println("el resultado al cuadrado es: " + numero*numero);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}

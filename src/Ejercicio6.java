import java.io.File;
import java.io.InputStream;

public class Ejercicio6 {
    
    public static void main(String[] args) {
        
        //proceso correcto
        
        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio5", "Cora");
        File directorio = new File(".\\bin");
        pb.directory(directorio);
        Process proceso= null;

        try {

            proceso = pb.start();
            InputStream readData = proceso.getInputStream();
            
            int byyte;

            while((byyte = readData.read()) != -1){
              
                System.out.print((char)byyte);
            }
            readData.close();

            int valorSalida = proceso.waitFor();
            System.out.println("El valor de salida es: " + valorSalida);             
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        //////////////////////////////////////////////////////////////////////
        // proceso incorrecto

        ProcessBuilder pb2 = new ProcessBuilder("java", "Ejercicio5");
        Process proceso2= null;
      
        pb2.directory(directorio);
        try {

            proceso2 = pb2.start();
            InputStream readData2 = proceso2.getInputStream();
            
            int byyte2;

            while((byyte2 = readData2.read()) != -1){
              
                System.out.print((char)byyte2);
            }
            readData2.close();

            int valorSalida2 = proceso2.waitFor();
            System.out.println("El valor de salida es: " + valorSalida2);             
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

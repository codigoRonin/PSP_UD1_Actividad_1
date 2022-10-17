import java.io.InputStream;

public class Ejercicio1 {
    public static void main(String[] args) {

        ProcessBuilder pBuilder = new ProcessBuilder("cmd","/c", "tree");
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

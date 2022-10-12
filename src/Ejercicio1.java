import java.io.InputStream;

public class Ejercicio1 {

    /*Crea un programa que invoque al comando Tree sobre la carpeta del proyecto y muestra su salida.*/
    public static void main(String[] args) {
       
        String ruta = args.length== 0 ? "..\\" : args[0];//si array vacio asignamos ruta defecto, sino la que viene por parametros

        // String ruta = args[0];
        // if(ruta == null){
        //     ruta = "..\\";
        // }
        
        ProcessBuilder processBuilder = new ProcessBuilder("cmd","/C","tree",ruta);
        Process process;

        try {

            int caracterUnicode;
            
            process = processBuilder.start();
            InputStream inputStream = process.getInputStream();

            while ((caracterUnicode = inputStream.read()) != -1) {
                
                System.out.print((char)caracterUnicode);
                
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}

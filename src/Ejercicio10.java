import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner stdin= new Scanner(System.in);
		System.out.print("Introduzca una frase o pulsa enter: ");
		String inputString=stdin.nextLine();
		stdin.close();
        
		ProcessBuilder pb= new ProcessBuilder("java", "Ejercicio9", inputString );
		pb.directory(new File("./bin"));
		try {
			Process p= pb.start();
			InputStream is=p.getInputStream();
			int c=0;
			while((c=is.read())!=-1) {
				System.out.print((char)c);
			}
			is.close();			
			int valorSalida=p.waitFor();
			if(valorSalida!=0) {
				InputStream errorIs= p.getErrorStream();
				c=0;
				while((c=errorIs.read())!=-1) {
					System.out.print((char)c);
				}
				errorIs.close();
			}			
			
			System.out.println("El valor de salida es: "+ valorSalida);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}

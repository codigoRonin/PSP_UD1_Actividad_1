import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Ejercicio10 {
	/*Crea un programa que ejecute Ejercicio9, este programa debe solicitar por teclado una cadena y
	 enviarla al proceso, mostrando en ambos casos el resultado por pantalla. */
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		String cadena = pedirCadena();

		File file = new File(".\\bin");
		Process proceso;
		
		ProcessBuilder processBuilder = new ProcessBuilder("java","Ejercicio9",cadena);
		
		processBuilder.directory(file);

		try {

			int caracterUnicode;
			proceso = processBuilder.start();
			InputStream inputStream = proceso.getInputStream();

			while ((caracterUnicode = inputStream.read())!= -1) {
				System.out.print((char)caracterUnicode);
			}

			try {

				int valorDeSalida = proceso.waitFor();
				System.out.println("El valor de salida es: "+valorDeSalida);

			} catch (InterruptedException exception) {
				
				exception.printStackTrace();
			}

		} catch (IOException exception) {
			
			exception.printStackTrace();
		}

	}

	public static String pedirCadena(){

		System.out.println("introduce cadena");
		return scanner.nextLine();
	}
}

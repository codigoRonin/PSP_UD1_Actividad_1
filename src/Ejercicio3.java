import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        int resultado = 1;
        int contador = 1;
        System.out.println("Introduce un numero");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int finalResult = factorial(number,resultado, contador);
        System.out.println("El factorial de "+number+" es "+finalResult);
    }

    public static int factorial(int number, int resultado, int contador){

        if(contador<=number){
            resultado *=contador;
            contador++;
            return factorial(number,resultado, contador);
        }
        return resultado;
    }
}

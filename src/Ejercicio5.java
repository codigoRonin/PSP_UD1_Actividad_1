public class Ejercicio5 {
/*Crea un programa que reciba desde los argumentos del método Main() un nombre y lo visualice en pantalla. 
Utiliza valor 0 para una finalización correcta y valor 
-1 para el caso de que no se hayan introducido argumentos correctos en el main. */
    public static void main(String[] args) {
                
        try {

            System.out.println("hola "+ args[0]);
            System.exit(0);

        } catch (ArrayIndexOutOfBoundsException exception) {

            exception.printStackTrace();
            System.exit(-1);
        }
    }
}

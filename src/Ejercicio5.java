public class Ejercicio5 {
    /*Crea un programa que reciba desde los argumentos del método Main() un nombre y lo visualice en pantalla. 
    Utiliza valor 0 para una finalización correcta y valor -1 para el caso de que no se hayan introducido argumentos correctos en el main.
     */
    public static void main(String[] args) {

        String nombre = args.length == 0 ? "sergio" : args[0];//if ternario, si array vacio es sergio, sino posicion 0

        System.out.println("hola "+nombre);

    }
}

public class Ejercicio7 {
    /*Crea un programa en Java que admita argumentos desde el método main() y devuelva con System.exit() 
    los siguientes valores:

    a. Si el número de argumentos es <1 debe devolver 1 
    b. Si el argumento es una cadena debe devolver 2 --> args[0] es string
    c. Si el argumento es un número menor que 0 debe devolver 3 --> args[0] <0 
    d. En cualquier otro caso devolverá 0. else*/

    public static void main(String[] args) {
        
        int numero = Integer.parseInt(args[0]);

        if(args.length < 1){
            System.exit(1);

        // }else if(){

        }else if(numero < 0){
            System.exit(3);

        }else{
            System.exit(0);

        }
      

        

    }
}

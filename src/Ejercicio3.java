public class Ejercicio3 {
    /*
     * Crea un programa sencillo que calcule el factorial de un número recibido como
     * parámetro del método main.(Utiliza Recursividad)
     */
    public static void main(String[] args) {
        
        double numero = factorial (Double.parseDouble(args[0]));

        //System.out.println("el resultado es: "+numero);
        System.out.print(numero);
  
    }

    public static double factorial (double numero){
        
        if (numero == 1){
            return 1;
        }
    
        return numero* factorial(numero-1);
    }
 
}

public class Ejercicio3 {
    /*
     * Crea un programa sencillo que calcule el factorial de un número recibido como
     * parámetro del método main.(Utiliza Recursividad)
     */
    public static void main(String[] args) {

        int numero = args.length == 0 ? 7 : Integer.parseInt(args[0]);
         
        System.out.println("el resultado es: " + calculoFactorial(numero, 1, 1));
        
        //int resultado = 1;
        // for (int i = 1; i <= numero; i++) {
        // resultado*=i;
        // System.out.println(i +" : "+ resultado);
        // }
        // System.out.println("el resultado es: "+resultado);
  
    }

    public static double calculoFactorial(int numeroARGS, double resultado,int contador){
        
        resultado*=contador;
        //System.out.println(contador +" : "+ resultado);
        if(contador++ < numeroARGS){
            return calculoFactorial(numeroARGS,resultado,contador);
        }
                
        return resultado;
    }

}

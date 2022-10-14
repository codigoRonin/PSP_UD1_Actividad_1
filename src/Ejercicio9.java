public class Ejercicio9 {

    /*Crea un programa que visualice 5 veces la cadena que se le envía como parámetro del main().
     Si no se le envía ninguna cadena debe mostrar un mensaje indicandolo y finalizar el programa con valor de salida 1. */
    public static void main(String[] args) throws Exception {
       
        try {

            comprobarCadena(args);
            imprimirCadena(args);
        
        } catch (ArrayIndexOutOfBoundsException exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    
    }

    private static void comprobarCadena(String[] args) throws Exception{
        if(args[0].equals("")){
            throw new Exception("Cadena vacia");
        }
    }

    private static void imprimirCadena(String[] args){
        
        for (int i = 0; i < 5; i++) {
            System.out.println(i+" - "+args[0]);
            
        }
        
        System.exit(0);
    }
}

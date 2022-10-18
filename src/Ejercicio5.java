public class Ejercicio5 {
    /**
     * @param args
     */
    public static void main(String[] args) {

        if (args.length != 1) {
            System.exit(-1);
        }

        String nombre = args[0];
        System.out.println("El nombre es: " + nombre);
    }
}

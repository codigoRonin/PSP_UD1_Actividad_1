public class Ejercicio9 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No hay cadena");
        } else {
            for (int i = 0; i < 5; i++) {
                System.out.println(args[0]);
            }
        }

    }
}

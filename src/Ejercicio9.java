public class Ejercicio9 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Sin datos");
            System.exit(1);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(args[0]);
        }
    }
}

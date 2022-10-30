
public class Ejercicio3 {
    public static void main(String[] args) {

        if ((args.length != 0) && isInt(args[0]) ) {
            int num = Integer.parseInt(args[0]);
            System.out.println(factorial(num));
        }

    }

    public static int factorial (int numero) {
        if (numero == 0) {
            return 1;
        }
            
        return (numero*factorial(numero-1));
    }

    public static boolean isInt (String string) {
        try{
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        System.out.println(factorial(num));
    }

    public static int factorial(int num) {
        if (num == 0)
            return 1;
        return num * factorial(num - 1);
    }
}

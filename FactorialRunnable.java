import java.math.BigInteger;

public class RunnableHomeWork implements Runnable {

    private final int number;

    public RunnableHomeWork(int number) {
        this.number = number;
    }

    public void run() {
        BigInteger result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }

    private BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Es necesario ingresar los datos desde la linea de comandos");
            return;
        }

        for (String arg : args) {
            try {
                int number = Integer.parseInt(arg);
                Thread t = new Thread(new RunnableHomeWork(number));
                t.start();
            } catch (NumberFormatException e) {
                System.out.println("Invalid number: " + arg);
            }
        }
    }
}







import java.util.*;

public class demo {
    static Scanner sc = new Scanner(System.in);
    int n = 10;

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

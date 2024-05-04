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

    public static void main(String[] args) {
        var n = sc.nextInt();
        var mapCount = new HashMap<Integer, Integer>();

        // 10 0 1993 =>
        for (var i = 0; i < n; i++) {
            var day = sc.nextInt();
            var month = sc.nextInt();
            var year = sc.nextInt();
            var key = sc.nextInt();
            mapCount.put(key, mapCount.getOrDefault(key, 0) + 1);
        }

        var list = new ArrayList<>(mapCount.keySet());
        list.sort(null);
        for (var key : list) {
            var year = key / 10000;
            var month = (key % 10000) / 100;
            var day = key % 100;
            System.out.println(day + "/" + month + "/" + year + " " + mapCount.get(key));
        }
    }
}

import java.util.*;

public class EIUPH011 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();

        }

        ArrayList<Integer> b = new ArrayList<>();
        for (int value : a) {
            if (!b.contains(value)) {
                b.add(value);
                System.out.print(value + " ");
            }
        }
    }
}
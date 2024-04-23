import java.util.Arrays;
import java.util.Scanner;

public class EIPAGES {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();

        int[] pages = new int[n];
        for (int i = 0; i < n; i++) {
            pages[i] = scanner.nextInt();
        }

        Arrays.sort(pages);

        for (int i = 0; i < n; i++) {
            int start = pages[i];
            int end = start;
            while (i + 1 < n && pages[i + 1] == end + 1) {
                end = pages[i + 1];
                i++;
            }
            if (start == end) {
                System.out.print(start + " ");
            } else if (start + 1 == end) {
                System.out.print(start + " " + end + " ");
            } else {
                System.out.print(start + "-" + end + " ");
            }
        }
    }
}

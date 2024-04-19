import java.util.Arrays;
import java.util.Scanner;

public class EIPAGES {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Read the number of page numbers
        int n = scanner.nextInt();

        // Read the page numbers into an array
        int[] pages = new int[n];
        for (int i = 0; i < n; i++) {
            pages[i] = scanner.nextInt();
        }

        // Sort the array
        Arrays.sort(pages);

        // Iterate through the array to print the pages
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

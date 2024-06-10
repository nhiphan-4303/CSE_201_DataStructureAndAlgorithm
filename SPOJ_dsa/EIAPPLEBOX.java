import java.io.*;
import java.util.*;

public class EIAPPLEBOX {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int p = sc.nextInt();
            int[] arr = new int[n];

            arr[0] = (int) ((long) a * a % p);
            for (int i = 1; i < n; i++) {
                arr[i] = (int) ((long) arr[i - 1] * a % p);
            }

            long inversions = countInversions(arr, 0, n - 1);
            sb.append(inversions).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static long countInversions(int[] arr, int from, int to) {
        if (from < to) {
            int middle = (from + to) / 2;
            long inversions = 0;

            inversions += countInversions(arr, from, middle);
            inversions += countInversions(arr, middle + 1, to);

            inversions += mergeAndCount(arr, from, middle, to);

            return inversions;
        }
        return 0;
    }

    public static long mergeAndCount(int[] arr, int from, int middle, int to) {
        int n1 = (middle - from) + 1;
        int n2 = to - middle;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, from, leftArr, 0, n1);
        System.arraycopy(arr, middle + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = from;
        long inversions = 0;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                inversions += (n1 - i); // count the inversions
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

        return inversions;
    }

    static class InputReader {

        StringTokenizer tokenizer;

        BufferedReader reader;

        String token;

        String temp;

        public InputReader(InputStream stream) {

            tokenizer = null;

            reader = new BufferedReader(new InputStreamReader(stream));

        }

        public InputReader(FileInputStream stream) {

            tokenizer = null;

            reader = new BufferedReader(new InputStreamReader(stream));

        }

        public String nextLine() throws IOException {

            return reader.readLine();

        }

        public String next() {

            while (tokenizer == null || !tokenizer.hasMoreTokens()) {

                try {

                    if (temp != null) {

                        tokenizer = new StringTokenizer(temp);

                        temp = null;

                    } else {

                        tokenizer = new StringTokenizer(reader.readLine());

                    }

                } catch (IOException e) {

                }

            }

            return tokenizer.nextToken();

        }

        public double nextDouble() {

            return Double.parseDouble(next());

        }

        public int nextInt() {

            return Integer.parseInt(next());

        }

        public long nextLong() {

            return Long.parseLong(next());

        }

    }
}

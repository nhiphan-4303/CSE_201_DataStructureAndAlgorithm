import java.io.*;
import java.util.*;

public class EIUMEDARRAY4 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            long N = sc.nextLong();
            long A = sc.nextLong();
            long P = sc.nextLong();
            long K = sc.nextLong();

            long[] elements = new long[(int) N];

            elements[0] = (A * A) % P;
            for (int j = 1; j < N; j++) {
                elements[j] = (elements[j - 1] * A) % P;
            }

            long kthElement = quickSelect(elements, 0, (int) (N - 1), (int) (K - 1));
            sb.append(kthElement + "\n");
        }

        System.out.println(sb);
    }

    private static long quickSelect(long[] arr, int from, int to, int K) {
        if (from == to) {
            return arr[from];
        }

        int pivotIndex = partition(arr, from, to);

        if (K == pivotIndex) {
            return arr[K];
        } else if (K < pivotIndex) {
            return quickSelect(arr, from, pivotIndex - 1, K);
        } else {
            return quickSelect(arr, pivotIndex + 1, to, K);
        }
    }

    private static int partition(long[] arr, int from, int to) {
        long pivot = arr[from];
        int i = from;
        for (int j = i + 1; j <= to; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, from, i);
        return i;
    }

    private static void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
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

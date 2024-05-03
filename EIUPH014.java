import java.util.*;
import java.io.*;

public class EIUPH014 {
    static InputReader rd = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            int n = rd.nextInt();
            if (n == 0) {
                break;
            }

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = rd.nextInt();
            }
            sb.append(countIterations(a) + "\n");
        }
        System.out.println(sb);
    }

    // 1 2 3 4
    // 0 1 2 3
    // 1 1 1 3

    public static int countIterations(int[] a) {
        int loop = 0;
        while (checkResult(a) == false) {
            int[] new_arr = new int[a.length];
            for (int i = 0; i < a.length - 1; i++) {
                new_arr[i] = Math.abs(a[i] - a[i + 1]);
            }
            // handle last number
            new_arr[a.length - 1] = Math.abs(a[a.length - 1] - a[0]);
            a = new_arr;
            loop++;
            if (loop > 1000)
                return -1;
        }
        return loop;
    }

    public static boolean checkResult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != a[0])
                return false;
        }
        return true;
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

package Test_1;

import java.io.*;
import java.util.*;

public class EIUPH014 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        while (true) {
            int n = sc.nextInt();

            if (n == 0) {
                break;
            }

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            sb.append(countLoop(a) + "\n");
        }

        System.out.println(sb);

    }

    public static int countLoop(int[] a) {
        int loop = 0;
        while (!checkEqualResult(a)) {

            int[] b = new int[a.length];
            for (int i = 0; i < a.length - 1; i++) {
                b[i] = Math.abs(a[i] - a[i + 1]);
            }
            b[a.length - 1] = Math.abs(a[a.length - 1] - a[0]);

            a = b;

            loop++;

            if (loop > 1000)
                return -1;
        }
        return loop;
    }

    public static boolean checkEqualResult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != a[0]) {
                return false;
            }
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

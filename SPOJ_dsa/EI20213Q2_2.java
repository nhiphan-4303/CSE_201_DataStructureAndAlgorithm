import java.util.*;
import java.io.*;

class EI20213Q2_2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        long[] m = new long[n];

        for (int i = 0; i < n; i++) {
            m[i] = sc.nextLong();
        }
        count(m, sb);
        System.out.print(sb);
    }

    public static void count(long[] m, StringBuilder sb) {
        Arrays.sort(m);
        long current = m[0];
        int count = 1;

        for (int i = 1; i < m.length; i++) {
            if (m[i] == current) {
                count++;
            } else {
                sb.append(current + " " + count + "\n");
                current = m[i];
                count = 1;
            }
        }
        sb.append(current + " " + count + "\n");
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

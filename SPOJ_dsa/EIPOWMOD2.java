import java.util.*;
import java.io.*;

public class EIPOWMOD2 {
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

    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        System.out.println(powMod(a, b, c));
    }

    public static long powMod(long a, long b, long c) {
        long result = 1;
        a = a % c; // vi a^b %c = a % c
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % c;
            }
            a = (a * a) % c;
            b = b / 2;
        }
        return result;
    }
}

import java.util.*;
import java.io.*;

public class EIUPREIU {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        String dash = dashes(n);
        String space = spaces(n);

        sb.append(" " + dash + " ".repeat(n / 2 + 5) + "\n");

        for (int i = 1; i <= (n - 2) / 2; i++) {
            sb.append("|" + space + " | |" + space + "|" + "\n");
        }
        sb.append("|" + dash + " | |" + space + "|" + "\n");

        for (int i = 1; i <= (n - 2) / 2; i++) {
            sb.append("|" + space + " | |" + space + "|" + "\n");
        }
        sb.append("|" + dash + " | |" + dash + "|" + "\n");

        System.out.print(sb);

    }

    public static String dashes(int n) {
        return ("_".repeat(n / 2));
    }

    public static String spaces(int n) {
        return (" ".repeat(n / 2));
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
import java.util.*;
import java.io.*;

public class EIKMAX {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Long> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a.add(sc.nextLong());
        }

        a.sort((o2, o1) -> Long.compare(o1, o2));

        for (int i = 0; i < k; i++) {
            System.out.print(a.get(i) + " ");
        }
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

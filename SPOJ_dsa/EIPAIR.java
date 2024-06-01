import java.util.*;
import java.io.*;

public class EIPAIR {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Map<Integer, Integer> priceCount = new HashMap<>();

            for (int j = 0; j < n; j++) {
                int price = sc.nextInt();
                priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);
            }

            long ways = 0;
            for (int count : priceCount.values()) {
                if (count > 1) {
                    ways += (long) count * (count - 1) / 2;
                }
            }

            sb.append(ways).append("\n");
        }

        System.out.print(sb);
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

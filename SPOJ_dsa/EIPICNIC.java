import java.util.*;
import java.io.*;

public class EIPICNIC {
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        int[] group = new int[5];
        int n = rd.nextInt();

        for (int i = 0; i < n; i++) {
            group[rd.nextInt()]++;
        }

        int cars = group[4]
                + group[3]
                + group[2] / 2 + group[2] % 2;

        int over = group[1] - group[3];

        if (group[2] % 2 != 0) {
            over -= 2;
        }

        if (over > 0) {
            cars += (over + 3) / 4;
        }

        System.out.println(cars);
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

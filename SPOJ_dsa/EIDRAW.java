import java.io.*;
import java.util.*;

public class EIDRAW {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int h = sc.nextInt();

        int tang = 1;
        for (int i = 0; i < h; i++) {
            System.out.println(space(i) + "\\" +
                    space((h - tang) * 2) + "/" +
                    space(i * 2) + "\\" +
                    space((h - tang) * 2) + "/" + space(i));
            tang++;
        }
    }

    public static String space(int t) {
        String s = "";
        for (int i = 0; i < t; i++) {
            s += " ";
        }
        return s;
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
import java.util.*;
import java.io.*;

public class EIUPAGES {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        int numberOfPages = sc.nextInt();

        int[] a = new int[numberOfPages];
        for (int i = 0; i < numberOfPages; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        int start = a[0];
        int end = start;

        for (int i = 1; i < a.length; i++) {
            if (a[i] == end + 1) {
                end = a[i];
            } else {
                if (end == start) {
                    list.add(Integer.toString(start));
                } else if (end == start + 1) {
                    list.add(Integer.toString(start));
                    list.add(Integer.toString(end));
                } else {
                    list.add(start + "-" + end);
                }
                start = a[i];
                end = start;
            }
        }

        if (end == start) {
            list.add(Integer.toString(start));
        } else if (end == start + 1) {
            list.add(Integer.toString(start));
            list.add(Integer.toString(end));
        } else {
            list.add(start + "-" + end);
        }

        for (String x : list) {
            System.out.print(x + " ");
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

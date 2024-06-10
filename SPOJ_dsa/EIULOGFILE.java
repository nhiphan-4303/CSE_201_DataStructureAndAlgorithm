import java.util.*;
import java.io.*;

class EIULOGFILE {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        long[] timestamps = new long[n];

        for (int i = 0; i < n; i++) {
            long timestamp = sc.nextLong();

            timestamps[i] = timestamp * 2;
        }

        Arrays.sort(timestamps);

        long count = 0;

        for (int i = 0; i < n - 1; i++) {
            long limitTime = timestamps[i] + 1200001;
            int index = Arrays.binarySearch(timestamps, i + 1, n, limitTime);
            if (index < 0) {
                index = -index - 1;
            }
            count += index - i - 1;
        }

        System.out.println(count);
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

import java.util.*;
import java.io.*;

public class EIULOGFILE2 {
    static StringBuilder sb = new StringBuilder();
    static InputReader rd = new InputReader(System.in);

    public static void main(String[] args) {
        int nTimestamp = rd.nextInt();
        int nEvents = rd.nextInt();

        long[] timestamps = new long[nTimestamp];

        for (int i = 0; i < timestamps.length; i++) {
            timestamps[i] = rd.nextLong();
        }

        Arrays.sort(timestamps);

        while (nEvents-- > 0) {
            long event = rd.nextLong();
            int index = ~Arrays.binarySearch(timestamps, event);
            if (index < 0)
                index = (index * -1) - 1;

            sb.append(index >= timestamps.length ? "-1" : timestamps[index]).append(" ");
        }
        System.out.println(sb);
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

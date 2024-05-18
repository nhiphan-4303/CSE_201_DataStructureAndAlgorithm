package Test_1;

import java.io.*;
import java.util.*;

public class EI20213Q2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextLong();
        }

        Arrays.sort(numbers);

        Map<Long, Integer> countMap = new HashMap<>();
        for (long x : numbers) {
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }

        List<Long> sortKey = new ArrayList<>();
        for (long key : countMap.keySet()) {
            sortKey.add(key);
        }
        Collections.sort(sortKey);

        for (long x : sortKey) {
            sb.append(x + " " + countMap.get(x) + "\n");
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

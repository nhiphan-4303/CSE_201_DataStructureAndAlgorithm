package Test_1;

import java.util.*;
import java.io.*;

public class EIUPH010 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] numbers = new int[n];

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
            countMap.put(numbers[i], countMap.getOrDefault(numbers[i], 0) + 1);
        }

        int minKey = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int x : countMap.keySet()) {
            if (countMap.get(x) > maxValue || (countMap.get(x) == maxValue && x < minKey)) {
                maxValue = countMap.get(x);
                minKey = x;
            }
        }

        System.out.println(minKey + " " + maxValue);
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

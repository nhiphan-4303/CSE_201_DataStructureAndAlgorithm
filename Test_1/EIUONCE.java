package Test_1;

import java.util.*;
import java.io.*;

public class EIUONCE {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();

            int n = sc.nextInt();
            int[] numbers = new int[n];

            for (int j = 0; j < n; j++) {
                numbers[j] = sc.nextInt();
            }

            Arrays.sort(numbers);

            for (int x : numbers) {
                countMap.put(x, countMap.getOrDefault(x, 0) + 1);
            }

            for (int x : numbers) {
                if (countMap.get(x) == 1) {
                    sb.append(x + " ");
                }
            }

            sb.append("\n");

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

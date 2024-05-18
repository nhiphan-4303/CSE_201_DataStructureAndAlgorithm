package Test_1;

import java.util.*;
import java.io.*;

public class EIPAIR {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            //tạo 1 Map mới
            Map<Integer, Integer> countMap = new HashMap<>();

            int numOfGifts = sc.nextInt();
            for (int j = 0; j < numOfGifts; j++) {
                int price = sc.nextInt();
                countMap.put(price, countMap.getOrDefault(price, 0) + 1);
            }

            long ways = 0;
            for (int count : countMap.values()) {
                if (count > 1) {
                    ways += count * (count - 1) / 2;
                }
            }
            sb.append(ways + "\n");
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

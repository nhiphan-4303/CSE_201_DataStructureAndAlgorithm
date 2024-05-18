package Test_1;

import java.io.*;
import java.text.*;
import java.util.*;

public class EIDUPBOD {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static DecimalFormat df = new DecimalFormat("00");

    public static void main(String[] args) {
        Map<Integer, Integer> countMap = new HashMap<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {

            int day = sc.nextInt();
            int month = sc.nextInt() * 100;
            int year = sc.nextInt() * 10000;
            int key = year + month + day;

            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        List<Integer> listDates = new ArrayList<>(countMap.keySet());
        listDates.sort(null);

        for (int key : listDates) {
            int year = key / 10000;
            int month = (key % 10000) / 100;
            int day = (key % 100);

            sb.append(df.format(day) + "/" + df.format(month) + "/" + df.format(year) + " " + countMap.get(key) + "\n");
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

import java.util.*;
import java.io.*;

public class EI20213Q2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        long[] m = new long[n];

        for (int i = 0; i < n; i++) {
            m[i] = sc.nextLong();
        }
        count(m, sb);
        System.out.print(sb);
    }

    public static void count(long[] m, StringBuilder sb) {
        //Arrays.sort(m);
        //Map<Long, Integer> countMap = new HashMap<>();
        Map<Long, Integer> countMap = new TreeMap<>();
        for (long num : m) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // List<Long> sortedKeys = new ArrayList<>(countMap.keySet());
        // Collections.sort(sortedKeys);  
        
        // for (Long key : sortedKeys) {
        //     sb.append(key).append(" ").append(countMap.get(key)).append("\n");
        // }
        for (Map.Entry<Long, Integer> entry : countMap.entrySet()) {
            sb.append(entry.getKey() + " " + entry.getValue() + "\n");
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

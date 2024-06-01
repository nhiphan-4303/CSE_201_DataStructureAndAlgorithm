import java.io.*;
import java.util.*;

public class EIUTRANS {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<String, String> translationMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String wordA = sc.next();
            String wordB = sc.next();

            if (wordA.length() <= wordB.length()) {
                translationMap.put(wordA, wordA);
            } else {
                translationMap.put(wordA, wordB);
            }
        }

        String[] message = new String[n];
        for (int i = 0; i < n; i++) {
            message[i] = sc.next();
        }

        for (String word : message) {
            sb.append(translationMap.get(word)).append(" ");
        }

        System.out.println(sb.toString().trim());
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

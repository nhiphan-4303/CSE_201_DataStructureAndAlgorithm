import java.util.*;
import java.io.*;

public class EIUGIFT1 {
    static InputReader sc = new InputReader(System.in);
    // static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int numberOfGifts = sc.nextInt();
        int numberOfPapers = sc.nextInt();

        int[] gifts = new int[numberOfGifts];
        for (int i = 0; i < numberOfGifts; i++) {
            gifts[i] = sc.nextInt();
        }
        Arrays.sort(gifts);

        int[] papers = new int[numberOfPapers];
        for (int j = 0; j < numberOfPapers; j++) {
            papers[j] = sc.nextInt();
        }
        Arrays.sort(papers);
        // 4 4
        // 2 2 3 4
        // 4 4 6 8
        // 6 6 9 12
        // 5 10 15 20

        int count = 0;
        int i = 0;
        int j = 0;
        while (i < numberOfPapers && j < numberOfGifts) {
            if (papers[i] >= gifts[j] * 2 && papers[i] <= gifts[j] * 3) {
                count++;
                i++;
                j++;
            } else if (papers[i] < gifts[j] * 2) {
                i++;
            } else { // papers[i] > gifts[j] * 3
                j++;
            }
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

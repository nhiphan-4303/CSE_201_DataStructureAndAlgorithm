import java.io.*;
import java.util.*;

public class EIUQUISORT {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextLong();
        }

        // cộng 0.00000001 vào mỗi phần tử
        double[] makeStableArr = addArray(numbers);
        // làm lộn xộn array để tránh speacial case giúp run faster
        shuffleArray(makeStableArr);
        quickSort(makeStableArr, 0, n - 1);

        print(makeStableArr);
    }

    static double[] addArray(long[] numbers) {
        double[] addArray = new double[numbers.length];
        double x = 0.00000001;
        for (int i = 0; i < numbers.length; i++) {
            addArray[i] = numbers[i] + (i + 1) * x;
        }
        return addArray;
    }

    static void swap(double[] numbers, int i, int j) {
        double temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    static void shuffleArray(double[] numbers) {
        Random rand = new Random();
        for (int i = numbers.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(numbers, i, j);
        }
    }

    static void quickSort(double[] numbers, int from, int to) {
        if (from < to) {
            int middle = partition(numbers, from, to);
            quickSort(numbers, from, middle - 1);
            quickSort(numbers, middle + 1, to);
        }
    }

    static int partition(double[] numbers, int from, int to) {
        double pivot = numbers[from];
        int i = from;
        for (int j = i + 1; j <= to; j++) {
            if (numbers[j] < pivot) {
                i++;
                swap(numbers, i, j);
            }
        }
        swap(numbers, from, i);
        return i;
    }

    static void print(double[] numbers) {
        for (double number : numbers) {
            sb.append((long) number + "\n");
        }
        System.out.print(sb);
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
                    e.printStackTrace();
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

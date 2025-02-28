import java.util.*;
import java.io.*;

public class EIUBUSOR {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N = sc.nextInt();
        String dataType = sc.next();
        // Xet kieu du lieu
        if (dataType.equals("int")) {
            Integer[] array = new Integer[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }
            bubbleSort(array);
            printArray(array);

        } else if (dataType.equals("long")) {
            Long[] array = new Long[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextLong();
            }
            bubbleSort(array);
            printArray(array);

        } else if (dataType.equals("double")) {
            Double[] array = new Double[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextDouble();
            }
            bubbleSort(array);
            printArray(array);

        } else if (dataType.equals("float")) {
            Float[] array = new Float[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextFloat();
            }
            bubbleSort(array);
            printArray(array);
        }

    }

    static <T extends Number & Comparable<T>> void bubbleSort(T[] array) {
        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static <T> void printArray(T[] array) {
        for (T number : array) {
            sb.append(number + " ");
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

        public float nextFloat() {

            return Float.parseFloat(next());

        }

    }
}
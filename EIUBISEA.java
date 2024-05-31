import java.util.*;
import java.io.*;

public class EIUBISEA {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt(); // số phần tử trong mảng
        int m = sc.nextInt(); // số câu lệnh cần kiểm tra
        int[] arr = new int[n];
        int[] sentence = new int[m];

        // nhập phần tử trong mảng
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // nhập các câu lệnh kiểm tra
        for (int i = 0; i < m; i++) {
            sentence[i] = sc.nextInt();
        }

        Arrays.sort(arr); // sắp xếp phần tử trong mảng tăng dần

        for (int i = 0; i < m; i++) {
            int index = binarySearch(arr, sentence[i], 0, n - 1);
            sb.append(index + " ");
        }

        System.out.println(sb);
    }

    public static int binarySearch(int[] array, int key, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (array[mid] < key) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (array[left] == key) {
            return left;
        } else if (array[right] == key) {
            return right;
        } else {
            return -1;
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

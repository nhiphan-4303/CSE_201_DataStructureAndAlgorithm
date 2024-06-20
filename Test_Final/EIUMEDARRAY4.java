package Test_Final;

import java.util.*;

public class EIUMEDARRAY4 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int j = 0; j < t; j++) {
            long N = sc.nextLong();
            long A = sc.nextLong();
            long P = sc.nextLong();
            long K = sc.nextLong();

            long[] elements = new long[(int) N];
            elements[0] = (A * A) % P;
            for (int i = 1; i < N; i++) {
                elements[i] = (elements[i - 1] * A) % P;
            }

            long kthElement = quickSelect(elements, 0, (int) N - 1, (int) K - 1);
            sb.append(kthElement + "\n");
        }
        System.out.println(sb);
    }

    static long quickSelect(long[] elements, int from, int to, int K) {
        if (from == to) {
            return elements[from];
        }

        int middle = partition(elements, from, to);
        if (K == middle) {
            return elements[K];
        } else if (K < middle) {
            return quickSelect(elements, from, middle - 1, K);
        } else {
            return quickSelect(elements, middle + 1, to, K);
        }
    }

    static int partition(long[] elements, int from, int to) {
        long pivot = elements[from];
        int i = (int) from;
        for (int j = i + 1; j <= to; j++) {
            if (elements[j] < pivot) {
                i++;
                swap(elements, i, j);
            }
        }
        swap(elements, from, i);
        return i;
    }

    static void swap(long[] elements, int i, int j) {
        long temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}

package Test_Final;

import java.util.*;

public class EIAPPLEBOX {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int j = 0; j < t; j++) {
            long N = sc.nextLong();
            long A = sc.nextLong();
            long P = sc.nextLong();

            long[] arr = new long[(int) N];
            arr[0] = (A * A) % P;
            for (int i = 1; i < N; i++) {
                arr[i] = (arr[i - 1] * A) % P;
            }

            long inversion = countInversion(arr, 0, (int) (N - 1));
            sb.append(inversion + "\n");
        }
        System.out.println(sb);

    }

    static long countInversion(long[] arr, int from, int to) {
        if (from < to) {
            int middle = (from + to) / 2;

            long inversion = 0;

            inversion += countInversion(arr, from, middle);
            inversion += countInversion(arr, middle + 1, to);

            inversion += mergeAndCount(arr, from, middle, to);
            return inversion;
        }
        return 0;
    }

    static long mergeAndCount(long[] arr, int from, int middle, int to) {
        long inversion = 0;
        int n1 = (middle - from) + 1;
        int n2 = to - middle;

        long[] leftArr = new long[n1];
        long[] rightArr = new long[n2];

        System.arraycopy(arr, from, leftArr, 0, n1);
        System.arraycopy(arr, middle + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = from;
        while (i < n1 && j < n2) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                inversion += ((long) n1 - (long) i);
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

        return inversion;
    }

}

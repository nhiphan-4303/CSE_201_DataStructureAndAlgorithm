package Test_Final;

import java.util.*;

public class EIUMERSORT {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, n - 1);
        print(arr);
    }

    public static void mergeSort(int[] arr, int from, int to) {
        if (from < to) {
            int middle = (from + to) / 2;

            mergeSort(arr, from, middle);
            mergeSort(arr, middle + 1, to);

            merge(arr, from, middle, to);
        }
    }

    public static void merge(int[] arr, int from, int middle, int to) {
        int n1 = (middle - from) + 1; // +1 vì bao gồm middle
        int n2 = to - middle; // không cộng vì không bao gồm middle

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, from, leftArr, 0, n1);
        System.arraycopy(arr, middle + 1, rightArr, 0, n2);

        int i = 0;
        int j = 0;
        int k = from;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
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
    }

    public static void print(int[] arr) {
        for (int a : arr) {
            sb.append(a + "\n");
        }
        System.out.println(sb);
    }
}

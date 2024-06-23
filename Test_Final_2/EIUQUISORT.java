package Test_Final_2;

import java.util.*;

public class EIUQUISORT {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        double[] stableArr = addArr(arr);
        shuffle(stableArr);
        quickSort(stableArr, 0, n - 1);
        print(stableArr);

    }

    static void shuffle(double[] arr) {
        Random rd = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rd.nextInt(i + 1);
            swap(arr, i, j);
        }
    }

    static void quickSort(double[] arr, int from, int to) {
        if (from < to) {
            int middle = partition(arr, from, to);

            quickSort(arr, from, middle - 1);
            quickSort(arr, middle + 1, to);
        }
    }

    static int partition(double[] arr, int from, int to) {
        double pivot = arr[from];
        int i = from;

        for (int j = i + 1; j <= to; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i, from);
        return i;
    }

    static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static double[] addArr(int[] arr) {
        double[] stableArr = new double[arr.length];
        double x = 0.000000001;
        for (int i = 0; i < arr.length; i++) {
            stableArr[i] = arr[i] + ((i + 1) * x);
        }
        return stableArr;
    }

    static void print(double[] arr) {
        for (double x : arr) {
            sb.append((int) x + "\n");
        }
        System.out.println(sb);
    }
}

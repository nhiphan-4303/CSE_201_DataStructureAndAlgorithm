package Test_Final;

import java.util.*;

public class EIUQUISORT {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextLong();
        }

        double[] stableArray = addArray(numbers);
        shuffle(stableArray);
        quickSort(stableArray, 0, n - 1);
        print(stableArray);
    }

    static void swap(double[] numbers, int i, int j) {
        double temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
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

    static double[] addArray(long[] numbers) {
        double[] addArray = new double[numbers.length];
        double x = 0.00000001;
        for (int i = 0; i < numbers.length; i++) {
            addArray[i] = numbers[i] + (i + 1) * x;
        }
        return addArray;
    }

    static void shuffle(double[] numbers) {
        Random random = new Random();
        for (int i = numbers.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swap(numbers, i, j);
        }
    }

    static void print(double[] numbers) {
        for (double n : numbers) {
            sb.append((long) n + "\n");
        }
        System.out.println(sb);

    }

}

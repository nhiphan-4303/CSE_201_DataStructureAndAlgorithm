package Test_2;

import java.util.*;

public class EIUSESOR {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        String dataType = sc.next();

        if (dataType.equals("int")) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            selectionSort(a);
            print(a);

        } else if (dataType.equals("long")) {
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            selectionSort(a);
            print(a);

        } else if (dataType.equals("double")) {
            Double[] a = new Double[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextDouble();
            }
            selectionSort(a);
            print(a);

        } else if (dataType.equals("float")) {
            Float[] a = new Float[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextFloat();
            }
            selectionSort(a);
            print(a);
        }
    }

    static <T extends Number & Comparable<T>> void selectionSort(T[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length - 1; j++) {
                if (a[minIndex].compareTo(a[j]) > 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(a, i, minIndex);
            }
        }
    }

    static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static <T> void print(T[] a) {
        for (T x : a) {
            sb.append(x + " ");
        }
        System.out.println(sb);
    }
}

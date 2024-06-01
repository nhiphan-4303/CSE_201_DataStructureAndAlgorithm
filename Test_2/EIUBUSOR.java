package Test_2;

import java.util.*;

public class EIUBUSOR {
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

            bubbleSort(a);
            print(a);
        } else if (dataType.equals("long")) {
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            bubbleSort(a);
            print(a);
        } else if (dataType.equals("double")) {
            Double[] a = new Double[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextDouble();
            }
            bubbleSort(a);
            print(a);
        } else if (dataType.equals("float")) {
            Float[] a = new Float[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextFloat();
            }
            bubbleSort(a);
            print(a);
        }
    }

    static <T extends Number & Comparable<T>> void bubbleSort(T[] a) {
        boolean swapped;
        for (int i = 0; i < a.length; i++) {
            swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    swap(a, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
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

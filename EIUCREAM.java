import java.util.*;
import java.io.*;

public class EIUCREAM {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        long n = sc.nextLong();
        long m = sc.nextLong();

        long days = n * m - 1;
        System.out.println(days);

    }
}

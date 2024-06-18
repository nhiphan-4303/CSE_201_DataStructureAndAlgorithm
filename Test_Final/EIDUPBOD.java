package Test_Final;

import java.text.*;
import java.util.*;

public class EIDUPBOD {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static DecimalFormat df = new DecimalFormat("00");

    public static void main(String[] args) {
        int n = sc.nextInt();
        Map<Integer, Integer> countSameDates = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();

            int key = year * 10000 + month * 100 + day;
            countSameDates.put(key, countSameDates.getOrDefault(key, 0) + 1);
        }

        List<Integer> listDates = new ArrayList<>(countSameDates.keySet());
        listDates.sort(null);

        for (int date : listDates) {
            int year = date / 10000;
            int month = (date % 10000) / 100;
            int day = date % 100;

            sb.append(df.format(day) + "/" +
                    df.format(month) + "/" +
                    year + " " +
                    countSameDates.get(date) + "\n");
        }
        System.out.println(sb);
    }
}

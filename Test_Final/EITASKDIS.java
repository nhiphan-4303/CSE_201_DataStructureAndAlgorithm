package Test_Final;

import java.util.*;

public class EITASKDIS {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt(); // số công nhân
        int m = sc.nextInt(); // công việc

        int[] tasks = new int[m];
        for (int i = 0; i < m; i++) {
            tasks[i] = sc.nextInt();
        }

        Arrays.sort(tasks);
        PriorityQueue<Person> pq = new PriorityQueue<>((p1, p2) -> {
            int compare = Long.compare(p1.totalHours, p2.totalHours);
            if (compare == 0) {
                return Integer.compare(p1.index, p2.index);
            }
            return compare;
        });

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Person p = new Person(i);
            pq.add(p);
            personList.add(p);
        }

        for (int i = m - 1; i >= 0; i--) {
            Person p = pq.poll();
            p.totalHours += tasks[i];
            pq.add(p);
        }

        for (Person p : personList) {
            sb.append(p);
        }

        System.out.println(sb);

    }

    static public class Person {

        int index;
        long totalHours;

        public Person(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return this.totalHours + " ";
        }
    }
}

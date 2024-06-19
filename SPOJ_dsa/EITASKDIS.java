
import java.io.*;
import java.util.*;

public class EITASKDIS {

    static StringBuilder sb = new StringBuilder();
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();// số công nhân
        int m = sc.nextInt();// số công việc

        int[] tasks = new int[m];
        for (int i = 0; i < m; i++) {
            tasks[i] = sc.nextInt();
        }

        Arrays.sort(tasks);

        PriorityQueue<Person> pq = new PriorityQueue<>((p1, p2) -> {
            int compare = Long.compare(p1.totalHours, p2.totalHours);
            if (compare == 0) {
                compare = Integer.compare(p1.index, p2.index);
            }
            return compare;
        });

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Person person = new Person(i);
            pq.add(person);
            personList.add(person);
        }

//3 5
//2 5 6 4 7
// 2 4 5 6 7

        for (int i = m - 1; i >= 0; i--) {
            Person person = pq.poll();// lấy đầu 
            person.totalHours += tasks[i];
            pq.add(person);
        }

        for (Person p : personList) {
            sb.append(p);
        }
        System.out.println(sb);
    }

    static class Person {

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

    static class InputReader {

        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}

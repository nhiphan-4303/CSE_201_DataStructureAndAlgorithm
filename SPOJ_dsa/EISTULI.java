import java.io.*;
import java.util.*;

public class EISTULI {
    static StringBuilder sb = new StringBuilder();
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Student> listStudents = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int courses = sc.nextInt();

            Student student = new Student(i, id, name);

            for (int j = 0; j < courses; j++) {
                int score = sc.nextInt();

                if (score >= 50) {
                    student.calculateAverage(score);
                }
            }
            listStudents.add(student);
        }

        listStudents.sort((s1, s2) -> {
            int compare = Double.compare(s2.avg, s1.avg);
            if (compare == 0) {
                compare = Integer.compare(s1.index, s2.index);
            }
            return compare;
        });

        for (int i = 0; i < k; i++) {
            Student s = listStudents.get(i);
            sb.append(s.id + " " + s.name + " " +
                    Math.round(s.avg) + " " + s.credits + "\n");

            if (n > k && i < k - 1 && listStudents.get(i + 1).avg == listStudents.get(k).avg) {
                break;
            }
        }
        System.out.println(sb);

    }

    static class Student {
        int index;
        long id;
        double totalScore;
        int totalSubject;
        String name;
        double avg;
        int credits;

        public Student(int index, long id, String name) {
            this.index = index;
            this.id = id;
            this.name = name;
        }

        public void calculateAverage(double score) {
            totalScore += score;
            totalSubject++;
            avg = totalScore / totalSubject;
            credits += 4;
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

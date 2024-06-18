import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class EIUGRADE {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Map<Long, Student> studentMap = new HashMap<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {

            long studentId = sc.nextLong();
            long subjectCode = sc.nextLong();
            double grade = sc.nextDouble();

            studentMap.putIfAbsent(studentId, new Student(studentId));

            Student student = studentMap.get(studentId);
            student.addGrade(grade);
        }

        List<Student> students = new ArrayList<Student>(studentMap.values());

        students.sort((s1, s2) -> {
            int compare = Double.compare(s2.average, s1.average);
            if (compare == 0) {
                compare = Long.compare(s1.id, s2.id);
            }
            return compare;
        });

        for (Student s : students) {
            sb.append(s.id).append(" ").append(String.format("%.3f", s.average)).append("\n");
        }

        System.out.println(sb);
    }

    static class Student {
        long id;
        double totalGrade;
        int totalSubject;
        double average;

        public Student(long id) {
            this.id = id;
        }

        public void addGrade(double grade) {
            totalGrade += grade;
            totalSubject++;
            average = totalGrade / totalSubject;
        }

        @Override
        public String toString() {
            return id + " " + average;
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

// add constructor to make a key

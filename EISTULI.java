import java.util.*;
import java.io.*;

public class EISTULI {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String studentName = sc.next();
            int totalSubjects = sc.nextInt();
            Student student = new Student(studentName, i);

            for (int j = 0; j < totalSubjects; j++) {
                int grade = sc.nextInt();
                student.addGrade(grade);
            }

            students.add(student);
        }

        students.sort((s1, s2) -> {
            int compare = Double.compare(s2.average, s1.average);
            if (compare == 0) {
                compare = Integer.compare(s1.index, s2.index);
            }
            return compare;
        });

        int scholarship = Math.min(2, students.size());

        for (int i = 0; i < scholarship; i++) {
            sb.append(students.get(i).name).append("\n");
        }

        System.out.print(sb);
    }

    static class Student {
        private String name;
        private int totalGrade;
        private int totalSubjects;
        private int index;
        private double average;

        public Student(String name, int i) {
            this.name = name;
            this.totalGrade = 0;
            this.totalSubjects = 0;
            this.average = 0.0;
        }

        public void addGrade(int grade) {
            totalGrade += grade;
            totalSubjects++;
            average = (double) totalGrade / (double) totalSubjects;
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

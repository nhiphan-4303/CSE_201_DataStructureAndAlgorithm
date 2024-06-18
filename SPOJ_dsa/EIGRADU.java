
import java.io.*;
import java.util.*;

class EIGRADU {

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

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        int n = sc.nextInt();
        int credit = sc.nextInt();

        for (int i = 0; i < n; i++) {
            long id = sc.nextLong();
            String name = sc.next();

            Student student = new Student(id, name);
            int course = sc.nextInt();
            for (int j = 0; j < course; j++) {
                double grade = sc.nextDouble();
                if (grade >= 50) {
                    student.calculateCreditAndGpa(grade);
                }
            }
            studentList.add(student);
        }
        studentList.sort((s1, s2) -> {
            int compare = Double.compare(s2.gpa, s1.gpa);
            if (compare == 0) {
                return Long.compare(s1.id, s2.id);
            }
            return compare;
        });

        for (Student s : studentList) {
            if (s.totalCredit >= credit) {
                sb.append(s.id + " " + s.name + " " + s.gpa + "\n");
            }
        }

        System.out.println(sb);
    }

    static public class Student {

        long id;
        String name;
        long totalCredit;
        long totalGrade;
        long gpa;

        public Student(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public void calculateCreditAndGpa(double grade) {
            totalCredit += 4;
            totalGrade += grade;
            gpa = totalGrade / (totalCredit / 4);
        }
    }

}

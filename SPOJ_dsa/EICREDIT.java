import java.util.*;
import java.io.*;

public class EICREDIT {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();

        List<Student> listStudents = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int course = sc.nextInt();

            Student student = new Student(name);

            for (int j = 0; j < course; j++) {
                int grade = sc.nextInt();
                if (grade >= 50) {
                    student.calculateCredit(grade);
                }
            }

            listStudents.add(student);
        }

        for (Student s : listStudents) {
            sb.append(s.name + " " + s.totalCredit + "\n");
        }
        System.out.println(sb);
    }

    static public class Student {
        String name;
        int totalCredit;

        public Student(String name) {
            this.name = name;
            this.totalCredit = 0;
        }

        public void calculateCredit(int grade) {
            this.totalCredit += 4;
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

import java.util.*;
import java.io.*;

public class EICREDIT {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int totalOfSubjects = sc.nextInt();

            int[] score = new int[totalOfSubjects];
            for (int j = 0; j < totalOfSubjects; j++) {
                score[j] = sc.nextInt();
            }

            Student student = new Student(name, totalOfSubjects, score);
            studentList.add(student);
        }

        for (Student s : studentList) {
            sb.append(s.name + " " + s.calculateCredit() + "\n");
        }

        System.out.println(sb);
    }

    static class Student {
        private String name;
        private int totalOfSubjects;
        private int[] scores;

        public Student(String name, int totalOfSubjects, int[] scores) {
            this.name = name;
            this.totalOfSubjects = totalOfSubjects;
            this.scores = scores;
        }

        public int calculateCredit() {
            int credit = 0;
            for (int score : scores) {
                if (score >= 50) {
                    credit += 4;
                }
            }

            return credit;
        }

        public void setTotalOfSubjects(int totalOfSubjects) {
            this.totalOfSubjects = totalOfSubjects;
        }

        public int getTotalOfSubjects() {
            return this.totalOfSubjects;
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

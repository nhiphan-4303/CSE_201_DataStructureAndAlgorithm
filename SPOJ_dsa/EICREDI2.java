import java.io.*;
import java.util.*;

public class EICREDI2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // tạo danh sách học sinh
        List<Student> studentList = new ArrayList<>();

        int n = sc.nextInt();
      
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
            sb.append(s.name + " " + s.addGradeAndGpa() + "\n");
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

        public String addGradeAndGpa() {
            //tạo thêm 1 string builder để lưu
            StringBuilder grades = new StringBuilder();

            int count = 0;
            int sumOfScores = 0;
            int gpa = 0;

            //điều kiện xem có bao nhiêu môn pass
            for (int score : scores) {
                if (score >= 50) {
                    grades.append(score).append(" ");
                    count++;
                    sumOfScores += score;
                }
            }

            //điều kiện cho gpa
            if (count == 0) {
                gpa = 0;
            } else {
                gpa = sumOfScores / count;
            }

            grades.append(gpa);
            return grades.toString();
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

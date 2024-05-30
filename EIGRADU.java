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
        List<Student> listStudents = new ArrayList<>();

        int numberOfStudents = sc.nextInt();
        int numberOfCredits = sc.nextInt();

        for (int i = 0; i < numberOfStudents; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int numberOfCourses = sc.nextInt();

            Student s = new Student(id, name, numberOfCredits);
            for (int j = 0; j < numberOfCourses; j++) {
                double grade = sc.nextDouble();
                s.addGrade(grade);
            }

            listStudents.add(s);
        }

        listStudents.sort((s1, s2) -> {
            int compare = Double.compare(s2.getAverage(), s1.getAverage());
            if (compare == 0) {
                return Integer.compare(s1.id, s2.id);
            }
            return compare;
        });

        for (Student s : listStudents) {
            if (s.isGraduate()) {
                sb.append(s + "\n");
            }
        }

        System.out.print(sb);

    }

    public static class Student {
        private int id;
        private String name;
        private int numberOfCredits;
        private double totalGrade;
        private double average;
        private double passCredit;

        List<Double> listGrades = new ArrayList<>();

        public Student(int id, String name, int numberOfCredits) {
            this.id = id;
            this.name = name;
            this.numberOfCredits = numberOfCredits;
            this.average=0.0;
        }

        public void addGrade(double grade) {
            listGrades.add(grade);
            if (grade >= 50) {
                this.passCredit += 4;
                this.totalGrade += grade;
            }
        }

        public boolean isGraduate() {
            return passCredit >= numberOfCredits;
        }

        public double getAverage() {
            if (isGraduate()) {
                this.average = Math.floor(totalGrade / (passCredit / 4));
            }
            return this.average;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + (int) getAverage();
        }

    }

}

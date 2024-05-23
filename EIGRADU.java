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

    static InputReader rd = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int numberOfStudents = rd.nextInt();
        int numberOfCredits = rd.nextInt();
        List<Student> students = new ArrayList<Student>();

        for (int i = 0; i < numberOfStudents; i++) {
            int ID = rd.nextInt();
            String name = rd.next();
            int numberOfCourses = rd.nextInt();

            Student student = new Student(ID, name, numberOfCredits);
            
            for (int j = 0; j < numberOfCourses; j++) {
                double grade = rd.nextDouble();
                student.addGrade(grade);
            }
            students.add(student);
        }

        students.sort((s1, s2) -> {
            int compare = Double.compare(s2.getAverage(), s1.getAverage());
            if (compare == 0) {
                return Integer.compare(s1.ID, s2.ID);
            }
            return compare;
        });

        for (Student student : students) {
            if (student.isGraduate()) {
                sb.append(student + "\n");
            }
        }
        System.out.print(sb);
    }

static class Student {
        private int ID;
        private String name;
        private int numberOfCredits;
        private double totalGrade;
        private double average;
        private int passedCredits;

        ArrayList<Double> listGrades = new ArrayList<Double>();

        public Student(int ID, String name, int numberOfCredits) {
            this.ID = ID;
            this.name = name;
            this.numberOfCredits = numberOfCredits;
            this.totalGrade = 0;
            this.average = 0;
            this.passedCredits = 0;
        }

        public void addGrade(double grade) {
            listGrades.add(grade);
            if (grade >= 50) {
                passedCredits += 4;
                totalGrade += grade;
            }
        }

        public double getAverage() {
            if (passedCredits > 0) {
                return Math.floor(totalGrade / (passedCredits / 4));
            } else {
                return 0;
            }
        }

        public boolean isGraduate() {
            return passedCredits >= numberOfCredits;
        }

        @Override
        public String toString() {
            return ID + " " + name + " " + (int) getAverage();
        }
    }

}

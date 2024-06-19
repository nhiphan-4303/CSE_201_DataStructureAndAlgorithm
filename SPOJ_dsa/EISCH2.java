import java.io.*;
import java.util.*;

class EISCH2 {
    static StringBuilder sb = new StringBuilder();
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int countScholarship_A = n / 12;
        int countScholarship_B = n / 3 - countScholarship_A;
        int countScholarship_C = n / 2 - countScholarship_A - countScholarship_B;

        TreeMap<Double, ArrayList<Student>> studentMap = new TreeMap<>();
        
        while (n-- > 0) {
            String name = sc.next();
            int subjects = sc.nextInt();
            double totalScore = 0;

            for (int i = 0; i < subjects; i++) {
                totalScore += sc.nextDouble();
            }

            double gpa = totalScore / subjects;
            Student student = new Student(gpa, name);

            studentMap.computeIfAbsent(gpa, k -> new ArrayList<>()).add(student);
        }

        int totalStudentsConsidered = 0;
        String scholarshipType = "";
        for (Map.Entry<Double, ArrayList<Student>> entry : studentMap.descendingMap().entrySet()) {
            totalStudentsConsidered += entry.getValue().size();
            if (totalStudentsConsidered <= countScholarship_A) {
                scholarshipType = "A";
            } else if (totalStudentsConsidered <= countScholarship_B + countScholarship_A) {
                scholarshipType = "B";
            } else if (totalStudentsConsidered <= countScholarship_C + countScholarship_B + countScholarship_A) {
                scholarshipType = "C";
            } else {
                break;
            }
            entry.getValue().sort((s1, s2) -> {
                return s1.name.compareTo(s2.name);
            });
            for (Student s : entry.getValue()) {
                sb.append(s.toString()).append(" ").append(scholarshipType).append("\n");
            }
        }
        System.out.println(sb);
    }

    static class Student {
        double score;
        String name;

        public Student(double score, String name) {
            this.score = score;
            this.name = name;
        }

        public String toString() {
            return this.name + " " + String.format("%.2f", this.score) + " ";
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
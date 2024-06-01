import java.io.*;
import java.util.*;

class EIUGRDSA {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt(); // số lượng sinh viên
        int p = sc.nextInt(); // số lượng bài tập
        int m = sc.nextInt(); // số lần nộp bài

        Map<Integer, Student> studentMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            studentMap.put(id, new Student(id));
        }

        Set<Integer> problems = new HashSet<>();
        for (int j = 0; j < p; j++) {
            problems.add(sc.nextInt());
        }

        for (int k = 0; k < m; k++) {
            int studentId = sc.nextInt();
            int exerciseCode = sc.nextInt();
            int grade = sc.nextInt();

            Student student = studentMap.get(studentId);
            if (student != null) {
                student.addGrade(exerciseCode, grade);
            }
        }

        for (Student student : studentMap.values()) {
            sb.append(student.id).append(" ")
                    .append(student.calculateAvr(p)).append(" ")
                    .append("\n");
        }

        System.out.print(sb);
    }

    public static class Student {
        int id;
        double avr;

        public Student(int id) {
            this.id = id;
        }

        Map<Integer, Integer> gradeMap = new HashMap<>();

        public void addGrade(int exerciseCode, int grade) {
            gradeMap.merge(exerciseCode, grade, Math::max);
        }

        public int calculateAvr(int numExercise) {
            int sum = 0;
            for (int grade : gradeMap.values()) {
                sum += grade;
            }
            return sum / numExercise;
        }
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
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
                    throw new RuntimeException(e);
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

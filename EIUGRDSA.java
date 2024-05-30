import java.io.*;
import java.util.*;

class EIUGRDSA {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Map<Integer, Student> studentMap = new HashMap<>();
        int n = sc.nextInt(); // số lượng sinh viên
        int p = sc.nextInt(); // số lượng bài tập
        int m = sc.nextInt(); // số lần nộp bài

        int[] ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = sc.nextInt();
        }

        // int[] problems = new int[p];
        for (int j = 0; j < p; j++) {
            // problems[j] = sc.nextInt();
            sc.nextInt();
        }

        for (int k = 0; k < m; k++) {
            int studentId = sc.nextInt();
            int exerciseCode = sc.nextInt();
            int grade = sc.nextInt();

            Student student = studentMap.get(studentId);
            if (student == null) {
                student = new Student(studentId);
                studentMap.put(studentId, student);
            }

            student.addGrade(exerciseCode, grade);
        }

        Arrays.sort(ids);

        for (int id : ids) {
            Student student = studentMap.get(id);
            if (student != null) {
                sb.append(id + " " + student.calculateAvr(p) + "\n");
            } else {
                sb.append(id + " 0\n");
            }
        }

        System.out.print(sb);
    }

    public static class Student {
        int id;
        double avr;

        public Student(int id) {
            this.id = id;
        }

        Map<Integer, Integer> mapGrade = new HashMap<>();

        public void addGrade(int exerciseCode, int grade) {
            mapGrade.merge(exerciseCode, grade, Math::max);

            // mapGrade.forEach((code, existingGrade) -> {
            //     if (code == exerciseCode) {
            //         if (grade > existingGrade) {
            //             mapGrade.put(code, grade);
            //         }
            //         return;
            //     }
            // });
            // mapGrade.putIfAbsent(exerciseCode, grade);
        }

        public int calculateAvr(int numExercise) {
            int sum = 0;
            for (int grade : mapGrade.values()) {
                sum += grade;
            }
            return sum / numExercise;
        }

        @Override
        public String toString() {
            return id + " " + avr;
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
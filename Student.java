import java.io.*;
import java.util.*;

class EIUGRDSA2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt(); // số lượng sinh viên
        int p = sc.nextInt(); // số lượng bài tập
        int m = sc.nextInt(); // số lần nộp bài

        Map<Long, Student> studentMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            long id = sc.nextLong();
            studentMap.put(id, new Student(id));
        }

        Set<Long> problems = new HashSet<>();
        for (int j = 0; j < p; j++) {
            problems.add(sc.nextLong());
        }

        for (int k = 0; k < m; k++) {
            long studentId = sc.nextLong();
            long exerciseCode = sc.nextLong();
            int grade = sc.nextInt();

            Student student = studentMap.get(studentId);
            if (student != null && problems.contains(exerciseCode)) {
                student.addGrade(exerciseCode, grade);
            }
        }

        List<Student> printList = new ArrayList<>(studentMap.values());

        printList.sort((s1, s2) -> {
            int compare = Integer.compare(s2.calculateAvr(), s1.calculateAvr());
            if (compare == 0) {
                compare = Integer.compare(s1.validSubmissions, s2.validSubmissions);
            }
            if (compare == 0) {
                compare = Long.compare(s1.id, s2.id);
            }
            return compare;
        });

        for (Student student : printList) {
            sb.append(student.id).append(" ")
              .append(student.calculateAvr()).append(" ")
              .append(student.validSubmissions).append("\n");
        }

        System.out.print(sb);
    }

    public static class Student {
        long id;
        int avr;
        int totalScore;
        int validSubmissions;

        Map<Long, Integer> gradeMap = new HashMap<>();

        public Student(long id) {
            this.id = id;
            this.totalScore = 0;
            this.validSubmissions = 0;
        }

        public void addGrade(long exerciseCode, int grade) {
            gradeMap.merge(exerciseCode, grade, Math::max);
            validSubmissions++;
        }

        public int calculateAvr() {
            int sum = 0;
            for (int grade : gradeMap.values()) {
                sum += grade;
            }
            return this.avr = validSubmissions > 0 ? sum / validSubmissions : 0;
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

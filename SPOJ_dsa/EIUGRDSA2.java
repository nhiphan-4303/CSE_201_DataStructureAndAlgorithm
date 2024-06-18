import java.io.*;
import java.util.*;

class EIUGRDSA2 {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();// student
        int p = sc.nextInt();// exCode
        int m = sc.nextInt();// submission

        Map<Integer, Student> studentMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            studentMap.put(id, new Student(id));
        }

        Set<Integer> excodeSet = new HashSet<>();
        for (int i = 0; i < p; i++) {
            int exCode = sc.nextInt();
            excodeSet.add(exCode);
        }

        for (int i = 0; i < m; i++) {
            int idStudent = sc.nextInt();
            studentMap.putIfAbsent(idStudent, new Student(idStudent));
            Student student = studentMap.get(idStudent);

            int exCode = sc.nextInt();
            int grade = sc.nextInt();
            if (excodeSet.contains(exCode)) {
                student.addGrade(exCode, grade);
            }
        }

        List<Student> printList = new ArrayList<>(studentMap.values());
        printList.sort((s1, s2) -> {
            int compare = Integer.compare(s2.calculateGpa(p), s1.calculateGpa(p));
            if (compare == 0) {
                compare = Integer.compare(s1.validSubmission, s2.validSubmission);
            }
            if (compare == 0) {
                compare = Integer.compare(s1.id, s2.id);
            }
            return compare;
        });

        for (Student s : printList) {
            sb.append(s.id + " " + s.calculateGpa(p) + " " + s.validSubmission + "\n");
        }
        System.out.println(sb);

    }

    static public class Student {

        int id;
        int validSubmission;

        Map<Integer, Integer> gradeMap = new HashMap<>();

        public Student(int id) {
            this.id = id;
            this.validSubmission = validSubmission;
        }

        public void addGrade(int excode, int grade) {
            gradeMap.merge(excode, grade, Math::max);
            validSubmission++;
        }

        public int calculateGpa(int p) {
            int sum = 0;
            for (int grade : gradeMap.values()) {
                sum += grade;
            }
            return sum / p;
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

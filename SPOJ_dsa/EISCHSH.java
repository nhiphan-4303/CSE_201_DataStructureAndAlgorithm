import java.io.*;
import java.util.*;

class EISCHSH {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt(); // số lượng học sinh
        int k = sc.nextInt(); // số lượng học bổng

        List<Student> listStudent = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long id = sc.nextLong();
            String name = sc.next();

            Student student = new Student(id, name);

            int numberOfCourses = sc.nextInt();
            for (int j = 0; j < numberOfCourses; j++) {
                int grade = sc.nextInt();
                if (grade >= 50) {
                    student.addGrade(grade);
                }
            }
            student.calculateAvg();
            listStudent.add(student);
        }

        // sort theo avg và id
        listStudent.sort((s1, s2) -> {
            int compare = Double.compare(s2.avg, s1.avg);
            if (compare == 0) {
                return Long.compare(s1.id, s2.id);
            }
            return compare;
        });

        // tạo rank
        int currentRank = 1;
        for (int i = 0; i < listStudent.size(); i++) {
            if (i > 0 && listStudent.get(i).avg != listStudent.get(i - 1).avg) {
                currentRank = i + 1;
            }

            listStudent.get(i).rank = currentRank;
        }

        // tạo danh sách và chọn lọc các sinh viên có hàng từ 1 đến k để in
        List<Student> listGoodStudent = new ArrayList<>();
        for (Student s : listStudent) {
            if (s.rank <= k) {
                listGoodStudent.add(s);
            } else
                break;
        }

        for (Student s : listGoodStudent) {
            sb.append(s.rank).append(" ").append(s.id).append(" ").append(s.name).append(" ").append(Math.round(s.avg))
                    .append("\n");
        }

        System.out.println(sb.toString().trim());

    }

    public static class Student {
        long id;
        String name;
        double passCourse;
        double totalOfGrade;
        double avg;
        int rank;

        List<Double> listGrades = new ArrayList<>();

        public Student(long id, String name) {
            this.id = id;
            this.name = name;
            this.passCourse = 0.0;
            this.totalOfGrade = 0.0;
        }

        public void addGrade(int grade) {
            passCourse++;
            totalOfGrade += grade;
        }

        public void calculateAvg() {
            avg = passCourse > 0 ? (double) totalOfGrade / passCourse : 0;
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

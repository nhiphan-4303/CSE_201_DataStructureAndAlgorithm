package Test_Final;

import java.util.*;

public class EIUSLS {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            Student student = new Student(i, name);

            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                double grade = sc.nextDouble();
                student.calculateAvg(m, grade);
            }

            studentList.add(student);
        }
        studentList.sort((s1, s2) -> {
            int compare = Double.compare(s2.avg, s1.avg);
            if (compare == 0) {
                return Integer.compare(s1.id, s2.id);
            }
            return compare;
        });

        for (int i = 0; i < Math.min(2, studentList.size()); i++) {
            sb.append(studentList.get(i).name).append("\n");
        }
        System.out.println(sb);
    }

    static public class Student {

        int id;
        String name;
        double totalGrade;
        double avg;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void calculateAvg(int m, double grade) {
            totalGrade += grade;
            avg = totalGrade / m;
        }

    }

}

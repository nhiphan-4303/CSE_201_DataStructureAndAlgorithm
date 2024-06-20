package Test_Final_2;

import java.util.*;

public class EIUGRADE {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        Map<Integer, Student> studentMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            studentMap.putIfAbsent(id, new Student(id));
            int idCourse = sc.nextInt();

            Student student = studentMap.get(id);
            double grade = sc.nextDouble();
            student.calculateGpa(grade);
        }
        List<Student> studentList = new ArrayList<>(studentMap.values());
        studentList.sort((s1, s2) -> {
            int compare = Double.compare(s2.gpa, s1.gpa);
            if (compare == 0) {
                return Integer.compare(s1.id, s2.id);
            }
            return compare;
        });
        for (Student s : studentList) {
            sb.append(s);
        }
        System.out.println(sb);
    }

    static class Student {

        int id;
        double totalGrade;
        double totalCourse;
        double gpa;

        public Student(int id) {
            this.id = id;
        }

        public void calculateGpa(double grade) {
            totalGrade += grade;
            totalCourse += 1;
            gpa = totalGrade / totalCourse;
        }

        @Override
        public String toString() {
            return id + " " + String.format("%.3f", gpa) + "\n";
        }

    }
}

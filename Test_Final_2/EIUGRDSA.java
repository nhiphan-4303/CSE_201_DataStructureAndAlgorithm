package Test_Final_2;

import java.util.*;

public class EIUGRDSA {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt(); //student
        int p = sc.nextInt(); // problem
        int m = sc.nextInt(); // list

        Map<Integer, Student> studentMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            studentMap.put(id, new Student(id));
        }

        Set<Integer> problems = new HashSet<>();
        for (int i = 0; i < p; i++) {
            int idProblem = sc.nextInt();
            problems.add(idProblem);
        }

        for (int i = 0; i < m; i++) {
            int idStudent = sc.nextInt();
            studentMap.putIfAbsent(idStudent, new Student(idStudent));

            Student student = studentMap.get(idStudent);

            int idCourse = sc.nextInt();
            int grade = sc.nextInt();

            student.addGrade(idCourse, grade);
        }

        for (Student s : studentMap.values()) {
            sb.append(s.id + " " + s.calculateGpa(p) + "\n");
        }
        System.out.println(sb);

    }

    static class Student {
        int id;
        int gpa;

        public Student(int id) {
            this.id = id;
        }

        Map<Integer, Integer> gradeMap = new HashMap<>();

        public void addGrade(int idCourse, int grade) {
            gradeMap.merge(idCourse, grade, Math::max);
        }

        public int calculateGpa(int p) {
            int sum = 0;
            for (int grade : gradeMap.values()) {
                sum += grade;
            }
            return gpa = sum / p;
        }

        
    }
}

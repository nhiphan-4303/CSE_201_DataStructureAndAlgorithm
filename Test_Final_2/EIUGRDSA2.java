package Test_Final_2;

import java.util.*;

public class EIUGRDSA2 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int p = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Student> studentMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            studentMap.put(id, new Student(id));
        }

        Set<Integer> problems = new HashSet<>();
        for (int i = 0; i < p; i++) {
            int problemCode = sc.nextInt();
            problems.add(problemCode);
        }

        for (int i = 0; i < m; i++) {
            int idStudent = sc.nextInt();
            studentMap.putIfAbsent(idStudent, new Student(idStudent));

            int idCourse = sc.nextInt();
            Student student = studentMap.get(idStudent);
            int grade = sc.nextInt();
            if (problems.contains(idCourse)) {
                student.addGrade(idCourse, grade);
            }
        }

        List<Student> printList = new ArrayList<>(studentMap.values());
        printList.sort((s1, s2) -> {
            int compare = Integer.compare(s2.calculateGpa(p), s1.calculateGpa(p));
            if (compare == 0) {
                compare = Integer.compare(s1.validSubmission, s2.validSubmission);
            }
            if (compare == 0) {
                return Integer.compare(s1.id, s2.id);
            }
            return compare;
        });

        for (Student s : printList) {
            sb.append(s.id + " " + s.calculateGpa(p) + " " + s.validSubmission + "\n");
        }
        System.out.println(sb);

    }

    static class Student {

        int id;
        int gpa;
        int validSubmission;

        public Student(int id) {
            this.id = id;
        }

        Map<Integer, Integer> gradeMap = new HashMap<>();

        public void addGrade(int idProblem, int grade) {
            gradeMap.merge(idProblem, grade, Math::max);
            validSubmission++;
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

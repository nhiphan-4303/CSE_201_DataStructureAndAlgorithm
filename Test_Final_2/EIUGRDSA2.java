package Test_Final_2;

import java.util.*;

public class EIUGRDSA2 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int p = sc.nextInt();
        long m = sc.nextLong();

        Map<Long, Student> studentMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            long ids = sc.nextLong();
            studentMap.put(ids, new Student(ids));
        }

        Set<Long> exCodeSet = new HashSet<>();
        for (int i = 0; i < p; i++) {
            exCodeSet.add(sc.nextLong());
        }

        for (int i = 0; i < m; i++) {
            long idStudent = sc.nextLong();
            studentMap.putIfAbsent(idStudent, new Student(idStudent));
            Student student = studentMap.get(idStudent);

            long exCodeStudent = sc.nextLong();
            long grade = sc.nextLong();
            if (exCodeSet.contains(exCodeStudent)) {
                student.addGrade(exCodeStudent, grade);
            }
        }

        List<Student> printList = new ArrayList<>(studentMap.values());
        printList.sort((s1, s2) -> {
            int compare = Long.compare(s2.calculateGpa(p), s1.calculateGpa(p));
            if (compare == 0) {
                compare = Long.compare(s1.validSubmission, s2.validSubmission);
            }
            if (compare == 0) {
                compare = Long.compare(s1.id, s2.id);
            }
            return compare;
        });

        for (Student s : printList) {
            sb.append(s.id + " " + s.calculateGpa(p) + " " + s.validSubmission + "\n");
        }

        System.out.println(sb);
    }

    static class Student {

        long id;
        long gpa;
        long validSubmission;

        public Student(long id) {
            this.id = id;
        }

        Map<Long, Long> gradeMap = new HashMap<>();

        public void addGrade(long exCode, long grade) {
            gradeMap.merge(exCode, grade, Math::max);
            validSubmission++;
        }

        public long calculateGpa(int p) {
            long sum = 0;
            for (Long grade : gradeMap.values()) {
                sum += grade;
            }
            return gpa = sum / p;
        }
    }

}

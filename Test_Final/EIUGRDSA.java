package Test_Final;

import java.util.*;

public class EIUGRDSA {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt(); // student
        int p = sc.nextInt(); // ex code
        int m = sc.nextInt(); // submission

        Map<Integer, Student> studentMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            studentMap.put(id, new Student(id));
        }

        Set<Integer> excodeSet = new HashSet<>();
        for (int i = 0; i < p; i++) {
            int excode = sc.nextInt();
            excodeSet.add(excode);
        }

        for (int i = 0; i < m; i++) {
            int idStudent = sc.nextInt();
            studentMap.putIfAbsent(idStudent, new Student(idStudent));
            Student student = studentMap.get(idStudent);

            int excodeStudent = sc.nextInt();
            int grade = sc.nextInt();

            student.addGrade(excodeStudent, grade);
        }

        for (Student s:studentMap.values()){
            sb.append(s.id + " " + s.calculateGpa(p) + " " +"\n");
        }

        System.out.println(sb);
    }

    static public class Student {
        int id;

        public Student(int id) {
            this.id = id;
        }

        Map<Integer, Integer> gradeMap = new HashMap<>();

        public void addGrade(int excode, int grade) {
            gradeMap.merge(excode, grade, Math::max);
        }

        public int calculateGpa(int p) {
            int sum = 0;
            for (int grade : gradeMap.values()) {
                sum += grade;
            }
            return sum / p;
        }

    }
}

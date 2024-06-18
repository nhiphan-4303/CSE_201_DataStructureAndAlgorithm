package Test_Final;

import java.util.*;

public class EICREDIT {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();

        List<Student> listStudents = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int course = sc.nextInt();

            Student student = new Student(name);

            for (int j = 0; j < course; j++) {
                int grade = sc.nextInt();
                if (grade >= 50) {
                    student.calculateCredit(grade);
                }
            }

            listStudents.add(student);
        }

        for (Student s : listStudents) {
            sb.append(s.name + " " + s.totalCredit + "\n");
        }
        System.out.println(sb);
    }

    static public class Student {
        String name;
        int totalCredit;

        public Student(String name) {
            this.name = name;
            this.totalCredit = 0;
        }

        public void calculateCredit(int grade) {
            this.totalCredit += 4;
        }
    }
}

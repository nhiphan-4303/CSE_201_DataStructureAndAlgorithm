package Test_Final;

import java.util.*;

public class EICREDI2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        List<Student> listStudent = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int course = sc.nextInt();

            Student student = new Student(name);

            for (int j = 0; j < course; j++) {
                int grade = sc.nextInt();
                if (grade >= 50) {
                    student.calculateGpa(grade);
                }
            }

            listStudent.add(student);
        }

        for (Student s : listStudent) {
            sb.append(s.name + " " + s.passGrade + s.gpa + "\n");
        }
        System.out.println(sb);
    }

    static public class Student {
        String name;
        int totalPassGrade;
        int passCourse;
        int gpa;

        StringBuilder passGrade = new StringBuilder();

        public Student(String name) {
            this.name = name;
            this.passCourse = 0;
            this.gpa = 0;
        }

        public int calculateGpa(int grade) {
            passCourse++;
            totalPassGrade += grade;
            passGrade.append(grade + " ");

            if (passCourse > 0) {
                return gpa = totalPassGrade / passCourse;
            } else
                return 0;
        }
    }
}

package Test_Final_2;

import java.util.*;

public class EICREDI2 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            Student student = new Student(name);
            int course = sc.nextInt();

            while (course-- > 0) {
                int grade = sc.nextInt();
                if (grade >= 50) {
                    student.calculate(grade);
                }
            }
            studentList.add(student);
        }
        for (Student s : studentList) {
            sb.append(s);
        }

        System.out.println(sb);
    }

    static class Student {

        String name;
        int passCourse;
        int totalGrade;
        int gpa;

        public Student(String name) {
            this.name = name;
        }

        StringBuilder passGrade = new StringBuilder();

        public void calculate(int grade) {
            passCourse += 1;
            passGrade.append(grade + " ");
            totalGrade += grade;
            if (passCourse > 0) {
                gpa = totalGrade / passCourse;
            }
        }

        @Override
        public String toString() {
            return name + " " + passGrade + gpa + "\n";
        }
    }

}

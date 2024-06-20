package Test_Final_2;

import java.util.*;

public class EIUGRADE {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        
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

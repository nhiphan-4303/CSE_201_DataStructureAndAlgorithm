package Test_Final;

import java.util.*;

public class EIGRADU {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        int n = sc.nextInt();
        int credit = sc.nextInt();

        for (int i = 0; i < n; i++) {
            long id = sc.nextLong();
            String name = sc.next();

            Student student = new Student(id, name);
            int course = sc.nextInt();
            for (int j = 0; j < course; j++) {
                double grade = sc.nextDouble();
                if (grade >= 50) {
                    student.calculateCreditAndGpa(grade);
                }
            }
            studentList.add(student);
        }
        studentList.sort((s1, s2) -> {
            int compare = Double.compare(s2.gpa, s1.gpa);
            if (compare == 0) {
                return Long.compare(s1.id, s2.id);
            }
            return compare;
        });

        for (Student s : studentList) {
            if (s.totalCredit >= credit) {
                sb.append(s.id + " " + s.name + " " + (long) Math.floor(s.gpa)  + "\n");
            }
        }

        System.out.println(sb);
    }

    static public class Student {

        long id;
        String name;
        int totalPassCoures;
        long totalCredit;
        double totalGrade;
        double gpa;

        public Student(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public void calculateCreditAndGpa(double grade) {
            totalPassCoures++;
            totalCredit += 4;
            totalGrade += grade;
            gpa = totalGrade / totalPassCoures;
        }

    }
}

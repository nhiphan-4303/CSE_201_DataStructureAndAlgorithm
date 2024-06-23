package Test_Final_2;

import java.util.*;

public class EISTULI {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        int n = sc.nextInt(); //student
        int k = sc.nextInt(); //print

        for (int i = 0; i < n; i++) {
            long id = sc.nextLong();
            String name = sc.next();
            Student student = new Student(id, name, i);

            int course = sc.nextInt();
            for (int j = 0; j < course; j++) {
                double grade = sc.nextDouble();
                if (grade >= 50) {
                    student.calculate(grade);
                }
            }
            studentList.add(student);
        }

        studentList.sort((s1, s2) -> {
            int compare = Double.compare(s2.gpa, s1.gpa);
            if (compare == 0) {
                return Integer.compare(s1.index, s2.index);
            }
            return compare;
        });

        for (int i = 0; i < k; i++) {
            Student student = studentList.get(i);
            sb.append(student);
            if (n > k && studentList.get(i + 1).gpa == studentList.get(k).gpa) {
                break;
            }
        }

        System.out.println(sb);
    }

    static class Student {

        long id;
        String name;
        int index;
        double gpa;
        double totalGrade;
        int totalCredit;

        public Student(long id, String name, int index) {
            this.id = id;
            this.name = name;
            this.index = index;
        }

        public void calculate(double grade) {
            totalCredit += 4;
            totalGrade += grade;
            gpa = totalGrade / (double) (totalCredit / 4.0);
        }

        @Override
        public String toString() {
            return id + " " + name + " " + Math.round(gpa) + " " + totalCredit + "\n";
        }
    }
}

package Test_Final;

import java.util.*;

public class EISCHSH {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        int n = sc.nextInt();//student
        int k = sc.nextInt();//scholarship

        for (int i = 0; i < n; i++) {
            long id = sc.nextLong();
            String name = sc.next();

            Student student = new Student(id, name);
            int course = sc.nextInt();
            for (int j = 0; j < course; j++) {
                double grade = sc.nextDouble();
                if (grade >= 50) {
                    student.calculateGpa(grade);
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

        int currentRank = 1;
        for (int i = 0; i < studentList.size(); i++) {
            if (i > 0 && studentList.get(i).gpa != studentList.get(i - 1).gpa) {
                currentRank = i + 1;
            }
            studentList.get(i).rank = currentRank;
        }

        List<Student> goodStudentList = new ArrayList<>();
        for (Student s : studentList) {
            if (s.rank <= k) {
                goodStudentList.add(s);
            } else {
                break;
            }
        }

        for (Student s : goodStudentList) {
            sb.append(s);
        }

        System.out.println(sb);

    }

    static public class Student {

        int rank;
        long id;
        String name;
        int validCourse;
        double totalGrade;
        double gpa;

        public Student(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public void calculateGpa(double grade) {
            validCourse++;
            totalGrade += grade;
            gpa = totalGrade / (double) validCourse;
        }

        @Override
        public String toString() {
            return rank + " " + id + " " + name + " " + Math.round(gpa) + "\n";
        }

    }
}

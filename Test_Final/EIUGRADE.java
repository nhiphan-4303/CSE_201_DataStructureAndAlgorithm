package Test_Final;

import java.util.*;

public class EIUGRADE {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();

        Map<Long, Student> studentMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long id = sc.nextLong();
            int subjectCode = sc.nextInt();
            double grade = sc.nextDouble();

            studentMap.putIfAbsent(id, new Student(id));
            Student student = studentMap.get(id);
            student.calculateAvg(grade);
        }

        List<Student> studentList = new ArrayList<Student>(studentMap.values());
        studentList.sort((s1, s2) -> {
            int compare = Double.compare(s2.avg, s1.avg);
            if (compare == 0) {
                compare = Long.compare(s1.id, s2.id);
            }
            return compare;
        });

        for (Student s : studentList) {
            //sb.append(s.id + " " + String.format("%.3f", s.avg) + "\n");
            sb.append(s.id + " " +  s.avg + "\n");
        }

        System.out.println(sb);
    }

    static class Student {
        long id;
        double totalSubject;
        double totalScore;
        double avg;

        public Student(long id) {
            this.id = id;
        }

        public void calculateAvg(double grade) {
            totalScore += grade;
            totalSubject++;
            avg = totalScore / totalSubject;
        }
    }

}

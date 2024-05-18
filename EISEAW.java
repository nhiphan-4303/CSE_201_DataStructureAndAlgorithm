import java.util.*;
import java.io.*;

class EISEAW {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int wagePerH = sc.nextInt();
            int days = sc.nextInt();

            int totalHours = 0;
            for (int j = 0; j < days; j++) {
                totalHours += sc.nextInt();
            }

            int income = totalHours * wagePerH;
            if (income >= 2000000) {
                income *= 0.9;
            }

            employees.add(new Employee(name, totalHours, (int) income));
        }

        employees.sort((e1, e2) -> {
            if (e2.income != e1.income) {
                return e1.income - e2.income;
            } else {
                return e1.name.compareTo(e2.name);
            }
        });

        for (Employee e : employees) {
            sb.append(e.name + " " + e.totalHours + " " + e.income + "\n");
        }

        System.out.println(sb);

    }

    static class InputReader {

        StringTokenizer tokenizer;

        BufferedReader reader;

        String token;

        String temp;

        public InputReader(InputStream stream) {

            tokenizer = null;

            reader = new BufferedReader(new InputStreamReader(stream));

        }

        public InputReader(FileInputStream stream) {

            tokenizer = null;

            reader = new BufferedReader(new InputStreamReader(stream));

        }

        public String nextLine() throws IOException {

            return reader.readLine();

        }

        public String next() {

            while (tokenizer == null || !tokenizer.hasMoreTokens()) {

                try {

                    if (temp != null) {

                        tokenizer = new StringTokenizer(temp);

                        temp = null;

                    } else {

                        tokenizer = new StringTokenizer(reader.readLine());

                    }

                } catch (IOException e) {

                }

            }

            return tokenizer.nextToken();

        }

        public double nextDouble() {

            return Double.parseDouble(next());

        }

        public int nextInt() {

            return Integer.parseInt(next());

        }

        public long nextLong() {

            return Long.parseLong(next());

        }

    }
}

class Employee {
    String name;
    int totalHours;
    int income;

    public Employee(String name, int totalHours, int income) {
        this.name = name;
        this.totalHours = totalHours;
        this.income = income;
    }
}

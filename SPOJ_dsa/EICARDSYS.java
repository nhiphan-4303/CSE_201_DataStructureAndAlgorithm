import java.io.*;
import java.text.*;
import java.util.*;

class EICARDSYS {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {
        int n = sc.nextInt();
        Map<String, Customer> mapCustomer = new HashMap<>();
        double totalDiscount = 0;

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            double price = sc.nextDouble();

            Customer customer = mapCustomer.getOrDefault(id, new Customer());
            double previousPurchase = customer.totalPurchase;
            customer.totalPurchase += price;

            mapCustomer.put(id, customer);

            if (previousPurchase < 1_000_000) {
            } else if (previousPurchase < 20_000_000) {
                totalDiscount += price * 0.02;
            } else if (previousPurchase < 50_000_000) {
                totalDiscount += price * 0.03;
            } else if (previousPurchase < 200_000_000) {
                totalDiscount += price * 0.05;
            } else {
                totalDiscount += price * 0.07;
            }
        }
        sb.append(df.format(totalDiscount));
        System.out.println(sb);

    }

    static class Customer {
        double totalPurchase;
        String id;
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

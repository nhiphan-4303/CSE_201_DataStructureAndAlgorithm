import java.io.*;
import java.util.*;

public class EIHPROFIT {
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

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Product> listProducts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int price = sc.nextInt();
            int cost = sc.nextInt();
            int quantity = sc.nextInt();

            Product product = new Product(id, name);
            product.calcaluteProfit(price, cost, quantity);

            listProducts.add(product);
        }

        listProducts.sort((p1, p2) -> {
            if (p2.profit != p1.profit) {
                return Long.compare(p2.profit, p1.profit);
            }
            return Integer.compare(p1.id, p2.id);
        });

        long lastProfit = Long.MIN_VALUE;
        int count = 0;

        for (Product p : listProducts) {
            if (count < k || p.profit == lastProfit) {
                sb.append(p).append("\n");
                lastProfit = p.profit;
                count++;
            } else {
                break;
            }
        }
        System.out.println(sb);
    }

    static class Product {
        int id;
        String name;
        long profit;

        public Product(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public long calcaluteProfit(int price, int cost, int quantity) {
            return this.profit = (long) (price - cost) * (long) quantity;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + this.profit;
        }
    }

}

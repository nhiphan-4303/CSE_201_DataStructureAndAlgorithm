package Test_Final_2;

import java.util.*;

public class EIHPROFIT {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();

            Product product = new Product(id, name);
            int price = sc.nextInt();
            int cost = sc.nextInt();
            int quantity = sc.nextInt();

            product.calculateProfit(price, cost, quantity);
            productList.add(product);
        }

        productList.sort((p1, p2) -> {
            int compare = Long.compare(p2.profit, p1.profit);
            if (compare == 0) {
                return Integer.compare(p1.id, p2.id);
            }
            return compare;
        });

        int count = 0;
        long lastHighest = -1;
        for (Product p : productList) {
            if (count < k || p.profit == lastHighest) {
                sb.append(p);
                count++;
                lastHighest = p.profit;
            } else {
                break;
            }
        }

        System.out.println(sb);
    }

    static public class Product {

        int id;
        String name;
        long profit;

        public Product(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public long calculateProfit(int price, int cost, int quantity) {
            return this.profit = (long) (price - cost) * (long) quantity;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + this.profit + '\n';
        }
    }
}

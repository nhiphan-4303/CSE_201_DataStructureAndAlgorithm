package Test_Final;

import java.util.*;

public class EISTOCK {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        Map<Long, Product> productMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            long code = sc.nextLong();
            long quantity = sc.nextLong();
            long price = sc.nextLong();

            Product p = productMap.getOrDefault(code, new Product());

            if (type.equals("+")) {
                p.stockQuantity += quantity;
                p.importPrice += (quantity * price);
            } else if (type.equals("-")) {
                if (p.stockQuantity >= quantity) {
                    p.stockQuantity -= quantity;
                    p.exportPrice += (quantity * price);
                }
            }
            productMap.put(code, p);
        }

        List<Long> codeList = new ArrayList<>(productMap.keySet());
        codeList.sort(null);
        
        for (Long code : codeList) {
            Product p = productMap.get(code);
            if (p.importPrice > 0 || p.exportPrice > 0) {
                sb.append(code + " " + p.importPrice + " " + p.exportPrice + "\n");
            }
        }
        System.out.println(sb);
    }

    static class Product {

        long stockQuantity = 0;
        long importPrice = 0;
        long exportPrice = 0;
    }
}

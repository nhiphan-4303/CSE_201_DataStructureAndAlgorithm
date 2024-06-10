import java.util.*;
import java.io.*;

class EISTOCK2 {

    static Random rd = new Random();
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int tc = sc.nextInt();
        TreeMap<Integer, Stock> storeStocks = new TreeMap<>();
        while (tc-- > 0) {
            String Im_Ex = sc.next();
            int id = sc.nextInt();
            long quantity = sc.nextLong();
            long price = sc.nextLong();
            int time = sc.nextInt();

            Stock stock = storeStocks.getOrDefault(id, new Stock(id));

            if (Im_Ex.equals("+")) {
                Product product = new Product(price, quantity, time);
                stock.storeProducts.add(product);

                stock.totalQuantity += quantity;
                stock.totalPrice += quantity * price;
            } else {

                if (stock.totalQuantity >= quantity) {
                    stock.totalQuantity -= quantity;

                    while (stock.storeProducts.size() != 0) {
                        if (quantity > stock.storeProducts.peek().quantityProduct) {
                            quantity -= stock.storeProducts.peek().quantityProduct;
                            stock.totalPrice -= stock.storeProducts.peek().quantityProduct
                                    * stock.storeProducts.peek().priceProduct;
                            stock.storeProducts.poll();

                        } else if (quantity == stock.storeProducts.peek().quantityProduct) {
                            stock.totalPrice -= stock.storeProducts.peek().quantityProduct
                                    * stock.storeProducts.peek().priceProduct;
                            stock.storeProducts.poll();
                            break;
                        } else {
                            stock.totalPrice -= quantity * stock.storeProducts.peek().priceProduct;
                            stock.storeProducts.peek().quantityProduct -= quantity;
                            break;
                        }
                    }
                }
            }
            storeStocks.put(id, stock);
        }

        for (Map.Entry<Integer, Stock> entry : storeStocks.entrySet()) {
            if (entry.getValue().totalQuantity != 0) {
                sb.append(entry.getValue().id).append(" ").append(entry.getValue().totalQuantity).append(" ")
                        .append(entry.getValue().getAverage()).append(" ").append(entry.getValue().getOldestItem())
                        .append("\n");
            }

        }
        System.out.println(sb);

    }

    static class Stock {
        int id;
        long totalPrice;
        long totalQuantity;

        Queue<Product> storeProducts = new ArrayDeque<>();

        public Stock(int id) {
            this.id = id;
        }

        public long getAverage() {
            return (long) Math.floor(totalPrice / totalQuantity);
        }

        public int getOldestItem() {
            return storeProducts.peek().time;
        }

    }

    static class Product {
        long quantityProduct;
        long priceProduct;
        int time;

        public Product(long priceProduct, long quantityProduct, int time) {
            this.time = time;
            this.priceProduct = priceProduct;
            this.quantityProduct = quantityProduct;
        }

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
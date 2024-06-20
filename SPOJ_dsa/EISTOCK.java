import java.io.*;
import java.util.*;

class EISTOCK {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt(); // Number of transactions
        Map<Long, ProductInfo> products = new HashMap<>(); // Changed Map to use Long for product codes

        for (int i = 0; i < n; i++) {
            String type = sc.next(); // Transaction type remains String
            long code = sc.nextLong(); // Changed to read as long
            long quantity = sc.nextLong();
            long price = sc.nextLong();

            ProductInfo info = products.getOrDefault(code, new ProductInfo());
            if (type.equals("+")) {
                // Import transaction
                info.stockQuantity += quantity;
                info.totalImportValue += quantity * price;
            } else if (type.equals("-")) {
                // Export transaction
                if (info.stockQuantity >= quantity) {
                    info.stockQuantity -= quantity;
                    info.totalExportValue += quantity * price;
                }
            }
            products.put(code, info);
        }

        // Output results sorted by product code
        List<Long> codes = new ArrayList<>(products.keySet());
        codes.sort(null);

        for (Long code : codes) {
            ProductInfo info = products.get(code);
            if (info.totalImportValue > 0 || info.totalExportValue > 0) {
                sb.append(code + " " + info.totalImportValue + " " + info.totalExportValue + "\n");
            }
        }

        System.out.println(sb);
    }

    static class ProductInfo {
        long stockQuantity = 0;
        long totalImportValue = 0;
        long totalExportValue = 0;
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}

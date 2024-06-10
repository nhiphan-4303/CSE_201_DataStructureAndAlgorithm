import java.util.*;
import java.io.*;

public class EISTOCK {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        int nTransactions = sc.nextInt();
        Map<Long, Transaction> mapTransactions = new HashMap<>();
        for (int i = 0; i < nTransactions; i++) {

            String sign = sc.next();
            long id = sc.nextLong();
            long quantity = sc.nextLong();
            long valueOfGoods = sc.nextLong();

            Transaction ts = null;
            if (!mapTransactions.containsKey(id)) {
                if (sign.equals("+")) {
                    ts = new Transaction(id);
                    ts.calValue(sign, quantity, valueOfGoods);
                    mapTransactions.put(id, ts);
                }
            } else {
                ts = mapTransactions.get(id);
                ts.calValue(sign, quantity, valueOfGoods);
            }

        }

        List<Transaction> listTransactions = new ArrayList<>(mapTransactions.values());
        listTransactions.sort((a, b) -> Long.compare(a.id, b.id));

        for (Transaction transaction : listTransactions) {
            sb.append(transaction).append("\n");
        }
        System.out.println(sb);
    }

    static class Transaction {
        long id;
        long quantity;
        long totalImportValue;
        long totalExportValue;

        public Transaction(long id) {
            this.id = id;
        }

        public void calValue(String sign, long quantity, long valueOfGood) {
            if (sign.equals("+")) {
                this.quantity += quantity;
                totalImportValue += valueOfGood * quantity;
            } else {
                if (this.quantity >= quantity) {
                    this.quantity -= quantity;
                    totalExportValue += valueOfGood * quantity;
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.id).append(" ").append(this.totalImportValue).append(" ").append(this.totalExportValue);
            return sb.toString();
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

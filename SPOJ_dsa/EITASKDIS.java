import java.io.*;
import java.util.*;

public class EITASKDIS {
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

    static StringBuilder sb = new StringBuilder();
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        PriorityQueue<Worker> listWorkers = new PriorityQueue<>((w1, w2) -> {
            int compare = Long.compare(w1.totalTime, w2.totalTime);
            if (compare == 0) {
                compare = w1.id - w2.id;
            }
            return compare;
        });

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int id = 0; id < n; id++) {
            Worker worker = new Worker(id);
            listWorkers.add(worker);
        }

        int[] tasks = new int[m];
        for (int i = 0; i < m; i++) {
            tasks[i] = sc.nextInt();
        }

        Arrays.sort(tasks);

        for (int i = m - 1; i >= 0; i--) {
            Worker worker = listWorkers.poll();
            worker.totalTime += tasks[i];
            listWorkers.add(worker);
        }

        long[] result = new long[n];
        while (!listWorkers.isEmpty()) {
            Worker worker = listWorkers.poll();
            result[worker.id] = worker.totalTime;
        }

        for (long time : result) {
            sb.append(time).append(" ");
        }
        System.out.println(sb);
    }

    static class Worker {
        int id;
        long totalTime;

        public Worker(int id) {
            this.id = id;
            this.totalTime = 0;
        }
    }
}

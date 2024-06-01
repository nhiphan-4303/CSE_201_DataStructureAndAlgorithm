package Test_2;

import java.io.*;
import java.util.*;

public class EITASKDIS {
    // Sử dụng StringBuilder để xây dựng chuỗi kết quả
    static StringBuilder sb = new StringBuilder();
    // Sử dụng InputReader để đọc đầu vào nhanh hơn
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        // Đọc số lượng người làm việc và số lượng công việc
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Đọc thời gian hoàn thành của từng công việc
        int[] tasks = new int[m];
        for (int i = 0; i < m; i++) {
            tasks[i] = sc.nextInt();
        }

        // Sắp xếp thời gian hoàn thành công việc theo thứ tự giảm dần
        Arrays.sort(tasks);

        // Khởi tạo PriorityQueue để quản lý người làm việc dựa trên tổng thời gian làm việc
        PriorityQueue<Worker> pq = new PriorityQueue<>((w1, w2) -> {
            if (w1.totalTime != w2.totalTime) {
                return Long.compare(w1.totalTime, w2.totalTime);
            } else {
                return Integer.compare(w1.id, w2.id);
            }
        });

        // Khởi tạo danh sách người làm việc và thêm vào PriorityQueue
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Worker worker = new Worker(i);
            pq.add(worker);
            workers.add(worker);
        }

        // Phân công công việc từ công việc có thời gian hoàn thành lớn nhất đến nhỏ nhất
        for (int i = m - 1; i >= 0; i--) {
            Worker worker = pq.poll(); // Lấy người có tổng thời gian làm việc ít nhất hiện tại
            worker.totalTime += tasks[i]; // Giao công việc hiện tại cho người này
            pq.add(worker); // Thêm lại người làm việc vào PriorityQueue với tổng thời gian mới
        }

        // Xây dựng chuỗi kết quả tổng thời gian làm việc của mỗi người
        for (Worker worker : workers) {
            sb.append(worker.totalTime).append(" ");
        }
        System.out.println(sb);
    }

    // Lớp Worker đại diện cho một người làm việc với ID và tổng thời gian làm việc
    static class Worker {
        int id;
        long totalTime;

        public Worker(int id) {
            this.id = id;
            this.totalTime = 0;
        }
    }

    // Lớp InputReader để đọc đầu vào nhanh và hiệu quả
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
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


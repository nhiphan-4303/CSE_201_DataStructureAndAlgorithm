import java.util.Scanner;

public class EIPICNIC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] count = new int[5];  // Đếm số nhóm từ 1 đến 4 người.
        int n = sc.nextInt(); // Số lượng nhóm bạn.
        
        for (int i = 0; i < n; i++) {
            count[sc.nextInt()]++;
        }

        int cars = count[4] // Mỗi nhóm 4 người cần một xe.
                + count[3] // Mỗi nhóm 3 người cần một xe.
                + (count[2] + 1) / 2; // Hai nhóm 2 người dùng chung một xe, làm tròn lên.
        
        int leftover = count[1] - count[3]; // Số người trong nhóm 1 còn lại sau khi ghép với nhóm 3 người.
        
        if (count[2] % 2 == 1) { // Nếu có một nhóm 2 dư ra, chúng ta cần thêm một xe, và nhóm này có thể đưa thêm hai người.
            leftover -= 2;
        }

        if (leftover > 0) {
            cars += (leftover + 3) / 4; // Mỗi bốn người dùng một xe, làm tròn lên.
        }

        System.out.println(cars);
        sc.close();
    }
}

import java.util.*;
import java.util.Map;


class EIUPH010 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        max(num);
    }

    public static void max(int[] num) {
        // Arrays.sort(num);
        // 4 3 4 3
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int x : num) {
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }

        int minKey = Integer.MAX_VALUE;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                minKey = entry.getKey();
            } else if (entry.getValue() == maxValue) {
                if (entry.getKey() < minKey) {
                    minKey = entry.getKey();
                }
            }
        }
        System.out.println(minKey + " " + maxValue);

    }
}

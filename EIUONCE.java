import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EIUONCE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int size = sc.nextInt();
            int[] a = new int[size];
            for(int j = 0; j < size; j++){
                a[j] = sc.nextInt();
            }
            once(a);
            System.out.println();
        }
        
    }
    public static void once(int [] a){
        List<Integer> list = new ArrayList<>();
        Arrays.sort(a);
        for(int x : a){
            if(!list.contains(x) && countOccur(a, x) == 1){
                list.add(x);
            }
        }

        for(int x : list){
            System.out.print(x + " ");
        }
    }
    public static int countOccur(int [] a, int num){
        int count = 0;
        for(int x : a){
            if(x == num){
                count++;
            }
        }
        return count;
    }
}

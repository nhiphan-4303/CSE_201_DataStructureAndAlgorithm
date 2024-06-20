package Test_Final;
import java.text.*;
import java.util.*;
public class EICARDSYS {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static DecimalFormat df = new DecimalFormat("#.##");
    public static void main(String[] args) {
        int n = sc.nextInt();
        Map <String,Customer> customerMap = new HashMap<>();
        double totalDis = 0;
        for (int i =0; i<n; i++){
            String id = sc.next();
            double price = sc.nextDouble();

            Customer customer = customerMap.getOrDefault(id, new Customer());
            double prePurchase = customer.totalPurchase;
            customer.totalPurchase+=price;
            
            customerMap.put(id,customer);
            if (prePurchase < 1_000_000){
            }else if (prePurchase < 20_000_000){
                totalDis+=price * 0.02;
            }else if (prePurchase < 50_000_000){
                totalDis+=price * 0.03;
            }else if (prePurchase < 200_000_000){
                totalDis+=price * 0.05;
            }else{
                totalDis+=price * 0.07;
            }
        }
        sb.append(df.format(totalDis));
        System.out.println(sb);
    }

    static class Customer{
        String id;
        double totalPurchase;
    }
}

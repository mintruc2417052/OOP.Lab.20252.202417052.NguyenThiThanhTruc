import java.util.Arrays;
import java.util.Scanner;

public class Bai65 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        //in mang ban dau
        for(int i : a){
            System.out.print(i + " ");
        }
        System.out.println("");

        // sx mang
        Arrays.sort(a);
        //in mang sau khi sx
        for(int i : a){
            System.out.print(i + " ");
        }
        System.out.println("");
        
        // Tính tổng
        int sum = 0;
        for (int i : a) {
            sum += i;
        }

        // Tính trung bình
        double tb = (double) sum / n;

        System.out.println("tong: " + sum);
        System.out.println("trung binh: " + tb);
    }
}
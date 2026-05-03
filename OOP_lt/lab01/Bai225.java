import java.util.Scanner;

public class Bai225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        System.out.println("sum: "+ (a+b));
        System.out.println("difference: "+ (a-b));
        System.out.println("product: "+ a*b);
        if(b==0) System.out.println("Khong chia duoc");
        else System.out.println("quotient: " + a/b);
    }
}

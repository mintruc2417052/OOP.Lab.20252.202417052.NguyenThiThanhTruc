import java.util.Scanner;

public class Bai226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //nhap a11, a12, b1
        double a11 = sc.nextDouble();
        double a12 = sc.nextDouble();
        double b1 = sc.nextDouble();

        //nhap a21, a22, b2
        double a21 = sc.nextDouble();
        double a22 = sc.nextDouble();
        double b2 = sc.nextDouble();

        //tinh cac dinh thuc D, D1, D2
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("hpt co nghiem duy nhat: x1 = " + x1 + ", x2 = " + x2);
        } else {
            if (D1 == 0 && D2 == 0) {
                System.out.println("hpt co vo so nghiem");
            } else {
                System.out.println("hpt vo nghiem");
            }
        }
       
    }
}
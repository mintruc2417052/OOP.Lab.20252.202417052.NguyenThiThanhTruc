import java.util.Scanner;

public class Bai64 {

    // check nam nhuan
    public static boolean check(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // ham convert month into number
    public static int toNum(String month) {
        month = month.toLowerCase().replace(".", "");
        switch (month) {
            case "january": case "jan": case "1": return 1;
            case "february": case "feb": case "2": return 2;
            case "march": case "mar": case "3": return 3;
            case "april": case "apr": case "4": return 4;
            case "may": case "5": return 5;
            case "june": case "jun": case "6": return 6;
            case "july": case "jul": case "7": return 7;
            case "august": case "aug": case "8": return 8;
            case "september": case "sep": case "9": return 9;
            case "october": case "oct": case "10": return 10;
            case "november": case "nov": case "11": return 11;
            case "december": case "dec": case "12": return 12;
            default: return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int monthNumber = -1;
        int year = -1;
        
        //input month
        while (monthNumber == -1) {
            String monthInput = sc.nextLine();
            monthNumber = toNum(monthInput);
            if (monthNumber == -1) {
                System.out.println("Invalid month! Try again.");
            }
        }

        //input year
        while (year < 0) {
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year < 0) {
                    System.out.println("Sao nam lai am? Nhap lai di");
                }
            } else {
                System.out.println("Nam ko xac dinh");
                sc.next(); 
            }
        }

        //xac dinh so ngay
        int days;
        switch (monthNumber) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31; break;
            case 4: case 6: case 9: case 11:
                days = 30; break;
            case 2:
                days = check(year) ? 29 : 28;
                break;
            default:
                days = 0;
        }

        System.out.println("res: " + days);
    }
}
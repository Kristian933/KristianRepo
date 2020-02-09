import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pounds = Double.parseDouble(scanner.nextLine());

        //double poundInCents = pounds * 100 ;
        double poundInDollars = pounds * 1.31;
        //double dollars = poundInDollars / 100 ;

        System.out.printf("%.3f",poundInDollars);

    }
}

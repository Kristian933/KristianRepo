import java.math.BigDecimal;
import java.util.Scanner;

public class BigDecimal1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());

        java.math.BigDecimal sum = new java.math.BigDecimal(0);

        for (int i = 1 ; i <= numbers ;i++){
            java.math.BigDecimal digits =  new java.math.BigDecimal(scanner.nextLine());
            sum= sum.add(digits);
        }

        System.out.println(sum);

    }
}

import java.util.Scanner;

public class printAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int stop = Integer.parseInt(scanner.nextLine());

        int sum = 0 ;
        for (int number = start; number <= stop; number++) {
            System.out.print(number);
            System.out.print(" ");
            sum += number;
        }
        System.out.printf("%nSum: %d",sum);
    }
}

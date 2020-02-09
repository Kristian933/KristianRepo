import java.util.Scanner;

public class MetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int meters = Integer.parseInt(scanner.nextLine());

        double convert = meters / 1000.0 ;
        System.out.printf("%.2f",convert);


    }
}

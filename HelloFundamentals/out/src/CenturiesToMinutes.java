import java.util.Scanner;

public class CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int centuries = Integer.parseInt(scanner.nextLine());

        int centuriesToYears = centuries * 100;
        int yearsToDays = (int) (centuriesToYears * 365.2422);
        int daysToHours = yearsToDays * 24;
        int hoursToMinutes = daysToHours * 60;

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes",centuries,centuriesToYears,yearsToDays,daysToHours,hoursToMinutes);
    }
}

import java.util.Scanner;

public class Pokemon {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int powerN = Integer.parseInt(scanner.nextLine());
        int distanceM = Integer.parseInt(scanner.nextLine());
        int exhaustionFactorY = Integer.parseInt(scanner.nextLine());

        int countTargets = 0;
        int currentPower = powerN;

        while (currentPower >= distanceM) {
            currentPower -= distanceM;
            countTargets++;

            if (currentPower == 0.5 * powerN) {
                if (exhaustionFactorY > 0) {
                    currentPower /= exhaustionFactorY;
                }
            }


        }
        System.out.println(currentPower);
        System.out.println(countTargets);

    }
}
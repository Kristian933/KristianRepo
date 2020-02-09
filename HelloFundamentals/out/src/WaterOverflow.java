import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfWaterComingIn = Integer.parseInt(scanner.nextLine());

        int waterTank = 255;
        int waterSum = 0;
        int spaceLeft = 0;

        for (int i = 1; i <= numberOfWaterComingIn ; i++){
            int water = Integer.parseInt(scanner.nextLine());
            spaceLeft = waterTank - waterSum;
            if (water > spaceLeft){
                System.out.println("Insufficient capacity!");
            } else if (waterSum < waterTank){
                waterSum+=water;
            }

        }
        System.out.println(waterSum);
    }
}

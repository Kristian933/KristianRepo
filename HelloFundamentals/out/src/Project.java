import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<String> finalOutput = new ArrayList<>();

        int numberInput = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberInput; i++) {
            int randomNumber = random.nextInt(10);
            int randomChar = 65 + (int) (Math.random() * ((90 - 65) + 1));
            int digitOrChar = random.nextInt(2);

            if (randomNumber == 0) {
                randomNumber++;
            }
            if (digitOrChar % randomNumber == 0) {
                finalOutput.add(String.valueOf((char) randomChar));
            } else {
                finalOutput.add(String.valueOf(randomNumber));
            }
            if (finalOutput.size() % 4 == 0) {
                System.out.print("-");
            }
        }

        for (String input : finalOutput) {
            System.out.print(input);
        }

    }
}

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String firstOne = input.substring(0,input.indexOf(" ")).trim();
        String secondOne = input.substring(input.indexOf(" ")+ 1).trim();

        int sum = calcSum(firstOne, secondOne);
        System.out.println(sum);

    }

    private static int calcSum(String firstOne, String secondOne) {
        int sum = 0;

        for (int i = 0; i < firstOne.length() && i < secondOne.length(); i++) {
            sum += firstOne.charAt(i) * secondOne.charAt(i);
        }

        if (firstOne.length() > secondOne.length()) {
            for (int i = secondOne.length(); i < firstOne.length(); i++) {
                sum += firstOne.charAt(i);
            }
        } else {
            for (int i = firstOne.length(); i < secondOne.length(); i++) {
                sum += secondOne.charAt(i);
            }
        }


        return sum;
    }
}

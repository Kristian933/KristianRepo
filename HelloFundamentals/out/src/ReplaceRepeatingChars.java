
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String symbolOne = "";


        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (i == 0) {
                symbolOne = String.valueOf(symbol);
                System.out.print(symbol);
            }
            if (!String.valueOf(symbol).equals(symbolOne)) {
                System.out.print(symbol);
                symbolOne = String.valueOf(symbol);
            }
        }


    }
}

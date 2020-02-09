import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        middleCharacters(line);


    }

    static void middleCharacters(String line) {
        int length = line.length();
        if (length % 2 == 0) {
            char firstOne = line.charAt(length / 2 - 1);
            char secondOne = line.charAt(length / 2);
            System.out.printf("%c%c",firstOne,secondOne);
        }else {
            char onlyOne = line.charAt(length / 2);
            System.out.println(onlyOne);
        }
    }
}

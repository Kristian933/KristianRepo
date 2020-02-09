import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        System.out.println(number(word));

    }

    static int number(String text) {
        int counter = 0;
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'){
                counter++;
            }
        }
        return counter;
    }
}

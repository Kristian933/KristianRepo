import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            builder.append(symbol);
            if (symbol == '>') {
                i++;
                int power = input.charAt(i) - '0';
                int j = i;
                for (; j < i + power && j < input.length(); j++) {
                    if (input.charAt(j) == '>') {
                        builder.append('>');
                        power += (input.charAt(j + 1) - '0') + 1;
                    }
                }
                i = j - 1;
            }
        }

        System.out.println(builder.toString());

    }
}

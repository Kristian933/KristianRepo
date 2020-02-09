import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder string = new StringBuilder();
        string.append(input);
        input = scanner.nextLine();

        boolean isValid = true;
        int index = 0;
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");

            if (tokens[0].equals("Translate")) {
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == tokens[1].charAt(0)) {
                        string.setCharAt(i, tokens[2].charAt(0));
                    }
                }
                System.out.println(string);
            } else if (tokens[0].equals("Includes")) {
                if (string.toString().contains(tokens[1])) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }

            } else if (tokens[0].equals("Start")) {
                for (int i = 0; i < tokens[1].length(); i++) {
                    if (string.charAt(i) == tokens[1].charAt(i)) {
                        isValid = true;
                    } else {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            } else if (tokens[0].equals("Lowercase")) {
                String lowerCase = string.toString().toLowerCase();
                string.delete(0, string.length());
                string.append(lowerCase);
                System.out.println(string);
            } else if (tokens[0].equals("FindIndex")) {
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == tokens[1].charAt(0)) {
                        index = i;
                    }
                }
                System.out.println(index);
                index = 0;
            } else if (tokens[0].equals("Remove")) {
                string.delete(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                System.out.println(string);
            }
            input = scanner.nextLine();
        }
    }
}

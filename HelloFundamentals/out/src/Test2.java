import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        String regex = "^([$%])([A-Z][a-z]+)\\1: \\[([0-9]+)\\]\\|\\[([0-9]+)\\]\\|\\[([0-9]+)\\]\\|$";
        Pattern pattern = Pattern.compile(regex);
        int number= 0;

        for (int i = 0; i < input; i++) {
            String massage = scanner.nextLine();
            Matcher matcher = pattern.matcher(massage);

            if (matcher.find()){
                if (matcher.group(2).length() > 3) {
                    System.out.printf("%s: ", matcher.group(2));
                }else {
                    System.out.println("Valid message not found!");
                    break;
                }
                System.out.printf("%c",Integer.parseInt(matcher.group(3)));
                System.out.printf("%c",Integer.parseInt(matcher.group(4)));
                System.out.printf("%c%n",Integer.parseInt(matcher.group(5)));
            }else {
                System.out.println("Valid message not found!");
            }
        }
    }
}

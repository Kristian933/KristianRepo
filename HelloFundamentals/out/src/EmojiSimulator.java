import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] numbers = scanner.nextLine().split(":");
        int numbersSum = 0;
        for (String number : numbers) {
            numbersSum += Integer.parseInt(number);
        }


        String regex = "[,.!? ]?:([a-z]+):[,.!? ]";
        Pattern pattern = Pattern.compile(regex);

        List<Integer> ASCIIValue = new ArrayList<>();
        List<String> emojiFound = new ArrayList<>();
        int sum = 0;
        int finalPower = 0;


        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            if (matcher.group(1).length() >= 4) {
                emojiFound.add(matcher.group(1));
                for (int i = 0; i < matcher.group(1).length(); i++) {
                    char symbol = matcher.group(1).charAt(i);
                    sum += symbol;
                }
                ASCIIValue.add(sum);
                sum = 0;
            }
        }
        for (Integer value : ASCIIValue) {
            finalPower += value;
        }
        for (Integer integer : ASCIIValue) {
            if (integer.equals(numbersSum)) {
                finalPower *= 2;
            }
        }


        if (emojiFound.size() > 0){
            System.out.print("Emojis found:");
        }
        for (int i = 0; i < emojiFound.size(); i++) {
            if (emojiFound.get(i).equals(emojiFound.get(emojiFound.size() - 1))) {
                System.out.printf(" :%s:", emojiFound.get(i));
            } else {
                System.out.printf(" :%s:,", emojiFound.get(i));
            }

        }

        System.out.println();

        System.out.println("Total Emoji Power: " + finalPower);

    }
}

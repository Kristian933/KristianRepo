import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "^([!@#$?\\w+]+)=([\\d]+)<<(.+)";
        Pattern pattern = Pattern.compile(regex);
        List<String> name = new ArrayList<>();
        int length =0;
        int charsLength =0;

        while (!input.equals("Last note")){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                length = Integer.parseInt(matcher.group(2));
                charsLength = matcher.group(3).length();
                if (length == charsLength){
                    for (int i = 0; i < matcher.group(1).length(); i++) {
                        if (Character.isLetterOrDigit(matcher.group(1).charAt(i))){
                            name.add(String.valueOf(matcher.group(1).charAt(i)));
                        }
                    }
                    System.out.print("Coordinates found! ");
                    for (String entry : name) {
                        System.out.print(entry);
                    }
                    System.out.println(" -> " + matcher.group(3));
                    length=0;
                    charsLength=0;
                    name.clear();
                }else {
                    length=0;
                    charsLength=0;
                    name.clear();
                    System.out.println("Nothing found!");
                }
            }else {
                System.out.println("Nothing found!");
            }
            input = scanner.nextLine();
        }
    }
}

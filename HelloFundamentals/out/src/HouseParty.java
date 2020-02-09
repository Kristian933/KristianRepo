import java.util.ArrayList;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayList<String> guests = new ArrayList<>();

        String input;

        for (int i = 0; i < number; i++) {
            input = scanner.nextLine();
            String[] tokens = input.split(" +");
            if (input.contains("not")){
                if (guests.contains(tokens[0])){
                    guests.remove(tokens[0]);
                }else {
                    System.out.printf("%s is not in the list!%n",tokens[0]);
                }
            }else {
                if (guests.contains(tokens[0])){
                    System.out.printf("%s is already in the list!%n",tokens[0]);
                }else {
                    guests.add(tokens[0]);
                }
            }
        }

        for (int i = 0; i < guests.size(); i++) {
            System.out.println(guests.get(i));
        }


    }
}

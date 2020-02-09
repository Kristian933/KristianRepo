import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split(" +")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("No Money")) {
            String[] operations = input.split(" +");
            if (input.contains("Out")) {
                for (int i = 0; i < list.size(); i++) {
                    if (operations[1].equals(list.get(i))) {
                        list.set(i, "None");
                    }
                }
            } else if (input.contains("Required")) {
                int index = Integer.parseInt(operations[2]);
                if (index >= 0 && index < list.size()) {
                    list.set(Integer.parseInt(operations[2]), operations[1]);
                }
            } else if (input.contains("Just")) {
                list.set(list.size() - 1, operations[1]);
            }


            input = scanner.nextLine();
        }
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals("None")) {
                System.out.print(list.get(i) + " ");
            }
        }

    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        String[] input = scanner.nextLine().split(" +");
        for (int i = 0; i < input.length; i++) {
            list.add(Integer.parseInt(input[i]));
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split(" +");
            if (command.contains("Delete")) {
                int position = Integer.parseInt(tokens[1]);
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i)== position){
                        list.remove(i);
                        i--;
                    }
                }
            } else {
                int element = Integer.parseInt(tokens[1]);
                int position = Integer.parseInt(tokens[2]);
                if (position >= 0 && position < list.size()) {
                    list.add(position, element);
                }
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }


    }
}

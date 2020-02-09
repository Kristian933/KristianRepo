import java.util.Map;
import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder line = new StringBuilder();

        while (!input.equals("End")){
            String[] tokens = input.split(" ");
            String command = tokens[0];

            if (command.contains("Add")){
                String string = tokens[1];
                line.append(string);
            }else if (command.contains("Upgrade")){
                char symbol =  tokens[1].charAt(0);
                for (int i = 0; i < line.length(); i++) {
                    if (symbol == line.charAt(i)){
                        line.setCharAt(i, (char) ((symbol)+1));
                    }
                }
            }else if (command.contains("Print")){
                System.out.println(line);
            }else if (command.contains("Index")){
                char symbol =  tokens[1].charAt(0);
                for (int i = 0; i < line.length(); i++) {
                    if (symbol == line.charAt(i)){
                        if (line.charAt(i) == line.length()) {
                            System.out.print(i);
                        }else {
                            System.out.print(i + " ");
                        }
                    }
                }
                System.out.println();
            }else if (command.contains("Remove")){
                String string = tokens[1];
                while (line.toString().contains(string)){
                    int delete = line.indexOf(string);
                    if (delete!= -1 ){
                        line.delete(delete,delete + string.length());
                    }
                }
            }
            input = scanner.nextLine();
        }
    }
}

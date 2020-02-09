import java.util.*;
import java.util.stream.Collectors;

public class LastStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> paintingNumbers = Arrays.stream(scanner.nextLine()
                .split(" +")).map(Integer::parseInt)
                .collect(Collectors.toList());


        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] instructions = input.split(" +");


            if (input.contains("Change")) {
                int number = Integer.parseInt(instructions[1]);
                int changed = Integer.parseInt(instructions[2]);
                for (int i = 0; i < paintingNumbers.size(); i++) {
                    if (paintingNumbers.get(i) == number) {
                        paintingNumbers.set(i, changed);
                        break;
                    }
                }

            } else if (input.contains("Hide")) {
                int number = Integer.parseInt(instructions[1]);
                for (int i = 0; i < paintingNumbers.size(); i++) {
                    if (number == paintingNumbers.get(i)) {
                        paintingNumbers.remove(i);
                        break;
                    }
                }
            } else if (input.contains("Switch")) {
                int number = Integer.parseInt(instructions[1]);
                int paintingNumber = Integer.parseInt(instructions[2]);
                boolean firstCheck = false;
                boolean secondCheck = false;
                String firstCheck1 = "";
                String secondCheck2 = "";
                for (int i = 0; i < paintingNumbers.size(); i++) {
                    if (paintingNumbers.get(i) == number) {
                        firstCheck = true;
                        firstCheck1 = String.valueOf(i + " " + number);
                    }
                    if (paintingNumbers.get(i) == paintingNumber) {
                        secondCheck = true;
                        secondCheck2 = String.valueOf(i + " " + paintingNumber);
                    }
                    if (firstCheck && secondCheck) {
                        String[] first = firstCheck1.split(" ");
                        int index = Integer.parseInt(first[0]);
                        int token = Integer.parseInt(first[1]);
                        String[] second = secondCheck2.split(" ");
                        int index2 = Integer.parseInt(second[0]);
                        int token2 = Integer.parseInt(second[1]);
                        paintingNumbers.set(index2, token);
                        paintingNumbers.set(index, token2);
                        break;
                    }
                    // Collections.swap !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                }

            } else if (input.contains("Insert")) {
                int place = Integer.parseInt(instructions[1]);
                int paintingNumber = Integer.parseInt(instructions[2]);
                if (paintingNumbers.size() >= place) {
                    paintingNumbers.add(place + 1, paintingNumber);
                }

            } else if (input.contains("Reverse")) {
                Collections.reverse(paintingNumbers);

            }


            input = scanner.nextLine();
        }

        for (int i = 0; i < paintingNumbers.size(); i++) {
            System.out.print(paintingNumbers.get(i) + " ");
        }


    }
}

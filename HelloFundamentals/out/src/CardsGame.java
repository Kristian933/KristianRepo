import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scanner.nextLine()
                .split(" +")).map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondDeck = Arrays.stream(scanner.nextLine()
                .split(" +")).map(Integer::parseInt)
                .collect(Collectors.toList());

        int firstSum = 0;
        int secondSum = 0;


        while (firstDeck.size() > 0 && secondDeck.size() > 0) {
            if (firstDeck.get(0) > secondDeck.get(0)) {
                int winning = firstDeck.remove(0);
                firstDeck.add(winning);
                firstDeck.add(secondDeck.get(0));
                secondDeck.remove(secondDeck.get(0));
            } else if (firstDeck.get(0) < secondDeck.get(0)) {
                int winning = secondDeck.remove(0);
                secondDeck.add(winning);
                secondDeck.add(firstDeck.get(0));
                firstDeck.remove(firstDeck.get(0));
            } else {
                firstDeck.remove(firstDeck.get(0));
                secondDeck.remove(secondDeck.get(0));
            }
        }

        if (firstDeck.size() > 0) {
            for (int i = 0; i < firstDeck.size(); i++) {
                firstSum += firstDeck.get(i);
            }

        }else {
            for (int i = 0; i < secondDeck.size(); i++) {
                secondSum += secondDeck.get(i);
            }
        }

        if (firstSum >secondSum){
            System.out.printf("First player wins! Sum: %d",firstSum);
        }else {
            System.out.printf("Second player wins! Sum: %d",secondSum);
        }
    }
}

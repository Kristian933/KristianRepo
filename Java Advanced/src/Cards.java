import java.util.*;
import java.util.stream.Collectors;

public class Cards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> playerWithCards = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {

            String[] tokens = input.split(": ");
            String name = tokens[0];
            List<String> cards = Arrays.stream(tokens[1].split(", "))
                    .collect(Collectors.toList());

            playerWithCards.putIfAbsent(name, new HashSet<>());
            playerWithCards.get(name).addAll(cards);
            input = scanner.nextLine();
        }

        playerWithCards.forEach((key, value) -> {
            int power = calPower(value);
            System.out.printf("%s: %d%n", key, power);
        });
    }

    private static int calPower(Set<String> value) {
        int power = 0;

        for (String card : value) {
            power += calCardPower(card);
        }

        return power;
    }

    private static int calCardPower(String card) {
        int power = 0;

        char firstLetter = card.charAt(0);

        switch (firstLetter) {
            case 'J':
                power += 11;
                break;
            case 'Q':
                power += 12;
                break;
            case 'K':
                power += 13;
                break;
            case 'A':
                power += 14;
                break;
            case '1':
                power += 10;
                break;
            default:
                power += firstLetter - '0';
                break;
        }

        switch (card.charAt(card.length() - 1)) {
            case 'S':
                power *= 4;
                break;
            case 'H':
                power *= 3;
                break;
            case 'D':
                power *= 2;
                break;
        }
        return power;

    }
}

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> bombs = Arrays.stream(scanner.nextLine()
                .split(" +")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String[] specialNumbers = scanner.nextLine().split(" +");
        int specialBomb = Integer.parseInt(specialNumbers[0]);
        int power = Integer.parseInt(specialNumbers[1]);


        for (int i = 0; i < bombs.size(); i++) {
            if (specialBomb == bombs.get(i)) {
                for (int j = 0; j < power * 2 + 1; j++) {
                    if (bombs.size() >= power && power <= bombs.get(j)) {
                        bombs.remove(bombs.get(i - power));
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < bombs.size(); i++) {
            sum += bombs.get(i);
        }
        System.out.println(sum);

    }
}

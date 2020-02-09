import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MakeASalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vegetables = scanner.nextLine().split(" ");

        int[] calories = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<String> vegetablesStack = new ArrayDeque<>();
        ArrayDeque<Integer> saladQueue = new ArrayDeque<>();

        for (int calorie : calories) {
            saladQueue.push(calorie);
        }

        for (String vegetable : vegetables) {
            vegetablesStack.offer(vegetable);
        }



        while (!vegetablesStack.isEmpty() && !saladQueue.isEmpty()) {
            int salad = saladQueue.pop();
            int saladCalories = salad;

            while (salad >= 0 && !vegetablesStack.isEmpty()) {

                String vegitebles = vegetablesStack.pop();
                if ("tomato".equals(vegitebles)) {
                    salad -= 80;
                } else if ("carrot".equals(vegitebles)) {
                    salad -= 136;
                } else if ("lettuce".equals(vegitebles)) {
                    salad -= 109;
                } else if ("potato".equals(vegitebles)) {
                    salad -= 215;
                }

                if (salad <= 0) {
                    System.out.print(saladCalories + " ");
                    saladCalories = 0;
                }

            }

        }
        System.out.println();
        if (vegetablesStack.size() != 0) {
            for (String s : vegetablesStack) {
                System.out.print(s + " ");
            }

        }
        System.out.println();
        if (saladQueue.size() != 0) {
            for (int s : saladQueue) {
                System.out.print(s + " ");
            }

        }

    }
}

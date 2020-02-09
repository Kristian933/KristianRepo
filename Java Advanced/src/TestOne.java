import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class TestOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] males = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] females = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> malesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> femaleStack = new ArrayDeque<>();

        for (int male : males) {
            malesQueue.push(male);
        }
        for (int female : females) {
            femaleStack.offer(female);
        }
        int matches = 0;

        while (!malesQueue.isEmpty() && !femaleStack.isEmpty()) {

            int maleCheck = malesQueue.getFirst();
            int femaleCheck = femaleStack.getFirst();
            if (maleCheck == 25) {
                malesQueue.pop();
                malesQueue.pop();
            }
            if (femaleCheck == 25) {
                femaleStack.pop();
                femaleStack.pop();
            }
            if (malesQueue.isEmpty() || femaleStack.isEmpty()) {
                break;
            }
            int zeroCheckOne = malesQueue.getFirst();
            if (zeroCheckOne <= 0) {
                malesQueue.pop();
            }
            int zeroCheckFemaleOne = femaleStack.getFirst();
            if (zeroCheckFemaleOne <= 0) {
                femaleStack.pop();
            }
            if (malesQueue.isEmpty() || femaleStack.isEmpty()) {
                break;
            }
            if (malesQueue.getFirst().equals(femaleStack.getFirst())) {
                malesQueue.pop();
                femaleStack.pop();
                matches++;
            } else {
                femaleStack.pop();
                int male = malesQueue.getFirst();
                male -= 2;
                malesQueue.pop();
                malesQueue.addFirst(male);
            }
            if (malesQueue.isEmpty() || femaleStack.isEmpty()) {
                break;
            }
            int zeroCheck = malesQueue.getFirst();
            if (zeroCheck <= 0) {
                malesQueue.pop();
            }
            int zeroCheckFemale = femaleStack.getFirst();
            if (zeroCheckFemale <= 0) {
                femaleStack.pop();
            }
        }
        System.out.printf("Matches: %d%n", matches);

        if (malesQueue.isEmpty()) {
            System.out.print("Males left: none");
        } else {
            System.out.print("Males left: ");
            for (Integer integer : malesQueue) {
                if (malesQueue.size() == 1) {
                    System.out.print(integer);
                } else {
                    System.out.print(integer + ", ");
                    malesQueue.pop();
                }
            }
        }
        System.out.println();

        if (femaleStack.isEmpty()) {
            System.out.print("Females left: none");
        } else {
            System.out.print("Females left: ");
            for (Integer integer : femaleStack) {
                if (femaleStack.size() == 1) {
                    System.out.print(integer);
                } else {
                    System.out.print(integer + ", ");
                    femaleStack.pop();
                }
            }
        }

    }
}

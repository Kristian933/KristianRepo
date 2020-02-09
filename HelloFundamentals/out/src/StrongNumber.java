

import java.util.Scanner;

public class StrongNumber{
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);

        String num = enter.nextLine();
        int endInt = Integer.parseInt(num);

        int factorialSum = 0;
        int lastNumToMultiply = 1;

        for (int i = 0; i <= num.length() - 1; i++) {
            char currentNumChar = num.charAt(i);
            int currentNum = Character.getNumericValue(currentNumChar);
            for (int x = currentNum; x >= 1; x--) {
                lastNumToMultiply*=x;
            }
            factorialSum+=lastNumToMultiply;
            lastNumToMultiply = 1;
        }

        if (endInt == factorialSum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
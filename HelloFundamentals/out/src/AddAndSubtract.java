import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());


        System.out.println(subtract(sumOfFirstAndSecond(firstNumber,secondNumber),thirdNumber));


    }

    static int sumOfFirstAndSecond(int first,int second){
        int sumOfTwo = first + second;
        return sumOfTwo;
    }

    static int subtract (int sum,int third){
        int subtract = sum - third;
        return subtract;
    }
}

import java.util.ArrayDeque;
import java.util.Scanner;

public class Balanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean areBalansed = true;

        for (int i = 0; i <input.length() ; i++) {
            char symbol = input.charAt(i);
            if (symbol == '[' || symbol == '{' || symbol == '('){
                stack.push(symbol);
            }else {
                if (stack.isEmpty()){
                    areBalansed = false;
                    break;
                }
                char last = stack.pop();

                if (last == '{' && symbol != '}'){
                    areBalansed = false;
                    break;
                }else if (last == '[' && symbol != ']') {
                    areBalansed = false;
                    break;
                }else if (last == '(' && symbol != ')') {
                    areBalansed = false;
                    break;
                }
            }
        }
        if (areBalansed){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}

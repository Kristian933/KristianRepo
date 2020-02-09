import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String password = "";

        for (int index = username.length() - 1 ;index >= 0 ; index-- ){
            password += username.charAt(index);
        }
        String enterPassword = scanner.nextLine();
        for (int i = 1; i <= 4;i ++) {
            if (enterPassword.equals(password)) {
                System.out.printf("User %s logged in.", username);
                break;
            } else if (i == 4){
                System.out.printf("User %s blocked!",username);
            }else {
                System.out.println("Incorrect password. Try again.");
                enterPassword= scanner.nextLine();
            }
        }

    }
}

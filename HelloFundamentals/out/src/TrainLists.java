import java.util.ArrayList;
import java.util.Scanner;

public class TrainLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> train = new ArrayList<>();

        String[] input = scanner.nextLine().split(" ");
        for (int i = 0; i <input.length ; i++) {
            train.add(Integer.parseInt(input[i]));
        }

        int capacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while(!command.equals("end")){
            String[] index = command.split(" ");
            if (command.contains("Add")){
                int passengers = Integer.parseInt(index[1]);
               train.add(passengers);
            }else {
                int passengers = Integer.parseInt(index[0]);
                    for (int i = 0; i < train.size(); i++) {
                        int newPassengers = passengers + train.get(i);
                        if (newPassengers <= capacity) {
                            train.set(i, newPassengers);
                            break;
                        }
                    }
            }
            command = scanner.nextLine();
        }

        for (int i = 0; i < train.size(); i++) {
            System.out.print(train.get(i)+ " ");
        }


    }
}

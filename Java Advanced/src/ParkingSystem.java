import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //reading input data
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();

        boolean[][] parkingAvailability = new boolean[r][c];
        String commands = scanner.nextLine();

        //start parking
        while (!commands.equals("stop")) {
            int[] tokens = Arrays.stream(commands.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int z = tokens[0];
            int x = tokens[1];
            int y = tokens[2];

            if (rowIsFull(x, parkingAvailability)) {
                System.out.printf("Row %d full%n", x);
            } else {
                int distance = moveCar(z, x, y, parkingAvailability);
                System.out.println(distance);
            }
            commands = scanner.nextLine();
        }
    }

    private static int moveCar(int z, int x, int y, boolean[][] parkingAvailability) {
        int distance = Math.abs(x - z) + 1;   //car travels on the first column to the desired row.
        if (!parkingAvailability[x][y]) {   //if the initial spot is free - car moves there
            distance += y;
            parkingAvailability[x][y] = true;    //mark spot as taken
        } else {   // if the initial spot is taken

            int bestSpotLeft = y;
            for (int i = y; i >= 0; i--) {
                if (!parkingAvailability[x][i]) {
                    bestSpotLeft = i;
                    break;
                }

            }
            int bestSpotRigth = y;
            for (int i = y; i < parkingAvailability[x].length; i++) {
                if (!parkingAvailability[x][i]) {
                    bestSpotRigth = i;
                    break;
                }

            }
            int bestSpot = 0;
            if (bestSpotLeft == 0) {
                bestSpot = bestSpotRigth;
            } else if (bestSpotRigth == y) {
                bestSpot = bestSpotLeft;
            } else {
                int difLeft = y - bestSpotLeft;
                int difRight = bestSpotRigth - y;
                if (difRight < difLeft) {    //comparing the differences to find the nearest
                    bestSpot = bestSpotRigth;
                } else {
                    bestSpot = bestSpotLeft;
                }
            }


            parkingAvailability[x][bestSpot] = true;  //marking spot as taken
            distance += bestSpot;     //calculating distance

        }

        return distance;
    }

    private static boolean rowIsFull(int x, boolean[][] parkingAvailability) {
        for (int i = 1; i < parkingAvailability[x].length; i++) {
            if (!parkingAvailability[x][i]) {
                return false;
            }
        }
        return true;
    }

}
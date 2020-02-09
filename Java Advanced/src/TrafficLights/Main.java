package TrafficLights;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Lights[] trafficLights = Arrays.stream(scanner.nextLine().split(" "))
                .map(Lights::valueOf)
                .toArray(Lights[]::new);
        int number = Integer.parseInt(scanner.nextLine());

        Lights[] lights1 = Lights.values();
        StringBuilder builder = new StringBuilder();


        for (int i = 0; i < number; i++) {
            for (int j = 0; j < trafficLights.length; j++) {
                int index = (trafficLights[j].ordinal() + 1) % lights1.length;
                trafficLights[j] = lights1[index];

                builder.append(trafficLights[j].toString() + " ");
            }
            builder.append(System.lineSeparator());
        }

        System.out.println(builder.toString());
    }
}

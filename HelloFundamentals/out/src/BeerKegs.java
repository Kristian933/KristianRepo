import java.util.Objects;
        import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yield = Integer.parseInt(scanner.nextLine());
        int workers = 26;
        int spice = 0;
        int count = 0;

        while (yield >= 100){
            spice += yield;
            spice-=workers;
            yield-=10;
            count++;
        }
        if (spice >= workers) {
            spice -= workers;
        }
        System.out.println(count);
        System.out.println(spice);
    }
}

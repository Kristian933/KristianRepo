import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightSaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double lightSaberNeed = Math.ceil(students + (students * 0.10));
        double lightSabersPrice = lightSaberNeed * lightSaberPrice;
        double robesPrice = students * robePrice;
        double beltsPrice = students* beltPrice;

        if (students >= 6) {
            double beltsNeed =Math.abs(students / 6 ) ;
            double finalBelts = beltsNeed * beltPrice;
            beltsPrice -=finalBelts;
        }


        double totalSum =  lightSabersPrice + robesPrice + beltsPrice ;

        if (sum >= totalSum){
            System.out.printf("The money is enough - it would cost %.2flv.",totalSum);
        }else {
            double finalPrice = totalSum - sum;
            System.out.printf("Ivan Cho will need %.2flv more.",finalPrice);
        }


    }
}

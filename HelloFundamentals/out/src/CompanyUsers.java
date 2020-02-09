import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> companyes = new TreeMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" -> ");
            String companY = tokens[0];
            String id = tokens[1];

            if (!companyes.containsKey(companY)){
                List<String> employ = new ArrayList<>();
                employ.add(id);
                companyes.put(companY,employ);
            }else {
                if (!companyes.get(companY).contains(id)) {
                    List<String> employ = companyes.get(companY);
                    employ.add(id);
                    companyes.put(companY, employ);
                }
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : companyes.entrySet()) {
            System.out.println(entry.getKey());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.println(String.format("-- %s",entry.getValue().get(i)));
            }
        }

    }
}

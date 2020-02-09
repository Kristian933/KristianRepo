import java.util.*;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> stores = new HashMap<>();

        while (!input.equals("END")) {
            String[] tokens = input.split("->");
            if (tokens[0].equals("Add")) {
                String[] items = tokens[2].split(",");
                stores.putIfAbsent(tokens[1], new ArrayList<>());
                for (String item : items) {
                    stores.get(tokens[1]).add(item);
                }
            } else {
                stores.remove(tokens[1]);
            }
            input = scanner.nextLine();
        }
        System.out.println("Stores list:");

        stores.entrySet().stream().sorted((b, a) -> {
        int result = Integer.compare(a.getValue().size(),b.getValue().size());
        if (result ==0){
            result= a.getKey().compareTo(b.getKey());
        }
        return result;
        }).forEach( entry -> {
            System.out.printf("%s%n",entry.getKey());
            entry.getValue().forEach(item -> System.out.printf("<<%s>>%n",item));
        });

    }
}

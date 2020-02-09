import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> sideAndNames = new HashMap<>();


        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                String[] tokens = input.split(" \\| ");
                String forceSide = tokens[0];
                String forceUser = tokens[1];

                sideAndNames.putIfAbsent(forceSide, new ArrayList<>());
                if (!sideAndNames.get(forceSide).contains(forceUser)) {
                    sideAndNames.get(forceSide).add(forceUser);
                }

            } else {
                String[] tokens = input.split(" -> ");
                String forceUser = tokens[0];
                String forceSide = tokens[1];
                boolean isPresent = false;

                for (Map.Entry<String, List<String>> entry : sideAndNames.entrySet()) {

                    if (entry.getValue().contains(forceUser)) {
                        sideAndNames.get(entry.getKey()).remove(forceUser);
                        sideAndNames.putIfAbsent(forceSide, new ArrayList<>());
                        sideAndNames.get(forceSide).add(forceUser);
                        isPresent = true;
                        break;
                    }
                }
                if (!isPresent) {
                    sideAndNames.putIfAbsent(forceSide, new ArrayList<>());
                    sideAndNames.get(forceSide).add(forceUser);
                }

                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }
            input = scanner.nextLine();
        }

        sideAndNames.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue().size(), a.getValue().size());
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(entry -> {
            if (entry.getValue().size() != 0) {
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                entry.getValue().stream().sorted(String::compareTo)
                        .forEach(user -> System.out.println("! " + user));
            }
        });
    }

}

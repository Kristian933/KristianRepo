package GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long capacity = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> items = new LinkedHashMap<>();

        long gold = 0;
        long stones = 0;
        long money = 0;

        for (int i = 0; i < input.length; i += 2) {
            String item = input[i];
            long quantity = Long.parseLong(input[i + 1]);
            String itemName = "";

            if (item.length() == 3) {
                itemName = "Cash";
            } else if (item.toLowerCase().endsWith("gem")) {
                itemName = "Gem";
            } else if (item.toLowerCase().equals("gold")) {
                itemName = "Gold";
            }

            if (itemName.equals("")) {
                continue;
            } else if (capacity < items.values()
                    .stream().map(Map::values)
                    .flatMap(Collection::stream)
                    .mapToLong(e -> e)
                    .sum() + quantity) {
                continue;
            }

            switch (itemName) {
                case "Gem":
                    if (!items.containsKey(itemName)) {
                        if (items.containsKey("Gold")) {
                            if (quantity > items.get("Gold")
                                    .values()
                                    .stream()
                                    .mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (items.get(itemName)
                            .values()
                            .stream()
                            .mapToLong(e -> e)
                            .sum() + quantity >
                            items.get("Gold")
                                    .values()
                                    .stream()
                                    .mapToLong(e -> e)
                                    .sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!items.containsKey(itemName)) {
                        if (items.containsKey("Gem")) {
                            if (quantity > items.get("Gold")
                                    .values()
                                    .stream()
                                    .mapToLong(e -> e)
                                    .sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (items.get(itemName)
                            .values()
                            .stream()
                            .mapToLong(e -> e)
                            .sum() + quantity >
                            items.get("Gem")
                                    .values()
                                    .stream()
                                    .mapToLong(e -> e)
                                    .sum()) {
                        continue;
                    }
                    break;
            }

            if (!items.containsKey(itemName)) {
                items.put((itemName), new LinkedHashMap<String, Long>());
            }

            if (!items.get(itemName).containsKey(item)) {
                items.get(itemName).put(item, 0L);
            }


            items.get(itemName).put(item, items.get(itemName).get(item) + quantity);
            switch (itemName) {
                case "Gold":
                    gold += quantity;
                    break;
                case "Gem":
                    stones += quantity;
                    break;
                case "Cash":
                    money += quantity;
                    break;
            }
        }

        for (Map.Entry<String, LinkedHashMap<String, Long>> entry : items.entrySet()) {
            Long sumValues = entry.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", entry.getKey(), sumValues));

            entry.getValue()
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2
                            .getKey().compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}
import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        number *= 2;

        LinkedHashMap<String, List<Double>> studentsInfo = new LinkedHashMap<>();

        String names = "";

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 1) {
                String name = scanner.nextLine();
                names = name;
                //students.putIfAbsent(name, new ArrayList<>()); !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                if (!studentsInfo.containsKey(name)) {
                    List<Double> grade = new ArrayList<>();
                    studentsInfo.put(name, grade);
                }
            } else {
                double grade = Double.parseDouble(scanner.nextLine());
                if (studentsInfo.containsKey(names)) {
                    List<Double> grades = studentsInfo.get(names);
                    grades.add(grade);
                    studentsInfo.put(names, grades);
                }
            }

        }


        Map<String, Double> studentsGrades = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : studentsInfo.entrySet()) {
            double grade = entry.getValue().stream().mapToDouble(a -> a).average().getAsDouble();

            if (grade >= 4.50){
                studentsGrades.put(entry.getKey(),grade);
            }
        }

        studentsGrades.entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue())).forEach(student ->{
            System.out.println(String.format("%s -> %.2f",student.getKey(),student.getValue()));
        });
    }
}

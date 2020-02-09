package telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> URLS;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.URLS = urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String URL : URLS) {
            boolean isValidURL = validateURL(URL);

            if (isValidURL) {
                stringBuilder.append("Browsing: ")
                        .append(URL)
                        .append("!")
                        .append(System.lineSeparator());
            }else {
                stringBuilder.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String number : this.numbers) {
            boolean isValidNumber = validatePhoneNumber(number);

            if (isValidNumber) {
                stringBuilder.append("Calling... ")
                        .append(number)
                        .append(System.lineSeparator());
            }else {
                stringBuilder.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim();
    }

    private boolean validatePhoneNumber(String number) {
        for (char symbol : number.toCharArray()) {
            if (!Character.isDigit(symbol)) {
                return false;
            }
        }
        return true;
    }
    private boolean validateURL(String URL) {
        for (char symbol : URL.toCharArray()) {
            if (Character.isDigit(symbol)) {
                return false;
            }
        }
        return true;


    }
}

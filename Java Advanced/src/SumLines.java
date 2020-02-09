import java.io.*;

public class SumLines {
    public static void main(String[] args) {

        String dir = System.getProperty("user.dir") + "\\resources\\input.txt";

        try {
            File file  = new File("MYoutput.txt");

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            BufferedReader reader = new BufferedReader(new FileReader(dir));

            String line = reader.readLine();
            while (line != null) {
                String upper = line.toUpperCase();
                writer.write(upper);
                writer.newLine();

                line = reader.readLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

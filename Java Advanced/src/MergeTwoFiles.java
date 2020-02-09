import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeTwoFiles {
    public static void main(String[] args) {

        String dir = System.getProperty("user.dir");
        String pathOne = dir + "\\resources\\Exercises Resources";

        try {
            File file = new File(pathOne);

            File[] files = file.listFiles();
            int size = 0;
            for (File f : files) {
                size += f.length();
            }
            PrintWriter writer = new PrintWriter("FileSize.txt");
            writer.write(String.format("Folder size: %d", size));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

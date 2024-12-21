import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelperFunctions {
    public static List<String> GetInputAsArrayOfLines(String path) {
        List<String> list = new ArrayList<>();

        try {
            File file = new File("DayFourInput");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

        return list;
    }
}

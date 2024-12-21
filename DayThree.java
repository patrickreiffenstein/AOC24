import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThree {
    public static void FunctionOne() throws FileNotFoundException {
        File file = new File("DayThreeInput");
        Scanner scanner = new Scanner(file);

        List<String> list = new ArrayList<>();

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        scanner.close();
        int sum = 0;

        // Everything is now in a string list
        String regex = "mul\\(+(\\d{1,3})\\,(\\d{1,3})\\)";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < list.size(); i++) {
            Matcher matcher = pattern.matcher(list.toArray()[i].toString());
            while (matcher.find()) {
                int result = Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
                sum += result;
                // System.out.println(Integer.parseInt(matcher.group(1)) + " and " +
                // Integer.parseInt(matcher.group(2)));
            }
        }

        System.out.println(sum);
    }

    public static void FunctionTwo() throws FileNotFoundException {
        File file = new File("DayThreeInput");
        Scanner scanner = new Scanner(file);

        List<String> list = new ArrayList<>();

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        scanner.close();
        int sum = 0;

        List<String> newList = new ArrayList<>();

        // Everything is now in a string list
        for (int i = 0; i < list.size(); i++) {
            newList.add(list.toArray()[i].toString().replaceAll("don't\\(\\).*?(do\\(\\)|\n)", ""));
            System.out.println(
                    "Removed: " + (list.toArray()[i].toString().length() - newList.toArray()[i].toString().length()));
        }

        Pattern pattern = Pattern.compile("mul\\(+(\\d{1,3})\\,(\\d{1,3})\\)");
        for (int i = 0; i < newList.size(); i++) {
            Matcher matcher = pattern.matcher(newList.toArray()[i].toString());
            while (matcher.find()) {
                int result = Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
                sum += result;
            }
        }

        System.out.println(sum);
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DayTwo {
    public static void DayTwoFunction() throws FileNotFoundException {
        File file = new File("DayTwoInput");
        Scanner scanner = new Scanner(file);
        Integer count = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitLine = line.split(" ");
            
            Integer[] numbers = new Integer[splitLine.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(splitLine[i]);
            }

            boolean safe = true;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i + 1] - numbers[i] > 3) safe = false;
                if (numbers[i + 1] <= numbers[i]) safe = false;
            }
            if (safe) count++;
            
            safe = true;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] - numbers[i + 1] > 3) safe = false;
                if (numbers[i] <= numbers[i + 1]) safe = false;
            }
            if (safe) count++;
        }

        scanner.close();
        System.out.println(count);
    }

    public static void DayTwoFunctionTwo() throws FileNotFoundException {
        File file = new File("DayTwoInput");
        Scanner scanner = new Scanner(file);
        Integer totalCount = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitLine = line.split(" ");
            
            Integer[] numbers = new Integer[splitLine.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(splitLine[i]);
            }
            Integer count = 0;

            for (int j = 0; j < numbers.length; j++) {
                Integer[] newNumbers = new Integer[numbers.length - 1];
                Integer offset = 0;
                for (int i = 0; i < numbers.length; i++) {
                    if (i == j) {
                        offset++;
                        continue;
                    }
                    newNumbers[i - offset] = numbers[i];
                }

                boolean safe = true;
                for (int i = 0; i < newNumbers.length - 1; i++) {
                    if (newNumbers[i + 1] - newNumbers[i] > 3) safe = false;
                    if (newNumbers[i + 1] <= newNumbers[i]) safe = false;
                }
                if (safe) count++;
                
                safe = true;
                for (int i = 0; i < newNumbers.length - 1; i++) {
                    if (newNumbers[i] - newNumbers[i + 1] > 3) safe = false;
                    if (newNumbers[i] <= newNumbers[i + 1]) safe = false;
                }
                if (safe) count++;
            }
            if (count > 0) totalCount++;
        }

        scanner.close();
        System.out.println(totalCount);
    }
}

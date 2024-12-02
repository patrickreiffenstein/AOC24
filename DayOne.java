import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DayOne {
    public static void DayOneFunction() throws FileNotFoundException {
        File file = new File("DayOneInput");
        Scanner scanner = new Scanner(file);

        List<Integer> listOne = new ArrayList<>();    
        List<Integer> listTwo = new ArrayList<>();          

        while (scanner.hasNextLine()) {
            listOne.add(scanner.nextInt());
            listTwo.add(scanner.nextInt());
        }

        scanner.close();

        Collections.sort(listOne);
        Collections.sort(listTwo);
        
        Integer[] finalOne = listOne.toArray(new Integer[0]);
        Integer[] finalTwo = listTwo.toArray(new Integer[0]);
        

        Integer sum = 0;

        for (int i = 0; i < listOne.size(); i++) {
            sum += Math.abs(finalOne[i] - finalTwo[i]);
        }

        System.out.println(sum);
    }
    
    public static void DayOneFunctionTwo() throws FileNotFoundException {
        File file = new File("DayOneInput");
        Scanner scanner = new Scanner(file);

        List<Integer> listOne = new ArrayList<>();    
        List<Integer> listTwo = new ArrayList<>();          

        while (scanner.hasNextLine()) {
            listOne.add(scanner.nextInt());
            listTwo.add(scanner.nextInt());
        }

        scanner.close();

        Collections.sort(listOne);
        Collections.sort(listTwo);
        
        Integer[] finalOne = listOne.toArray(new Integer[0]);
        Integer[] finalTwo = listTwo.toArray(new Integer[0]);
        
        Integer sum = 0;

        for (int i = 0; i < finalOne.length; i++) {
            Integer count = 0;

            for (int j = 0; j < finalTwo.length; j++) {
                if (finalTwo[j].equals(finalOne[i])) count++;
            }

            sum += finalOne[i] * count;
        }
      
        System.out.println(sum);
    }
}

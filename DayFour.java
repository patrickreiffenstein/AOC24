import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayFour {
    public static void FunctionOne() throws FileNotFoundException {
        File file = new File("DayFourInput");
        Scanner scanner = new Scanner(file);

        List<String> list = new ArrayList<>();

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        scanner.close();

        // Everything is read now
        char[][] characters = new char[list.toArray().length][list.toArray()[0].toString().length()];
        for (int i = 0; i < list.toArray().length; i++) {
            String string = list.toArray()[i].toString();
            for (int j = 0; j < string.length(); j++) {
                characters[i][j] = string.charAt(j);
                // System.out.print(string.charAt(j));
            }
            // System.out.print("\n");
        }

        int solves = 0;

        // Actually solve
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters.length; j++) {
                // This no work
                if (characters[i][j] != 'X') {
                    continue;
                }

                /*
                 * MAS
                 */
                if (i + 3 < characters.length) {
                    if (characters[i + 1][j] == 'M' && characters[i + 2][j] == 'A' && characters[i + 3][j] == 'S') {
                        solves++;
                    }
                }

                /*
                 * M
                 * _A
                 * __S
                 */
                if (i + 3 < characters.length && j + 3 < characters.length) {
                    if (characters[i + 1][j + 1] == 'M' && characters[i + 2][j + 2] == 'A'
                            && characters[i + 3][j + 3] == 'S') {
                        solves++;
                    }
                }

                /*
                 * M
                 * A
                 * S
                 */
                if (j + 3 < characters.length) {
                    if (characters[i][j + 1] == 'M' && characters[i][j + 2] == 'A' && characters[i][j + 3] == 'S') {
                        solves++;
                    }
                }

                /*
                 * __M
                 * _A
                 * S
                 */
                if (i - 3 >= 0 && j + 3 < characters.length) {
                    if (characters[i - 1][j + 1] == 'M' && characters[i - 2][j + 2] == 'A'
                            && characters[i - 3][j + 3] == 'S') {
                        solves++;
                    }
                }

                /*
                 * SAM
                 */
                if (i - 3 >= 0) {
                    if (characters[i - 1][j] == 'M' && characters[i - 2][j] == 'A' && characters[i - 3][j] == 'S') {
                        solves++;
                    }
                }

                /*
                 * S
                 * _A
                 * __M
                 */
                if (i - 3 >= 0 && j - 3 >= 0) {
                    if (characters[i - 1][j - 1] == 'M' && characters[i - 2][j - 2] == 'A'
                            && characters[i - 3][j - 3] == 'S') {
                        solves++;
                    }
                }

                /*
                 * S
                 * A
                 * M
                 */
                if (j - 3 >= 0) {
                    if (characters[i][j - 1] == 'M' && characters[i][j - 2] == 'A' && characters[i][j - 3] == 'S') {
                        solves++;
                    }
                }

                /*
                 * __S
                 * _A
                 * M
                 */
                if (j - 3 >= 0 && i + 3 < characters.length) {
                    if (characters[i + 1][j - 1] == 'M' && characters[i + 2][j - 2] == 'A'
                            && characters[i + 3][j - 3] == 'S') {
                        solves++;
                    }
                }
            }
        }

        System.out.println(solves);
    }

    public static void FunctionTwo() throws FileNotFoundException {
        File file = new File("DayFourInput");
        Scanner scanner = new Scanner(file);

        List<String> list = new ArrayList<>();

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }

        scanner.close();

        // Everything is read now
        char[][] characters = new char[list.toArray().length][list.toArray()[0].toString().length()];
        for (int i = 0; i < list.toArray().length; i++) {
            String string = list.toArray()[i].toString();
            for (int j = 0; j < string.length(); j++) {
                characters[i][j] = string.charAt(j);
                // System.out.print(string.charAt(j));
            }
            // System.out.print("\n");
        }

        int solves = 0;

        // Actually solve
        for (int i = 1; i < characters.length - 1; i++) {
            for (int j = 1; j < characters.length - 1; j++) {
                // This no work
                if (characters[i][j] != 'A') {
                    continue;
                }

                /*
                 * M_M
                 * _A
                 * S_S
                 */
                if (characters[i - 1][j - 1] == 'M' &&
                        characters[i + 1][j - 1] == 'M' &&
                        characters[i - 1][j + 1] == 'S' &&
                        characters[i + 1][j + 1] == 'S') {
                    solves++;
                }

                /*
                 * S_M
                 * _A
                 * S_M
                 */
                if (characters[i - 1][j - 1] == 'S' &&
                        characters[i + 1][j - 1] == 'M' &&
                        characters[i - 1][j + 1] == 'S' &&
                        characters[i + 1][j + 1] == 'M') {
                    solves++;
                }

                /*
                 * S_S
                 * _A
                 * M_M
                 */
                if (characters[i - 1][j - 1] == 'S' &&
                        characters[i + 1][j - 1] == 'S' &&
                        characters[i - 1][j + 1] == 'M' &&
                        characters[i + 1][j + 1] == 'M') {
                    solves++;
                }

                /*
                 * M_S
                 * _A
                 * M_S
                 */
                if (characters[i - 1][j - 1] == 'M' &&
                        characters[i + 1][j - 1] == 'S' &&
                        characters[i - 1][j + 1] == 'M' &&
                        characters[i + 1][j + 1] == 'S') {
                    solves++;
                }
            }
        }

        System.out.println(solves);
    }
}

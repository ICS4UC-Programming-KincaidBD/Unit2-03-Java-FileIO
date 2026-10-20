import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

/* 
 * This program will open a file, read its contents, split each line into the numbers,
 * if there is a word, it will display the correct error in the output file. but for the numbers, each line it will print the sum
 * @author Kincaid
 * @version 1.0
 * @since 2026/10/19
 */

public class FileIO {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "/home/vscode/ICS4UC/Unit2/Unit2-03/Unit2-03-Java-FileIO/input.txt";
        String outputFilePath = "/home/vscode/ICS4UC/Unit2/Unit2-03/Unit2-03-Java-FileIO/output.txt";

        // initialize the file and scanner objects
        File inputFile = new File(inputFilePath);
        Scanner scanner = new Scanner(inputFile);
        FileWriter writer = new FileWriter(outputFilePath);

        // while the file has more lines
        while (scanner.hasNextLine()) {
            // variables n  flags
            String line = scanner.nextLine();
            

            String[] components = line.split("\\s+");
            int sum = 0;
            String ErrorWord = null;
            boolean flag = false;
            // skip empty lines
            if (line.length() == 0) {
                flag = true;
                ErrorWord = "empty line";
                continue;
            }
            if (flag == false) {
                for (String component : components) {
                    try {
                        sum += Integer.parseInt(component);
                    } catch (NumberFormatException e) {
                        flag = true;
                        ErrorWord = component;
                        break;
                    }
                }
            }
            
            if (flag) {
                if (ErrorWord.equals("empty line")) {
                    writer.write("Error: " + ErrorWord + "\n");
                } else {
                    writer.write("Error: " + ErrorWord + " is not a number\n");
                }
            } else {
                writer.write(sum + "\n");
            }
        }
        writer.close();
        scanner.close();
    }
}
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Average each row of ten test scores
 */
public class ScannerReadCSVFile
{
    public void run() throws FileNotFoundException {
        // Mr. Jaffe's code to read data from a file
        // Instantiate a File object
        File dataFile = new File("TestScoresByClass.csv");

        // Instantiate a Scanner object that uses the file
        Scanner scanner = new Scanner(dataFile);

        // Set the delimiter as a new-line character so we can read the
        // data one line at a time
        scanner.useDelimiter("\n");
        int i = 1;
        // Continue while there's still data in the file to be read
        while (scanner.hasNext()) {
            // Read the next line of the file
            String line = scanner.nextLine();

            if (i != 1) {
                Scanner scan = new Scanner(line).useDelimiter(",|\n");
                int grade = 0;
                int Class = 0;
                int average = 0;
                boolean SetClass = false;
                while (scan.hasNextInt()) {
                    if (SetClass == false) {
                        Class = scan.nextInt();
                        SetClass = true;
                    } else {
                        average += scan.nextInt();
                        grade++;
                    }
                }
                System.out.println(Class + ": " + average / grade);
            }
            i++;
            
        }
    }

    public static void main (String[] args) {
        try {
            ScannerReadCSVFile srCsv = new ScannerReadCSVFile();
            srCsv.run();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("There's an error someplace. Try using the debugger to find it!");

        }
    }
}

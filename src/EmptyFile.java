import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Empty file class
class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}

public class Main {

    // Method to read file and throw exception if empty
    public static void readFile(String fileName) throws EmptyFileException {
        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);

            if (!scanner.hasNextLine()) {
                throw new EmptyFileException("The File is empty.");
            }

            // Read file contents
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (EmptyFileException e) {
            throw e; // Re-throw custom exception
        }
    }

    public static void main(String[] args) {
        String fileName = "example.txt"; // Change this to the path of your file

        try {
            readFile(fileName);
        } catch (EmptyFileException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
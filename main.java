import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Hello solution = new Hello();
        File file = new File("input.txt");
        try (Scanner InputText = new Scanner(file)) {
            String inputWord = InputText.nextLine();
            int line = 1;
            while (InputText.hasNextLine()) {
                line++; 
                String inputtext = InputText.nextLine();
                System.out.println("the word " + inputWord + " can be found " + solution.solution(inputtext, inputWord) + " times in the string at line "+line);
                try {
                    FileWriter myWriter = new FileWriter("output.txt");
                    myWriter.write("the word " + inputWord + " can be found " + solution.solution(inputtext, inputWord) + " times in the string at line "+line);
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        }
    }
}
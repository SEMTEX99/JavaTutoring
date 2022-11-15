import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Hello solution = new Hello();
        File file = new File("input.txt");
        try (Scanner InputText = new Scanner(file)) {
            String inputWord = InputText.nextLine();
            int line = 1;
            PrintWriter writer = new PrintWriter("output.txt");
            while (InputText.hasNextLine()) {
                line++;
                String inputtext = InputText.nextLine();
                assert inputtext.length() > 0;
                writer.println("the word " + inputWord + " can be found " + solution.solution(inputtext, inputWord) + " times in the string at line " + line);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("Oops Something went wrong :(");
        } finally {
            System.out.println("Program complete");
        }
    }
}
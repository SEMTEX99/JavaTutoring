import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class main {
    public static void main(String[] args) throws FileNotFoundException, InvalidCharacterException {
        Hello solution = new Hello();
        File file = new File("input.txt");
        try (Scanner InputText = new Scanner(file); PrintWriter writer = new PrintWriter("output.txt")) {
            String inputWord = InputText.nextLine();
            int line = 1;
            while (InputText.hasNextLine()) {
                line++;
                String inputtext = InputText.nextLine();
                assert inputtext.length() > 0;
                writer.println("the word " + inputWord + " can be found " + solution.solution(inputtext, inputWord) + " times in the string at line " + line);
                if (inputtext.matches("[^a-zA-Z]+")) {
                    throw new InvalidCharacterException("Only alphabet characters are accepted");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (InvalidCharacterException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Oops Something went wrong :(");
        } finally {
            System.out.println("Program complete");
        }
    }
}
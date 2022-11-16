package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import com.example.ExceptionHandling.InvalidCharacterException;

public class App {
    public static void main(String[] args) throws FileNotFoundException, InvalidCharacterException, SecurityException, NoSuchElementException {
        Algorythm solution = new Algorythm();
        File file = new File("demo\\src\\Resources\\input.txt");
        try (Scanner InputText = new Scanner(file); PrintWriter writer = new PrintWriter("demo\\src\\Resources\\output.txt")) {
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
        } catch (NoSuchElementException e) {
            System.out.println("File has only 1 or 0 lines!");
        } catch (Exception e) {
            System.out.println("Oops Something went wrong :(");
        } finally {
            System.out.println("Program complete");
        }
    }
}
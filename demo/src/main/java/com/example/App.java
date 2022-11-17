package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import com.example.ExceptionHandling.InvalidCharacterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) throws FileNotFoundException, InvalidCharacterException, SecurityException, NoSuchElementException {
        log.info("Starting the execution of the program ");
        Algorythm solution = new Algorythm();
        log.info("Inputting file");
        File file = new File("demo\\src\\Resources\\input.txt");
        log.info("reading file");
        try (Scanner InputText = new Scanner(file); PrintWriter writer = new PrintWriter("demo\\src\\Resources\\output.txt")) {
            String inputWord = InputText.nextLine();
            int line = 1;
            while (InputText.hasNextLine()) {
                line++;
                log.info("reading file at line "+ line);
                String inputtext = InputText.nextLine();
                log.info("Ithe input text at line "+ line +" is: " + inputtext);
                assert inputtext.length() > 0;
                writer.println("the word " + inputWord + " can be found " + solution.solution(inputtext, inputWord) + " times in the string at line " + line);
                log.info("writing to output file");
                if (inputtext.matches("[^a-zA-Z]+")) {
                    throw new InvalidCharacterException("Only alphabet characters are accepted");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            log.info("File not found");
        } catch (InvalidCharacterException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("File has only 1 or 0 lines!");
            log.info("File has only 1 or 0 lines!");
        } catch (Exception e) {
            System.out.println("Oops Something went wrong :(");
            log.info("Whatever you did it did not end well, the computer got angry at you, YOU BROKE HIM YOU MONSTER!");
        } finally {
            System.out.println("Program complete");
            log.info("program complete");
        }
    }
}
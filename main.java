import java.util.Scanner;
public class main {
    public static void main(String[] args){
        Hello solution = new Hello();
        Scanner InputText = new Scanner(System.in);
        System.out.println("Enter a string");
        String inputtext = InputText.nextLine();
        Scanner InputWord = new Scanner(System.in);
        System.out.println("Enter a word");
        String inputWord = InputWord.nextLine();
        System.out.println("the word "+ inputWord + "can be found "+ solution.solution(inputtext, inputWord)+ " times in the string you inputed");
    }
    
}

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Hello solution = new Hello();
        Scanner InputText = new Scanner(System.in);
        System.out.println("Enter a string");
        String inputtext = InputText.nextLine();
        System.out.println(solution.solution(inputtext));
    }
    
}

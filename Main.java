import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {
        
        InfixBalancer tokenizer = new InfixBalancer();

        try {
            tokenizer.tokenize(new File("input.txt"));

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println(tokenizer.toString());
    
    }
}
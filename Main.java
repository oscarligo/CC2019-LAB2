import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File file = new File(args.length > 0 ? args[0] : "input.txt");
        InfixBalancer balancer = new InfixBalancer();

        try {
            balancer.tokenize(file);
        } catch (IOException e) {
            System.err.println("Error reading " + file + ": " + e.getMessage());
            return;
        }

        System.out.println("File: " + file);
        for (int i = 0; i < balancer.getTokens().size(); i++) {
            ArrayList<String> expression = balancer.getTokens().get(i);
            System.out.printf("%nExpression %d: %s%n", i + 1, String.join("", expression));
            System.out.println("Stack (base -> top):");
            boolean balanced = balancer.isBalanced(expression);
            System.out.println("Result: " + (balanced ? "well-formed" : "not well-formed"));
        }
    }
}

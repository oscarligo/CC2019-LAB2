import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InfixBalancer {

    private ArrayList<ArrayList<String>> tokens;

    public InfixBalancer() {
        this.tokens = new ArrayList<>();
    }

    public void tokenize(File file) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
            ArrayList<String> lineTokens = new ArrayList<>();
            for (char c : line.toCharArray()) {
                if (!Character.isWhitespace(c)) {
                    lineTokens.add(Character.toString(c));
                }
            }
            if (!lineTokens.isEmpty()) {
                tokens.add(lineTokens);
            }
        }
    } catch (IOException e) {
        throw e;
    }
}



    public ArrayList<ArrayList<String>> getTokens() {
        return tokens;
    }

    


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokens.size(); i++) {
            sb.append(i + 1).append(") ").append(tokens.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
    



}

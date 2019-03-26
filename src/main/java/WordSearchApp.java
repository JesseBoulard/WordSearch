import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WordSearchApp {
    private String filePath;
    private WordSearch wordSearch;

    private WordSearchApp() throws IOException {
        promptUserForFilePath();
        parseUserInput();
    }

    public static void main(String[] args) throws IOException {
        new WordSearchApp();
    }

    private void promptUserForFilePath() {
        System.out.println("Please enter the absolute path to a file you would like to perform a word search on.");
        System.out.println("To quit enter: q");
        setFilePath();
    }

    private void parseUserInput() throws IOException {
        if (!filePath.toLowerCase().equals("q")) {
            wordSearch = new WordSearch(filePath);
            performWordSearch();
        } else {
            System.out.println("Goodbye");
        }
    }

    private void performWordSearch() throws IOException {
        System.out.println(wordSearch.searchWords());
        new WordSearchApp();
    }

    private void setFilePath() {
        Scanner scnr = new Scanner(System.in);
        try {
            filePath = scnr.next();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Invalid input!");
            promptUserForFilePath();
        }
    }
}

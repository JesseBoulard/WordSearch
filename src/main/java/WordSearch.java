import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class WordSearch {

    private String filePath;

    WordSearch(String filePath) {
        this.filePath = filePath;
    }

    List<String> getLinesFromFile() throws IOException {
        List<String> fileLines = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            fileLines.add(line);
        }
        return fileLines;
    }

    String[][] parseLinesIntoStringArray() {
        String[][] stringArray = new String[2][2];
        stringArray[0][0] = "U";
        stringArray[1][1] = "B";
        return stringArray;
    }
}

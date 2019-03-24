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

    String[][] parseLinesIntoStringArray() throws IOException {
        List<String> linesFromFile = getLinesFromFile();
        linesFromFile.remove(0);

        String[][] stringArray = new String[linesFromFile.size()][linesFromFile.size()];
        for (int x = 0; x < linesFromFile.size(); x++) {
            String[] strings = getStringsFromLine(linesFromFile.get(x));
            System.arraycopy(strings, 0, stringArray[x], 0, strings.length);
        }
        return stringArray;
    }

    private String[] getStringsFromLine(String line) {
        return line.split(",");
    }

    List<GridItem> parseStringArrayIntoGridItems() {
        List<GridItem> gridItems = new ArrayList<>();
        gridItems.add(new GridItem("U"));
        gridItems.add(new GridItem("B"));
        return gridItems;
    }
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class WordSearch {

    private String filePath;
    private String[][] stringArray;
    private List<GridItem> gridItems;

    WordSearch(String filePath) throws IOException {
        this.filePath = filePath;
        this.stringArray = parseLinesIntoStringArray();
        this.gridItems = parseStringArrayIntoGridItems();
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
        for (int x = 0; x < stringArray.length; x++) {
            for (int y = 0; y < stringArray[0].length; y++) {
                GridItem gridItem = new GridItem(stringArray[y][x], x, y);
                gridItems.add(gridItem);
            }
        }
        return gridItems;
    }

    GridItem getGridItemForCoordinates(int xCoordinate, int yCoordinate) {
        return gridItems.get((xCoordinate * stringArray.length) + yCoordinate);
    }

    List<GridItem> getGridItemsForLetter(String letter) {
        List<GridItem> gridItems = new ArrayList<>();
        gridItems.add(new GridItem("V", 0, 0));
        return gridItems;
    }
}

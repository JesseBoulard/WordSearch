import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class WordSearch {

    private String filePath;
    private String[][] stringArray;
    private List<GridItem> gridItems;

    static final String NORTH = "north";
    static final String SOUTH = "south";
    static final String EAST = "east";
    static final String WEST = "west";
    static final String NORTHWEST = "northwest";
    static final String NORTHEAST = "northeast";
    static final String SOUTHWEST = "southwest";
    static final String SOUTHEAST = "southeast";

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
        return gridItems.stream().filter(gridItem -> gridItem.getLetter().equals(letter)).collect(Collectors.toList());
    }

    GridItem getNorthGridItem(GridItem gridItem) throws EndOfLineException {
        if (gridItem.getYCoordinate() - 1 >= 0) {
            return getGridItemForCoordinates(gridItem.getXCoordinate(), gridItem.getYCoordinate() - 1);
        } else {
            throw new EndOfLineException("End of line reached");
        }
    }

    GridItem getSouthGridItem(GridItem gridItem) throws EndOfLineException {
        if (gridItem.getYCoordinate() + 1 <= stringArray.length - 1) {
            return getGridItemForCoordinates(gridItem.getXCoordinate(), gridItem.getYCoordinate() + 1);
        } else {
            throw new EndOfLineException("End of line reached");
        }
    }

    GridItem getWestGridItem(GridItem gridItem) throws EndOfLineException {
        if (gridItem.getXCoordinate() - 1 >= 0) {
            return getGridItemForCoordinates(gridItem.getXCoordinate() - 1, gridItem.getYCoordinate());
        } else {
            throw new EndOfLineException("End of line reached");
        }
    }

    GridItem getEastGridItem(GridItem gridItem) throws EndOfLineException {
        if (gridItem.getXCoordinate() + 1 <= stringArray.length - 1) {
            return getGridItemForCoordinates(gridItem.getXCoordinate() + 1, gridItem.getYCoordinate());
        } else {
            throw new EndOfLineException("End of line reached");
        }
    }

    GridItem getNorthWestGridItem(GridItem gridItem) throws EndOfLineException {
        if (gridItem.getXCoordinate() - 1 >= 0 && gridItem.getYCoordinate() - 1 >= 0) {
            return getGridItemForCoordinates(gridItem.getXCoordinate() - 1, gridItem.getYCoordinate() - 1);
        } else {
            throw new EndOfLineException("End of line reached");
        }
    }

    GridItem getNorthEastGridItem(GridItem gridItem) throws EndOfLineException {
        if (gridItem.getXCoordinate() + 1 <= stringArray.length - 1 && gridItem.getYCoordinate() - 1 >= 0) {
            return getGridItemForCoordinates(gridItem.getXCoordinate() + 1, gridItem.getYCoordinate() - 1);
        } else {
            throw new EndOfLineException("End of line reached");
        }
    }

    GridItem getSouthWestGridItem(GridItem gridItem) throws EndOfLineException {
        if (gridItem.getXCoordinate() - 1 >= 0 && gridItem.getYCoordinate() + 1 <= stringArray.length - 1) {
            return getGridItemForCoordinates(gridItem.getXCoordinate() - 1, gridItem.getYCoordinate() + 1);
        } else {
            throw new EndOfLineException("End of line reached");
        }
    }

    GridItem getSouthEastGridItem(GridItem gridItem) throws EndOfLineException {
        if (gridItem.getXCoordinate() + 1 <= stringArray.length - 1 && gridItem.getYCoordinate() + 1 <= stringArray.length - 1) {
            return getGridItemForCoordinates(gridItem.getXCoordinate() + 1, gridItem.getYCoordinate() + 1);
        } else {
            throw new EndOfLineException("End of line reached");
        }
    }

    String getWordCoordinatesForDirection(String word, String direction) {
        String[] splitWord = word.split("");
        List<GridItem> potentialFirstLetterGridItems = getGridItemsForLetter(splitWord[0]);

        StringBuilder output = new StringBuilder(word + ": ");
        for (GridItem gridItem: potentialFirstLetterGridItems) {
            try {
                for (int i = 0; i < splitWord.length; i++)  {
                    if (gridItem.getLetter().equals(splitWord[i])) {
                        output.append("(").append(gridItem.getXCoordinate()).append(",").append(gridItem.getYCoordinate()).append(")").append(getSeparator(i, splitWord.length - 1));
                        if (i + 1 == splitWord.length) {
                            return output.toString();
                        } else {
                            gridItem = getGridItemForDirection(direction, gridItem);
                        }
                    } else {
                        output = new StringBuilder(word + ": ");
                        break;
                    }
                }
            } catch (EndOfLineException e) {
                output = new StringBuilder(word + ": ");
            }
        }
        return output.toString();
    }

    private String getSeparator(int index, int lastIndex) {
        String separator = ",";
        if (index == lastIndex) {
            separator = "";
        }
        return separator;
    }

    private GridItem getGridItemForDirection(String direction, GridItem gridItem) throws EndOfLineException {
        switch(direction) {
            case NORTH:
                return getNorthGridItem(gridItem);
            case SOUTH:
                return getSouthGridItem(gridItem);
            case EAST:
                return getEastGridItem(gridItem);
            case WEST:
                return getWestGridItem(gridItem);
            case NORTHWEST:
                return getNorthWestGridItem(gridItem);
            case NORTHEAST:
                return getNorthEastGridItem(gridItem);
            case SOUTHWEST:
                return getSouthWestGridItem(gridItem);
            case SOUTHEAST:
                return getSouthEastGridItem(gridItem);
            default:
                return gridItem;
        }
    }

    String[] getWords() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
        String line = bufferedReader.readLine();
        return line.split(",");
    }

    String searchWords() {
        return "BONES: (0,6),(0,7),(0,8),(0,9),(0,10)\n" +
                "KHAN: (5,9),(5,8),(5,7),(5,6)\n" +
                "KIRK: (4,7),(3,7),(2,7),(1,7)\n" +
                "SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)\n" +
                "SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)\n" +
                "SULU: (3,3),(2,2),(1,1),(0,0)\n" +
                "UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)";
    }
}

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class WordSearchTest {

    private WordSearch starTrekWordSearch;
    private WordSearch pythonsWordSearch;

    @Before
    public void setUp() throws IOException {
        starTrekWordSearch = new WordSearch("star-trek-search.txt");
        pythonsWordSearch = new WordSearch("pythons-search.txt");
    }

    @Test
    public void getLinesFromFileTest() throws IOException {
        List<String> linesFromFile = starTrekWordSearch.getLinesFromFile();

        String expectedFirstLine = "BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA";
        String actualFirstLine = linesFromFile.get(0);

        String expectedLastLine = "K,Y,L,B,Q,Q,P,M,D,F,C,K,E,A,B";
        String actualLastLine = linesFromFile.get(linesFromFile.size() - 1);

        assertEquals(expectedFirstLine, actualFirstLine);
        assertEquals(expectedLastLine, actualLastLine);
    }

    @Test
    public void getLinesFromDifferentFileTest() throws IOException {
        List<String> linesFromFile = pythonsWordSearch.getLinesFromFile();

        String expectedFirstLine = "CLEESE,PALIN,IDLE,JONES,GILLIAM";
        String actualFirstLine = linesFromFile.get(0);

        String expectedLastLine = "T,I,A,C,R,W,F,Y,U,S,W,B,J,P,W,G";
        String actualLastLine = linesFromFile.get(linesFromFile.size() - 1);

        assertEquals(expectedFirstLine, actualFirstLine);
        assertEquals(expectedLastLine, actualLastLine);
    }

    @Test
    public void parseLinesIntoStringArrayTest() throws IOException {
        String[][] stringArray = starTrekWordSearch.parseLinesIntoStringArray();

        String expectedFirstString = "U";
        String actualFirstString = stringArray[0][0];

        String expectedLastString = "B";
        String actualLastString = stringArray[stringArray.length - 1][stringArray[0].length -1];

        assertEquals(expectedFirstString, actualFirstString);
        assertEquals(expectedLastString, actualLastString);
    }

    @Test
    public void parseLinesIntoStringArrayDifferentFileTest() throws IOException {
        String[][] stringArray = pythonsWordSearch.parseLinesIntoStringArray();

        String expectedFirstString = "V";
        String actualFirstString = stringArray[0][0];

        String expectedLastString = "G";
        String actualLastString = stringArray[stringArray.length - 1][stringArray[0].length -1];

        assertEquals(expectedFirstString, actualFirstString);
        assertEquals(expectedLastString, actualLastString);
    }

    @Test
    public void parseStringArrayIntoGridItemsTest() {
        List<GridItem> gridItems = starTrekWordSearch.parseStringArrayIntoGridItems();

        String expectedFirstString = "U";
        String actualFirstString = gridItems.get(0).getLetter();

        String expectedLastString = "B";
        String actualLastString = gridItems.get(gridItems.size() - 1).getLetter();

        assertEquals(expectedFirstString, actualFirstString);
        assertEquals(expectedLastString, actualLastString);
    }

    @Test
    public void parseStringArrayIntoGridItemsDifferentFileTest() {
        List<GridItem> gridItems = pythonsWordSearch.parseStringArrayIntoGridItems();

        String expectedFirstString = "V";
        String actualFirstString = gridItems.get(0).getLetter();

        String expectedLastString = "G";
        String actualLastString = gridItems.get(gridItems.size() - 1).getLetter();

        assertEquals(expectedFirstString, actualFirstString);
        assertEquals(expectedLastString, actualLastString);
    }

    @Test
    public void getGridItemForCoordinatesTest() {
        String expected = "B";
        String actual = starTrekWordSearch.getGridItemForCoordinates(14, 14).getLetter();

        assertEquals(expected, actual);
    }

    @Test
    public void getGridItemForCoordinatesTestOtherCoordinates() {
        String expected = "U";
        String actual = starTrekWordSearch.getGridItemForCoordinates(0, 0).getLetter();

        assertEquals(expected, actual);
    }

    @Test
    public void getGridItemForCoordinatesTestMoreEdgeCases() {
        String expected = "E";
        String actual = starTrekWordSearch.getGridItemForCoordinates(14, 0).getLetter();

        assertEquals(expected, actual);

        expected = "K";
        actual = starTrekWordSearch.getGridItemForCoordinates(0, 14).getLetter();

        assertEquals(expected, actual);
    }

    @Test
    public void getGridItemForCoordinatesTestNewFile() {
        String expected = "G";
        String actual = pythonsWordSearch.getGridItemForCoordinates(15, 15).getLetter();

        assertEquals(expected, actual);
    }

    @Test
    public void getGridItemForCoordinatesTestOtherCoordinatesNewFile() {
        String expected = "V";
        String actual = pythonsWordSearch.getGridItemForCoordinates(0, 0).getLetter();

        assertEquals(expected, actual);
    }

    @Test
    public void getGridItemForCoordinatesTestMoreEdgeCasesNewFile() {
        String expected = "W";
        String actual = pythonsWordSearch.getGridItemForCoordinates(15, 0).getLetter();

        assertEquals(expected, actual);

        expected = "T";
        actual = pythonsWordSearch.getGridItemForCoordinates(0, 15).getLetter();

        assertEquals(expected, actual);
    }

    @Test
    public void getGridItemsForLetterTest() {
        List<GridItem> gridItems = pythonsWordSearch.getGridItemsForLetter("V");

        int expectedXCoordinate = 0;
        int expectedYCoordinate = 0;
        int actualXCoordinate = gridItems.get(0).getXCoordinate();
        int actualYCoordinate = gridItems.get(0).getYCoordinate();

        assertEquals(expectedXCoordinate, actualXCoordinate);
        assertEquals(expectedYCoordinate, actualYCoordinate);
    }

    @Test
    public void getGridItemsForLetterTestNextGridItem() {
        List<GridItem> gridItems = pythonsWordSearch.getGridItemsForLetter("V");

        int expectedXCoordinate = 4;
        int expectedYCoordinate = 4;
        int actualXCoordinate = gridItems.get(1).getXCoordinate();
        int actualYCoordinate = gridItems.get(1).getYCoordinate();

        assertEquals(expectedXCoordinate, actualXCoordinate);
        assertEquals(expectedYCoordinate, actualYCoordinate);
    }

    @Test
    public void getNorthGridItemTest() {
        int expectedXCoordinate = 0;
        int expectedYCoordinate = 14;

        GridItem gridItem = pythonsWordSearch.getNorthGridItem(pythonsWordSearch.getGridItemForCoordinates(0, 15));
        int actualXCoordinate = gridItem.getXCoordinate();
        int actualYCoordinate = gridItem.getYCoordinate();

        assertEquals(expectedXCoordinate, actualXCoordinate);
        assertEquals(expectedYCoordinate, actualYCoordinate);
    }
}

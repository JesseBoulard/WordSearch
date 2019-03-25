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
    public void getNorthGridItemTest() throws EndOfLineException {
        int expectedXCoordinate = 0;
        int expectedYCoordinate = 14;

        GridItem gridItem = pythonsWordSearch.getNorthGridItem(pythonsWordSearch.getGridItemForCoordinates(0, 15));
        int actualXCoordinate = gridItem.getXCoordinate();
        int actualYCoordinate = gridItem.getYCoordinate();

        assertEquals(expectedXCoordinate, actualXCoordinate);
        assertEquals(expectedYCoordinate, actualYCoordinate);
    }

    @Test
    public void getNorthGridItemDifferentCoordinatesTest() throws EndOfLineException {
        int expectedXCoordinate = 5;
        int expectedYCoordinate = 4;

        GridItem gridItem = pythonsWordSearch.getNorthGridItem(pythonsWordSearch.getGridItemForCoordinates(5, 5));
        int actualXCoordinate = gridItem.getXCoordinate();
        int actualYCoordinate = gridItem.getYCoordinate();

        assertEquals(expectedXCoordinate, actualXCoordinate);
        assertEquals(expectedYCoordinate, actualYCoordinate);
    }

    @Test
    public void getNorthGridItemEdgeCaseTest() {
        boolean hasError = false;
        try {
            pythonsWordSearch.getNorthGridItem(pythonsWordSearch.getGridItemForCoordinates(5, 0));
        } catch (EndOfLineException e) {
            hasError = true;
        }

        assertTrue(hasError);
    }

    @Test
    public void getSouthGridItemTest() throws EndOfLineException {
        int expectedXCoordinate = 4;
        int expectedYCoordinate = 5;

        GridItem gridItem = pythonsWordSearch.getSouthGridItem(pythonsWordSearch.getGridItemForCoordinates(4, 4));
        int actualXCoordinate = gridItem.getXCoordinate();
        int actualYCoordinate = gridItem.getYCoordinate();

        assertEquals(expectedXCoordinate, actualXCoordinate);
        assertEquals(expectedYCoordinate, actualYCoordinate);
    }

    @Test
    public void getSouthGridItemEdgeCaseTest() {
        boolean hasError = false;
        try {
            pythonsWordSearch.getSouthGridItem(pythonsWordSearch.getGridItemForCoordinates(5, 15));
        } catch (EndOfLineException e) {
            hasError = true;
        }

        assertTrue(hasError);
    }

    @Test
    public void getWestGridItemTest() throws EndOfLineException {
        int expectedXCoordinate = 4;
        int expectedYCoordinate = 5;

        GridItem gridItem = pythonsWordSearch.getWestGridItem(pythonsWordSearch.getGridItemForCoordinates(5, 5));
        int actualXCoordinate = gridItem.getXCoordinate();
        int actualYCoordinate = gridItem.getYCoordinate();

        assertEquals(expectedXCoordinate, actualXCoordinate);
        assertEquals(expectedYCoordinate, actualYCoordinate);
    }

    @Test
    public void getWestGridItemEdgeCaseTest() {
        boolean hasError = false;
        try {
            pythonsWordSearch.getWestGridItem(pythonsWordSearch.getGridItemForCoordinates(0, 5));
        } catch (EndOfLineException e) {
            hasError = true;
        }

        assertTrue(hasError);
    }

    @Test
    public void getEastGridItemTest() throws EndOfLineException {
        int expectedXCoordinate = 6;
        int expectedYCoordinate = 5;

        GridItem gridItem = pythonsWordSearch.getEastGridItem(pythonsWordSearch.getGridItemForCoordinates(5, 5));
        int actualXCoordinate = gridItem.getXCoordinate();
        int actualYCoordinate = gridItem.getYCoordinate();

        assertEquals(expectedXCoordinate, actualXCoordinate);
        assertEquals(expectedYCoordinate, actualYCoordinate);
    }

    @Test
    public void getEastGridItemEdgeCaseTest() {
        boolean hasError = false;
        try {
            pythonsWordSearch.getEastGridItem(pythonsWordSearch.getGridItemForCoordinates(15, 5));
        } catch (EndOfLineException e) {
            hasError = true;
        }

        assertTrue(hasError);
    }

    @Test
    public void getNorthWestGridItemTest() throws EndOfLineException {
        int expectedXCoordinate = 4;
        int expectedYCoordinate = 4;

        GridItem gridItem = pythonsWordSearch.getNorthWestGridItem(pythonsWordSearch.getGridItemForCoordinates(5, 5));
        int actualXCoordinate = gridItem.getXCoordinate();
        int actualYCoordinate = gridItem.getYCoordinate();

        assertEquals(expectedXCoordinate, actualXCoordinate);
        assertEquals(expectedYCoordinate, actualYCoordinate);
    }

    @Test
    public void getNorthWestGridItemEdgeCaseTest() {
        boolean hasError = false;
        try {
            pythonsWordSearch.getNorthWestGridItem(pythonsWordSearch.getGridItemForCoordinates(0, 5));
        } catch (EndOfLineException e) {
            hasError = true;
        }

        assertTrue(hasError);
    }

    @Test
    public void getOtherNorthWestGridItemEdgeCaseTest() {
        boolean hasError = false;
        try {
            pythonsWordSearch.getNorthWestGridItem(pythonsWordSearch.getGridItemForCoordinates(1, 0));
        } catch (EndOfLineException e) {
            hasError = true;
        }

        assertTrue(hasError);
    }

    @Test
    public void getNorthEastGridItemTest() throws EndOfLineException {
        int expectedXCoordinate = 6;
        int expectedYCoordinate = 4;

        GridItem gridItem = pythonsWordSearch.getNorthEastGridItem(pythonsWordSearch.getGridItemForCoordinates(5, 5));
        int actualXCoordinate = gridItem.getXCoordinate();
        int actualYCoordinate = gridItem.getYCoordinate();

        assertEquals(expectedXCoordinate, actualXCoordinate);
        assertEquals(expectedYCoordinate, actualYCoordinate);
    }

    @Test
    public void getNorthEastGridItemEdgeCaseTest() {
        boolean hasError = false;
        try {
            pythonsWordSearch.getNorthEastGridItem(pythonsWordSearch.getGridItemForCoordinates(15, 5));
        } catch (EndOfLineException e) {
            hasError = true;
        }

        assertTrue(hasError);
    }

    @Test
    public void getOtherNorthEastGridItemEdgeCaseTest() {
        boolean hasError = false;
        try {
            pythonsWordSearch.getNorthEastGridItem(pythonsWordSearch.getGridItemForCoordinates(1, 0));
        } catch (EndOfLineException e) {
            hasError = true;
        }

        assertTrue(hasError);
    }

    @Test
    public void getSouthWestGridItemTest() throws EndOfLineException {
        int expectedXCoordinate = 4;
        int expectedYCoordinate = 6;

        GridItem gridItem = pythonsWordSearch.getSouthWestGridItem(pythonsWordSearch.getGridItemForCoordinates(5, 5));
        int actualXCoordinate = gridItem.getXCoordinate();
        int actualYCoordinate = gridItem.getYCoordinate();

        assertEquals(expectedXCoordinate, actualXCoordinate);
        assertEquals(expectedYCoordinate, actualYCoordinate);
    }

    @Test
    public void getSouthWestGridItemEdgeCaseTest() {
        boolean hasError = false;
        try {
            pythonsWordSearch.getSouthWestGridItem(pythonsWordSearch.getGridItemForCoordinates(0, 5));
        } catch (EndOfLineException e) {
            hasError = true;
        }

        assertTrue(hasError);
    }

    @Test
    public void getOtherSouthWestGridItemEdgeCaseTest() {
        boolean hasError = false;
        try {
            pythonsWordSearch.getSouthWestGridItem(pythonsWordSearch.getGridItemForCoordinates(1, 15));
        } catch (EndOfLineException e) {
            hasError = true;
        }

        assertTrue(hasError);
    }

    @Test
    public void getSouthEastGridItemTest() throws EndOfLineException {
        int expectedXCoordinate = 6;
        int expectedYCoordinate = 6;

        GridItem gridItem = pythonsWordSearch.getSouthEastGridItem(pythonsWordSearch.getGridItemForCoordinates(5, 5));
        int actualXCoordinate = gridItem.getXCoordinate();
        int actualYCoordinate = gridItem.getYCoordinate();

        assertEquals(expectedXCoordinate, actualXCoordinate);
        assertEquals(expectedYCoordinate, actualYCoordinate);
    }

    @Test
    public void getSouthEastGridItemEdgeCaseTest() {
        boolean hasError = false;
        try {
            pythonsWordSearch.getSouthEastGridItem(pythonsWordSearch.getGridItemForCoordinates(15, 5));
        } catch (EndOfLineException e) {
            hasError = true;
        }

        assertTrue(hasError);
    }

    @Test
    public void getOtherSouthEastGridItemEdgeCaseTest() {
        boolean hasError = false;
        try {
            pythonsWordSearch.getSouthEastGridItem(pythonsWordSearch.getGridItemForCoordinates(5, 15));
        } catch (EndOfLineException e) {
            hasError = true;
        }

        assertTrue(hasError);
    }

    @Test
    public void getWordCoordinatesForDirectionTestNorth() {
        String expected = "KHAN: (5,9),(5,8),(5,7),(5,6)";
        String actual = starTrekWordSearch.getWordCoordinatesForDirection("KHAN", WordSearch.NORTH);

        assertEquals(expected, actual);
    }

    @Test
    public void getWordCoordinatesForDirectionTestNorthRefactor() {
        String expected = "TEST: (0,15),(0,14),(0,13),(0,12)";
        String actual = pythonsWordSearch.getWordCoordinatesForDirection("TEST", WordSearch.NORTH);

        assertEquals(expected, actual);
    }

    @Test
    public void getWordCoordinatesForDirectionTestWest() {
        String expected = "RCAIT: (4,15),(3,15),(2,15),(1,15),(0,15)";
        String actual = pythonsWordSearch.getWordCoordinatesForDirection("RCAIT", WordSearch.WEST);

        assertEquals(expected, actual);
    }

    @Test
    public void getWordCoordinatesForDirectionTestSouth() {
        String expected = "EGGED: (14,0),(14,1),(14,2),(14,3),(14,4)";
        String actual = starTrekWordSearch.getWordCoordinatesForDirection("EGGED", WordSearch.SOUTH);

        assertEquals(expected, actual);
    }

    @Test
    public void getWordCoordinatesForDirectionTestEast() {
        String expected = "SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)";
        String actual = starTrekWordSearch.getWordCoordinatesForDirection("SCOTTY", WordSearch.EAST);

        assertEquals(expected, actual);
    }

    @Test
    public void getWordCoordinatesForDirectionTestNorthwest() {
        String expected = "GENMQ: (15,15),(14,14),(13,13),(12,12),(11,11)";
        String actual = pythonsWordSearch.getWordCoordinatesForDirection("GENMQ", WordSearch.NORTHWEST);

        assertEquals(expected, actual);
    }

    @Test
    public void getWordCoordinatesForDirectionTestNortheast() {
        String expected = "TLAAY: (0,15),(1,14),(2,13),(3,12),(4,11)";
        String actual = pythonsWordSearch.getWordCoordinatesForDirection("TLAAY", WordSearch.NORTHEAST);

        assertEquals(expected, actual);
    }

    @Test
    public void getWordCoordinatesForDirectionTestSouthwest() {
        String expected = "WCYTN: (15,0),(14,1),(13,2),(12,3),(11,4)";
        String actual = pythonsWordSearch.getWordCoordinatesForDirection("WCYTN", WordSearch.SOUTHWEST);

        assertEquals(expected, actual);
    }
}

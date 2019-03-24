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
}

import java.util.ArrayList;
import java.util.List;

class WordSearch {

    List<String> getLinesFromFile() {
        List<String> fileLines = new ArrayList<>();
        fileLines.add("BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA");
        fileLines.add("K,Y,L,B,Q,Q,P,M,D,F,C,K,E,A,B");
        return fileLines;
    }
}

public class GridItem {
    private String letter;
    private int xCoordinate;
    private int yCoordinate;

    GridItem(String letter, int xCoordinate, int yCoordinate) {
        this.letter = letter;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
}

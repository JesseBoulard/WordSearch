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

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
}

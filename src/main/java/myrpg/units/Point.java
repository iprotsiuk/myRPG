package myrpg.units;

public class Point {
    int colPosition;
    int rowPosition;

    public Point(int colPosition, int rowPosition){
        this.colPosition = colPosition;
        this.rowPosition = rowPosition;
    }

    public int getColPosition() {
        return colPosition;
    }

    public int getRowPosition() {
        return rowPosition;
    }
}

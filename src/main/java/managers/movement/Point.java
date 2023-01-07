package managers.movement;

public class Point {
    int colPosition;
    int rowPosition;

    public Point(int rowPosition, int colPosition){
        this.colPosition = colPosition;
        this.rowPosition = rowPosition;
    }

    public int getColPosition() {
        return colPosition;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public static double getDistanceBetweenPoints(Point p1, Point p2){
        double rowsDelta = Math.pow((p2.getRowPosition() - p1.getRowPosition()), 2);
        double colsDelta = Math.pow((p2.getColPosition() - p1.getColPosition()), 2);
        return Math.sqrt(rowsDelta+colsDelta);
    }

    @Override
    public String toString(){
        String ans = "";
        ans+= "[" + rowPosition;
        ans+= ":" + colPosition + "]";
        return ans;
    }
}

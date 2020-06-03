package myrpg.units;

//leave for now

public interface IMove {
    void move(int colsPosition, int rowsPosition);
    int getPosition();
    void pursuit(IMove move);
    void follow(IMove move);
}

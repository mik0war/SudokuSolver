package mechanics;

import mechanics.errors.NonFormatValue;
import mechanics.utils.Strings;

import static java.lang.Math.sqrt;

public class CellOnField extends Cell {
    //Parameters of position of cell in playing field
    private final int posX;
    private final int posY;
    private final int square;

    //Constructor for cell from playing field
    public CellOnField(int number, int fieldSize, int posX, int posY)
            throws NonFormatValue {
        super(number, fieldSize);

        if (posX > fieldSize || posX < 0 ||
                posY > fieldSize || posY < 0)
            throw new NonFormatValue(Strings.WRONG_COORDINATES);

        this.posX = posX;
        this.posY = posY;
        this.square = setSquare(fieldSize, posX, posY);
    }

    //Getters and setter of cell positions
    public int getSquare() {
        return square;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    private int setSquare(int fieldSize, int posX, int posY) {
        int countRowsColumns = (int)sqrt(fieldSize);

        int squareX = posX / countRowsColumns;
        int squareY = posY / countRowsColumns;

        return squareX + squareY * countRowsColumns;
    }

}

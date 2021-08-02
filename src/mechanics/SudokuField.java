package mechanics;

import mechanics.errors.NonFormatValue;
import mechanics.errors.NotInImageNumbers;
import mechanics.errors.NumberAlreadyExist;
import mechanics.utils.Strings;
import mechanics.utils.Utils;

import static java.lang.Math.sqrt;

public class SudokuField {

    protected final int fieldSize;
    protected CellOnField[] cells;

    public SudokuField(int size, int[] ... numbersArray)
            throws NonFormatValue {
        if (Utils.checkIsSquare(size))
            throw new NonFormatValue(Strings.WRONG_FIELD_SIZE);

        this.fieldSize = size;
        CellOnField[] cells = new CellOnField[size * size];

        initCells(numbersArray);
    }

    private void initCells(int[] ... numbersArray){
        if (numbersArray.length == 0)
            numbersArray = new int[1][fieldSize * fieldSize];

        try {
            createCell(numbersArray[0]);
        }
        catch (NonFormatValue error) {
            Utils.logMessage(error.toString());
        }
    }

    private void createCell(int[] numbersArray) throws NonFormatValue{
        if (numbersArray.length != cells.length)
            throw new NonFormatValue(Strings.WRONG_ARRAY_FORMAT);

        for (int y = 0; y < fieldSize; y++)
            for (int x = 0; x < fieldSize; x++) {
                int position = x + y * (int)sqrt(fieldSize);

                int number = numbersArray[position];
                if (number < 0 ||  number > this.cells.length)
                    throw new NonFormatValue(
                            Strings.WRONG_ARRAY_FORMAT_IN_POSITION + position
                    );

                this.cells[position] = new CellOnField(number, fieldSize, x, y);
            }
    }

    private int getPosition (int posX, int posY){
        return posX + posY * (int)sqrt(fieldSize);
    }

    public void setNumberAtCell(int number, int posX, int posY){
        try {
            cells[getPosition(posX, posY)].setNumber(number);
        } catch (NotInImageNumbers error) {
            Utils.logMessage(error.toString());
        }
    }

    public void setNumberAtCellForce(int number, int posX, int posY){
        int position = getPosition(posX, posY);

        try {
            if (!cells[position].getImNumber(number))
                cells[position].setImNumber(number);
        } catch (NumberAlreadyExist error) {
            Utils.logMessage(error.toString());
        }

        try {
            cells[position].setNumber(number);
        } catch (NotInImageNumbers error) {
            Utils.logMessage(error.toString());
        }
    }

    public void setImNumberAtCell(int number, int posX, int posY){
        try {
            cells[getPosition(posX, posY)].setImNumber(number);
        } catch (NumberAlreadyExist error) {
            Utils.logMessage(error.toString());
        }
    }

    public int getNumberFromCell(int posX, int posY){
        return cells[getPosition(posX, posY)].getNumber();
    }

    public boolean getImNumberFromCell(int number, int posX, int posY){
        return cells[getPosition(posX, posY)].getImNumber(number);
    }

    public boolean[] getImNumbersFromCell(int posX, int posY){
        return cells[getPosition(posX, posY)].getImNumbers();
    }
}


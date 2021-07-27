package mechanics;

import mechanics.errors.NonFormatValue;
import mechanics.utils.Utils;

import static java.lang.Math.sqrt;

public class SudokuField {

    private final int fieldSize;
    private SudokuCell[] cells;

    public SudokuField(int size, int[] ... numbersArray) throws NonFormatValue {
        if (Utils.checkIsSquare(size))
            throw new NonFormatValue("Size of field isn't square of some number");

        this.fieldSize = size;
        SudokuCell[] cells = new SudokuCell[size * size];

        fillNumbers(numbersArray);
    }

    public void fillNumbers (int[] ... numbersArray){
        if (numbersArray.length == 0)
            numbersArray = new int[1][fieldSize * fieldSize];

        try {
            fillCells(numbersArray[0]);
        }
        catch (NonFormatValue error) {
            Utils.logMessage(error.toString());
        }
    }

    public void fillCells(int[] numbersArray) throws NonFormatValue{
        if (numbersArray.length != cells.length)
            throw new NonFormatValue("Wrong format of array");

        for (int y = 0; y < fieldSize; y++)
            for (int x = 0; x < fieldSize; x++) {
                int position = x + y * (int)sqrt(fieldSize);

                int number = numbersArray[position];
                if (number < 0 ||  number > this.cells.length)
                    throw new NonFormatValue("Wrong format of array value at position " + position);

                this.cells[position] = new SudokuCell(number, fieldSize, x, y);
            }
    }
}

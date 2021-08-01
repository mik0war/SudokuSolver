package mechanics;

import mechanics.errors.NonFormatValue;
import mechanics.utils.Strings;
import mechanics.utils.Utils;

import static java.lang.Math.sqrt;

public class SudokuField {

    private final int fieldSize;
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

}

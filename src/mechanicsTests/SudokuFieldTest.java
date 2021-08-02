package mechanicsTests;

import mechanics.SudokuField;
import mechanics.errors.NonFormatValue;
import mechanics.utils.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuFieldTest {

    @Test
    void setNumberAtCellForce() {
        try {
            SudokuField sudokuField = new SudokuField(9);

            sudokuField.setNumberAtCellForce(3, 0, 4);

            assertEquals(3, sudokuField.getNumberFromCell(0, 4));
        } catch (NonFormatValue error) {
            Utils.logMessage(error.toString());
        }

    }
}
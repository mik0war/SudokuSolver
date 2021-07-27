package mechanicsTests;

import mechanics.SudokuCell;
import mechanics.errors.NotInImageNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuCellTest {

    @Test
    void setNumber() {
        SudokuCell cell = new SudokuCell(0, 9);
        cell.setImNumber(3);
        try {
            cell.setNumber(3);
        } catch (NotInImageNumbers notInImageNumbers) {
            notInImageNumbers.printStackTrace();
        }

        assert cell.getNumber() == 3;

        NotInImageNumbers exception = new NotInImageNumbers();
    }

    @Test
    void setImNumber() {
    }

    @Test
    void countOfImNumbers() {
    }

    @Test
    void setSquare() {
    }
}
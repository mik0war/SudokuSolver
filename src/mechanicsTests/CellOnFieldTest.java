package mechanicsTests;

import mechanics.Cell;
import mechanics.CellOnField;
import mechanics.errors.NonFormatValue;
import mechanics.errors.NotInImageNumbers;
import mechanics.utils.Strings;
import mechanics.utils.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellOnFieldTest {

    @Test
    void setSquare() {
        try {
            CellOnField cell =
                    new CellOnField(0, 9, 0, 0);
            CellOnField cell1 =
                    new CellOnField(0, 9, 5, 0);
            CellOnField cell2 =
                    new CellOnField(0, 16, 5, 9);
            CellOnField cell3 =
                    new CellOnField(0, 9, 8, 8);

            assertEquals(0, cell.getSquare());
            assertEquals(1, cell1.getSquare());
            assertEquals(9, cell2.getSquare());
            assertEquals(8, cell3.getSquare());

        } catch (NonFormatValue error){
            Utils.logMessage(error.toString());
        }
    }

}
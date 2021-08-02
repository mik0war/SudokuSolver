package mechanicsTests;

import mechanics.Cell;
import mechanics.errors.NotInImageNumbers;
import mechanics.errors.NumberAlreadyExist;
import mechanics.utils.Strings;
import mechanics.utils.Utils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void setNumberException() {
        Cell cell = new Cell(0);

        Exception exception = assertThrows(NotInImageNumbers.class,
                () -> {cell.setNumber(4);});

        String expectedMessage = Strings.NOT_IN_IMAGE;
        String actualMessage = exception.toString();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void setNumberSuccess() {
        Cell cell = new Cell(0);

        try {
            cell.setImNumber(4);
            cell.setNumber(4);
        } catch (NotInImageNumbers | NumberAlreadyExist error) {
            Utils.logMessage(error.toString());
        }

        assertEquals(4, cell.getNumber());
    }

    @Test
    void setImNumberException() {
        Cell cell = new Cell(4);

        Exception exception = assertThrows(NumberAlreadyExist.class,
                () -> {cell.setImNumber(3);});

        String expectedMessage = Strings.NUMBER_EXIST;
        String actualMessage = exception.toString();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void removeImNumber() {
        Cell cell = new Cell(0);
        try {
            cell.setImNumber(5);
        } catch (NumberAlreadyExist error) {
            Utils.logMessage(error.toString());
        }

        assertTrue(cell.getImNumber(5));

        cell.removeImNumber(5);

        assertFalse(cell.getImNumber(5));
    }

    @Test
    void countOfImNumbers() {
        Cell cell = new Cell(0);

        try{
            cell.setImNumber(1);
            assertEquals(1, cell.countOfImNumbers());

            cell.setImNumber(2);
            assertEquals(2, cell.countOfImNumbers());

            cell.setImNumber(3);
            assertEquals(3, cell.countOfImNumbers());

            cell.setImNumber(8);
            assertEquals(4, cell.countOfImNumbers());

            cell.removeImNumber(1);
            assertEquals(3, cell.countOfImNumbers());
        } catch (NumberAlreadyExist error){
            Utils.logMessage(error.toString());
        }
    }
}
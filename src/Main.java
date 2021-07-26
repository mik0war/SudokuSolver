import mechanics.Sudoku;
import mechanics.SudokuCell;
import mechanics.errors.NotInImageNumbers;
import mechanics.utils.Utils;

public class Main {

    public static void main(String[] args) {
        SudokuCell cell = new SudokuCell(1, 9, 3, 4, 5);

        cell.setImNumber(1);
        cell.setImNumber(3);
        try {
            cell.setNumber(3);
        }
        catch (NotInImageNumbers error){
            Utils.logMassage(error.toString());
        }
        System.out.println(cell.showImNumber());


    }
}

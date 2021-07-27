import mechanics.SudokuCell;
import mechanics.errors.NotInImageNumbers;
import mechanics.utils.Utils;

public class Main {

    public static void main(String[] args) {

    System.out.println(Utils.checkIsSquare(9));
        System.out.println(Utils.checkIsSquare(8));
        System.out.println(Utils.checkIsSquare(-2));
        System.out.println(Utils.checkIsSquare(1));
        System.out.println(Utils.checkIsSquare(8755));
    }
}

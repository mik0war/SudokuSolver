package mechanics;

import mechanics.errors.NonFormatValue;
import mechanics.errors.NotInImageNumbers;
import mechanics.errors.NumberAlreadyExist;
import mechanics.utils.Utils;

public class Sudoku {

    private int size = 9;
    private CellOnField[][] cells = new CellOnField[size][size];

    public Sudoku(int size) {
        int squareY = 0;
        for (int y = 0; y < 9; y++) {
            int squareX = 0;
            for (int x = 0; x < 9; x++) {
                try {
                    this.cells[x][y] = new CellOnField( 0, squareX + squareY*3, x, y);
                } catch (NonFormatValue e) {
                    e.printStackTrace();
                }
                if (x == 2 || x == 5)
                    squareX++;
            }
            if (y == 2 || y == 5)
                squareY++;
        }
    }

    private void validateImToNumber(int num, int secondX, int secondY){
        for (int y = 0; y < 9; y++)
            for (int x = 0; x < 9; x++){
                if (cells[x][y].getNumber() == 0)
                    if (cells[x][y].getImNumbers()[num-1] &&
                            ((y == secondY) || (x == secondX) ||
                                    (cells[x][y].getSquare() == cells[secondX][secondY].getSquare()))) {
                        cells[x][y].removeImNumber(num);
                    }

            }
    }

    public String showImNumbers(){
        String result = "";
        for (int y = 0; y < 9; y++)
            for (int x = 0; x < 9; x++)
                if (cells[x][y].getNumber() == 0 && cells[x][y].countOfImNumbers() != 0)
                    result += cells[x][y].imNumbersToString() + "imaginary num at ( " + (x+1) + "; " + (y+1) + " )" + '\n';
        return result;
    }

    public String showImNumbers(int posX, int posY){
        return cells[posX][posY].imNumbersToString() + "imaginary num at ( " + (posX+1) + "; " + (posY+1) + " )";
    }

    private void fillImNumbers() {
        for (int y = 0; y < 9; y++)
            for (int x = 0; x < 9; x++)
                if (cells[x][y].getNumber() == 0)
                    for (int number = 1; number <= 9; number++) {
                        boolean isPrint = true;
                        for (int secondY = 0; secondY < 9; secondY++)
                            for (int secondX = 0; secondX < 9; secondX++)
                                if (cells[secondX][secondY].getNumber() != 0)
                                    if (number == cells[secondX][secondY].getNumber() &&
                                            ((y == secondY) || (x == secondX) ||
                                                    (cells[x][y].getSquare() == cells[secondX][secondY].getSquare())))
                                        isPrint = false;
                        if (isPrint) {
                            try {
                                cells[x][y].setImNumber(number);
                            } catch (NumberAlreadyExist e) {
                                e.printStackTrace();
                            }
                        }
                    }
    }

    public boolean onlyImToNumber() throws NotInImageNumbers {
        boolean isWorks = false;
        for (int y = 0; y < 9; y++)
            for (int x = 0; x < 9; x++){
                if (cells[x][y].countOfImNumbers() == 1)
                    for (int num = 1; num < 10; num++)
                        if (cells[x][y].getImNumbers()[num-1]) {
                            try {
                                cells[x][y].setNumber(num);
                            }
                            catch (NotInImageNumbers error){
                                Utils.logMessage(error.toString());
                            }
                            isWorks = true;
                            validateImToNumber(num, x, y);
                        }
                if (cells[x][y].getNumber() == 0)
                    for (int num = 1; num < 10; num++) {
                        if (cells[x][y].getImNumbers()[num-1]) {
                            boolean isPrintLine = true;
                            boolean isPrintColumn = true;
                            boolean isPrintSquare = true;
                            for (int secondX = 0; secondX < 9; secondX++)
                                for (int secondY = 0; secondY < 9; secondY++) {

                                    if (cells[secondX][secondY].getNumber() == 0)
                                        if (cells[secondX][secondY].getImNumbers()[num - 1] &&
                                                cells[x][y].getSquare() == cells[secondX][secondY].getSquare() &&
                                                (x != secondX || y != secondY))
                                            isPrintSquare = false;

                                    if (cells[secondX][y].getNumber() == 0)
                                        if (cells[secondX][y].getImNumbers()[num - 1] && x != secondX)
                                            isPrintLine = false;

                                    if (cells[x][secondY].getNumber() == 0)
                                        if (cells[x][secondY].getImNumbers()[num - 1]&& y != secondY)
                                            isPrintColumn = false;
                                }
                            if (isPrintSquare || isPrintLine || isPrintColumn) {
                                isWorks = true;
                                this.cells[x][y].setNumber(num);
                                validateImToNumber(num, x, y);
                            }
                        }
                    }
            }
        return isWorks;
    }

    private boolean reductionImNumbersLineCol(){
        boolean isWorks = false;
        for (int num = 1; num < 10; num++)
            for (int y_x = 0; y_x < 9; y_x++)
            {
                boolean isClearSquareLine = false;
                boolean isEnterLine = true;
                boolean isClearSquareColumn = false;
                boolean isEnterColumn = true;
                int squareLine = -1;
                int squareColumn = -1;

                for (int x_y = 0; x_y < 9; x_y++) {
                    if (cells[x_y][y_x].getImNumbers()[num - 1] && isEnterLine) {

                        if (squareLine == -1) {
                            squareLine = cells[x_y][y_x].getSquare();
                            isClearSquareLine = true;
                        }

                        if (cells[x_y][y_x].getSquare() != squareLine) {
                            isClearSquareLine = false;
                            isEnterLine = false;
                        }
                    }

                    if (cells[y_x][x_y].getImNumbers()[num - 1] && isEnterColumn) {

                        if (squareColumn == -1) {
                            squareColumn = cells[y_x][x_y].getSquare();
                            isClearSquareColumn = true;
                        }

                        if (cells[y_x][x_y].getSquare() != squareColumn) {
                            isClearSquareColumn = false;
                            isEnterColumn = false;
                        }
                    }
                }

                if (isClearSquareLine || isClearSquareColumn){
                    for (int y = 0; y < 9; y++) {
                        if (y != y_x)
                            for (int x = 0; x < 9; x++){
                                if (isClearSquareLine && cells[x][y].getImNumbers()[num-1] && cells[x][y].getSquare() == squareLine) {
                                    cells[x][y].removeImNumber(num);
                                    isWorks = true;
                                }

                                if (isClearSquareColumn && cells[y][x].getImNumbers()[num-1] && cells[y][x].getSquare() == squareColumn) {
                                    cells[y][x].removeImNumber(num);
                                    isWorks = true;
                                }
                            }
                    }
                }

            }
        return isWorks;
    }

    private boolean guidingImNumbers() {
        boolean isWorks = false;
        for (int num = 1; num < 10; num++)
            for (int square = 0; square < 9; square++) {
                int y_potential = -1;
                boolean isLine = false;
                int x_potential = -1;
                boolean isColumn = false;

                for (int y = 0; y < 9; y++)
                    for (int x = 0; x < 9; x++) {
                        if (cells[x][y].getSquare() == square && cells[x][y].getImNumbers()[num-1]){
                            if (y_potential == -1) {
                                isLine = true;
                                y_potential = y;
                            }
                            if (y_potential != y)
                                isLine = false;
                        }

                        if (cells[y][x].getSquare() == square && cells[y][x].getImNumbers()[num-1]){
                            if (x_potential == -1) {
                                isColumn = true;
                                x_potential = y;
                            }
                            if (x_potential != y)
                                isColumn = false;
                        }
                    }

                if (isLine || isColumn) {
                    for (int cord = 0; cord < 9; cord++){
                        if (isLine && cells[cord][y_potential].getSquare() != square)
                            cells[cord][y_potential].removeImNumber(num);

                        if (isColumn && cells[x_potential][cord].getSquare() != square)
                            cells[x_potential][cord].removeImNumber(num);
                    }

                }


            }
        return isWorks;
    }

    //TODO
    public void solve() throws NotInImageNumbers {
        this.fillImNumbers();
        while (this.onlyImToNumber());
    }

    @Override
    public String toString() {
        String sudoku = "";
        for (int y = 0; y<9; y++) {
            for (int x = 0; x < 9; x++) {
                sudoku += cells[x][y].getNumber();
                sudoku += ' ';
            }
            sudoku += '\n';
        }

        return sudoku;
    }
}

package mechanics;

public class Sudoku {
    private Sudoku_cell[][] cells = new Sudoku_cell[9][9];

    public Sudoku() {
        int squareY = 0;
        for (int y = 0; y < 9; y++) {
            int squareX = 0;
            for (int x = 0; x < 9; x++) {
                this.cells[x][y] = new Sudoku_cell( 0, squareX + squareY*3);
                if (x == 2 || x == 5)
                    squareX++;
            }
            if (y == 2 || y == 5)
                squareY++;
        }
    }

    public void insertNumber(int num, int posX, int posY){
        cells[posX][posY].setNumber(num);
    }

    public void insertImNumber(int num, int posX, int posY, boolean isRemove){
        cells[posX][posY].setImNumber(num, isRemove);
    }

    public String showImNumbers(){
        String result = "";
        for (int y = 0; y < 9; y++)
            for (int x = 0; x < 9; x++)
                if (cells[x][y].getNumber() == 0)
                    result += cells[x][y].showImNumber() + "imaginary num at ( " + (x+1) + "; " + (y+1) + " )" + '\n';
        return result;
    }

    public String showImNumbers(int posX, int posY){
        return cells[posX][posY].showImNumber() + "imaginary num at ( " + (posX+1) + "; " + (posY+1) + " )";
    }

    public void fillImNumbers() {
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
                        if (isPrint)
                            cells[x][y].setImNumber(number, false);
                    }
    }

    public boolean onlyImToNumber(){
        boolean isWorks = false;
        for (int y = 0; y < 9; y++)
            for (int x = 0; x < 9; x++){
                if (cells[x][y].countOfImNumbers() == 1)
                    for (int num = 1; num < 10; num++)
                        if (num == cells[x][y].getImNumber()[num-1]) {
                            cells[x][y].setNumber(num);
                            cells[x][y].setImNumber(num, true);
                            isWorks = true;
                            validateImToNumber(num, x, y);
                        }
                if (cells[x][y].getNumber() == 0)
                    for (int num = 1; num < 10; num++) {
                        if (cells[x][y].getImNumber()[num-1] == num) {
                            boolean isPrintLine = true;
                            boolean isPrintColumn = true;
                            boolean isPrintSquare = true;
                            for (int secondX = 0; secondX < 9; secondX++)
                                for (int secondY = 0; secondY < 9; secondY++) {

                                    if (cells[secondX][secondY].getNumber() == 0)
                                        if (cells[secondX][secondY].getImNumber()[num - 1] != 0 &&
                                                cells[x][y].getSquare() == cells[secondX][secondY].getSquare() &&
                                                (x != secondX || y != secondY))
                                            isPrintSquare = false;

                                    if (cells[secondX][y].getNumber() == 0)
                                        if (cells[secondX][y].getImNumber()[num - 1] != 0 && x != secondX)
                                            isPrintLine = false;

                                    if (cells[x][secondY].getNumber() == 0)
                                        if (cells[x][secondY].getImNumber()[num - 1] != 0 && y != secondY)
                                            isPrintColumn = false;
                                }
                            if (isPrintSquare || isPrintLine || isPrintColumn) {
                                cells[x][y].setNumber(num);
                                cells[x][y].setImNumber(num, true);
                                isWorks = true;
                                validateImToNumber(num, x, y);
                            }
                        }
                    }
            }
        return isWorks;
    }

    private void validateImToNumber(int num, int secondX, int secondY){
        for (int y = 0; y < 9; y++)
            for (int x = 0; x < 9; x++){
                if (cells[x][y].getNumber() == 0)
                    if (num == cells[x][y].getImNumber()[num-1] &&
                        ((y == secondY) || (x == secondX) ||
                                (cells[x][y].getSquare() == cells[secondX][secondY].getSquare()))) {
                        cells[x][y].setImNumber(num, true);
                    }

            }
    }

    public void solve(){
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

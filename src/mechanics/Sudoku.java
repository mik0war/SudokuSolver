package mechanics;

public class Sudoku {
    private Sudoku_cell[][] cells = new Sudoku_cell[9][9];

    public Sudoku() {
        int squareY = 0;
        for (int y = 0; y < 9; y++) {
            int squareX = 0;
            for (int x = 0; x < 9; x++) {
                this.cells[x][y] = new Sudoku_cell( 0, x, y, squareX + squareY*3);
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

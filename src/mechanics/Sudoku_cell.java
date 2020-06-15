package mechanics;

public class Sudoku_cell {
    private int number;
    private int[] imNumber = new int[9];
    private int positionX;
    private int positionY;
    private int square;

    public Sudoku_cell(int number, int positionX, int positionY, int square) {
        this.number = number;
        this.positionX = positionX;
        this.positionY = positionY;
        this.square = square;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int[] getImNumber() {
        return imNumber;
    }

    public void setImNumber(int imNumber, boolean flag) {
        if (!flag)
            this.imNumber[imNumber-1] = imNumber;
        else
            this.imNumber[imNumber-1] = 0;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getSquare() {
        return square;
    }

    public String showImNumber(){
        String imNumbers = "";
        for (int i = 0; i<9; i++)
            imNumbers = imNumbers + this.imNumber[i] + ' ';
        return imNumbers;
    }
}

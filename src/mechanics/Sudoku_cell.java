package mechanics;

public class Sudoku_cell {
    private int number;
    private int[] imNumber = new int[9];
    private int square;

    public Sudoku_cell(int number, int square) {
        this.number = number;
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
            this.imNumber[imNumber - 1] = imNumber;
        else
            this.imNumber[imNumber - 1] = 0;
    }

    public int getSquare() {
        return square;
    }

    public String showImNumber() {
        String imNumbers = "";
        for (int i = 0; i < 9; i++)
            imNumbers = imNumbers + this.imNumber[i] + ' ';
        return imNumbers;
    }

    public int countOfImNumbers() {
        int[] imNumbers = this.getImNumber();
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (imNumbers[i] != 0)
                count++;
        }
        return count;
    }
}


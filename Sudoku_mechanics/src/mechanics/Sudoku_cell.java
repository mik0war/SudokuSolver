package mechanics;

public class Sudoku_cell {
    private int number;
    private boolean[] imNumber = new boolean[9];
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
        for(int i = 0; i < 9; i++)
            this.imNumber[i] = false;
    }

    public boolean[] getImNumber(){
        return this.imNumber;
    }

    public int[] getImNumber(boolean isInt) {
        int[] result = new int[9];
        for (int i = 0; i < 9; i++)
            if (this.imNumber[i])
                result[i] = i+1;
        return result;
    }

    public void setImNumber(int imNumber, boolean isRemove) {
        if (!isRemove)
            this.imNumber[imNumber - 1] = true;
        else
            this.imNumber[imNumber - 1] = false;
    }

    public int getSquare() {
        return square;
    }

    public String showImNumber() {
        String imNumbers = "";
        for (int i = 0; i < 9; i++)
            if (this.imNumber[i])
            imNumbers = imNumbers + (i+1) + ' ';
        return imNumbers;
    }

    public int countOfImNumbers() {
        boolean[] imNumbers = this.getImNumber();
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (imNumbers[i])
                count++;
        }
        return count;
    }

    public boolean contains(Sudoku_cell secondCell, int count){
        boolean[] first_imNumbers;
        boolean[] second_imNumbers;
        boolean isEquals = false;

        if (this.countOfImNumbers() > secondCell.countOfImNumbers()) {
            first_imNumbers = this.getImNumber();
            second_imNumbers = secondCell.getImNumber();
        }
        else{
            first_imNumbers = secondCell.getImNumber();
            second_imNumbers = this.getImNumber();
        }

        for (int i = 0; i < 9; i++){
            if (first_imNumbers[i] || second_imNumbers[i])
                if (first_imNumbers[i] && second_imNumbers[i] || first_imNumbers[i] && !second_imNumbers[i]) {
                    isEquals = true;
                    count--;
                }
                else
                    return false;
        }

        if (count == 0)
            return isEquals;
        else
            return false;
    }
}


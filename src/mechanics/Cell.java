package mechanics;

import mechanics.errors.NotInImageNumbers;
import mechanics.errors.NumberAlreadyExist;
import mechanics.utils.Parameters;

public class Cell {
    private int number;
    private boolean[] imNumbers;

    Cell(int number, int SudokuSize){
        this.number = number;
        this.imNumbers = new boolean[SudokuSize];
    }

    public Cell(int number) {
        this.number = number;
        this.imNumbers = new boolean[Parameters.DEFAULT_SIZE_VALUE];
    }

    //Methods for manipulation with main number of cell
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) throws NotInImageNumbers {
        if (!imNumbers[number - 1])
            throw new NotInImageNumbers();

        this.number = number;

        for(int imNumber = 0; imNumber < imNumbers.length; imNumber++)
            this.imNumbers[imNumber] = false;
    }


    //Methods for manipulation with image numbers of cell
    public boolean[] getImNumbers() {
        return imNumbers;
    }

    public boolean getImNumber(int imNumber) {
        return imNumbers[imNumber - 1];
    }

    public void setImNumber(int imNumber) throws NumberAlreadyExist {
        if (this.number != 0)
            throw new NumberAlreadyExist();

        this.imNumbers[imNumber - 1] = true;
    }

    public void removeImNumber(int imNumber) {
        this.imNumbers[imNumber - 1] = false;
    }

    public int countOfImNumbers() {
        int count = 0;

        for (boolean imNumber : this.imNumbers)
            if (imNumber)
                count++;

        return count;
    }

    //View of cell's image numbers
    public String imNumbersToString() {
        StringBuilder imNumbers = new StringBuilder();

        for (boolean imNumber : this.imNumbers)
            imNumbers.append(imNumber).append(' ');

        return imNumbers.toString();
    }
}

package mechanics;

import mechanics.errors.NotInImageNumbers;
import mechanics.utils.Parameters;

public class SudokuCell {

    private int number;
    private boolean[] imNumbers;

    //Parameters of position of cell in playing field
    private int posX;
    private int posY;
    private int square;

    //Constructor for cell from playing field
    public SudokuCell(int number, int SudokuSize, int posX, int posY, int square) {
        this.number = number;
        this.imNumbers = new boolean[SudokuSize];
        this.posX = posX;
        this.posY = posY;
        this.square = square;
    }

    //Constructor for cell without position
    public SudokuCell(int number, int SudokuSize) {
        this.number = number;
        this.imNumbers = new boolean[SudokuSize];

        this.posX = this.posY = this.square = Parameters.MISSING_VALUE;
    }

    //Constructor for cell without position in default sudoku (9x9)
    public SudokuCell(int number) {
        this.number = number;
        this.imNumbers = new boolean[Parameters.DEFAULT_VALUE];

        this.posX = this.posY = this.square = Parameters.MISSING_VALUE;
    }


    //Methods for manipulation with main number of cell
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) throws NotInImageNumbers {
        if (!imNumbers[number - 1])
            throw new NotInImageNumbers();

        this.number = number;
        
        for(int i = 0; i < imNumbers.length; i++)
            this.imNumbers[i] = false;
    }


    //Methods for manipulation with image numbers of cell
    public boolean[] getImNumbers() {
        return imNumbers;
    }

    public boolean getImNumber(int imNumber) {
        return imNumbers[imNumber - 1];
    }

    public void setImNumber(int imNumber) {
        this.imNumbers[imNumber - 1] = true;
    }

    public void removeImNumber(int imNumber) {
        this.imNumbers[imNumber - 1] = false;
    }

    public int countOfImNumbers() {
        boolean[] imNumbers = this.getImNumbers();
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (!imNumbers[i])
                count++;
        }
        return count;
    }


    //Getters of cell positions
    public int getSquare() {
        return square;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


    //View of cell's image numbers
    public String showImNumber() {
        StringBuilder imNumbers = new StringBuilder();
        for (int i = 0; i < imNumbers.length(); i++)
            imNumbers.append(this.imNumbers[i]).append(' ');
        return imNumbers.toString();
    }

}

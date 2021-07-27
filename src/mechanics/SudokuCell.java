package mechanics;

import mechanics.errors.NotInImageNumbers;
import mechanics.utils.Parameters;

import static java.lang.Math.sqrt;

public class SudokuCell {

    private int number;
    private boolean[] imNumbers;

    //Parameters of position of cell in playing field
    private final int posX;
    private final int posY;
    private final int square;

    //Constructor for cell from playing field
    public SudokuCell(int number, int fieldSize, int posX, int posY) {
        this.number = number;
        this.imNumbers = new boolean[fieldSize];
        this.posX = posX;
        this.posY = posY;
        this.square = setSquare(fieldSize, posX, posY);
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
        this.imNumbers = new boolean[Parameters.DEFAULT_SIZE_VALUE];

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


    //Getters and setter of cell positions
    public int getSquare() {
        return square;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int setSquare(int fieldSize, int posX, int posY) {
        int countRowsColumns = (int)sqrt(fieldSize);

        int squareX = (posX + 1) / countRowsColumns;
        int squareY = (posY + 1) / countRowsColumns;

        return squareX + squareY * countRowsColumns;
    }

    //View of cell's image numbers
    public String ImNumbersToString() {
        StringBuilder imNumbers = new StringBuilder();

        for (int imNumber = 0; imNumber < imNumbers.length(); imNumber++)
            imNumbers.append(this.imNumbers[imNumber]).append(' ');

        return imNumbers.toString();
    }

}

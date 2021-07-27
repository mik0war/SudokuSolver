package mechanics.errors;

public class NonFormatValue extends Exception {
    String message;

    public NonFormatValue(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}

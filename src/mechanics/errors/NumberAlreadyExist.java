package mechanics.errors;

import mechanics.utils.Strings;

public class NumberAlreadyExist extends Exception {
    @Override
    public String toString() {
        return Strings.NUMBER_EXIST;
    }
}

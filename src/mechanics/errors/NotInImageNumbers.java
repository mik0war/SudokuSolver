package mechanics.errors;

import mechanics.utils.Strings;

public class NotInImageNumbers extends Exception{
    @Override
    public String toString() {
        return Strings.NOT_IN_IMAGE;
    }
}

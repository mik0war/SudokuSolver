package mechanics.utils;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Utils {
    public static void logMessage(String massage){
        System.out.println(massage);
    }

    public static boolean checkIsSquare(int size){
        return  (size > 1) &&
                (pow(sqrt(size), 2) == size);
    }
}

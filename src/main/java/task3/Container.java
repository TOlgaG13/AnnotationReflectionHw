package task3;

import java.io.*;
import java.lang.reflect.Field;

public class Container implements Serializable {
    @Save
    String text = "Happiness is not the absence of problems, but the ability to deal with them.";

    @Save
    int number = 22;

    String nonSavedField = "This will not be serialized";
}






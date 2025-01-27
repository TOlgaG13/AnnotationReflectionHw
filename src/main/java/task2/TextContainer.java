package task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
@SaveTo(path = "output.txt")
public class TextContainer {
   private String text = "Happiness is not the absence of problems, but the ability to deal with them.";

    public TextContainer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Saver
    public void save(String path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(text);
        }
    }
}
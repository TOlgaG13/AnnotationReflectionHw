package task2;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        TextContainer container = new TextContainer("Happiness is not the absence of problems, but the ability to deal with them.");
        Class<?> cls = container.getClass();

        if (cls.isAnnotationPresent(SaveTo.class)) {
            SaveTo saveTo = cls.getAnnotation(SaveTo.class);
            String path = saveTo.path();

            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Saver.class)) {
                    method.invoke(container, path);
                    System.out.println("Text saved to " + path);
                }
            }
        }
    }
    }
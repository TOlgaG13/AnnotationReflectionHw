package task3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;

public class Main {
    public static void serialize(Object obj, String filePath) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            Class<?> cls = obj.getClass();
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true);
                    oos.writeObject(field.get(obj));
                }
            }
        }
    }

    public static void deserialize(Object obj, String filePath) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Class<?> cls = obj.getClass();
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true);
                    Object value = ois.readObject();
                    field.set(obj, value);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Container container = new Container();
        String filePath = "serialized_data.bin";


        serialize(container, filePath);
        System.out.println("Serialized data to " + filePath);


        container.text = null;
        container.number = 0;


        deserialize(container, filePath);
        System.out.println("Deserialized text: " + container.text);
        System.out.println("Deserialized number: " + container.number);
    }
}


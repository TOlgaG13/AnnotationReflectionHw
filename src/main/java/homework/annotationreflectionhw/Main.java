package homework.annotationreflectionhw;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    @Test(a = 2, b = 5)
    public void test(int a, int b) throws InvocationTargetException, IllegalAccessException {
        System.out.println("a: " + a + ", b: " + b);

                }
            }





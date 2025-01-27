package homework.annotationreflectionhw;

import homework.annotationreflectionhw.Main;


import java.lang.reflect.Method;

public class SumResult {
    public static void main(String[] args) throws Exception {
        Main main = new Main();


        for (Method method : main.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                Test annotation = method.getAnnotation(Test.class);

                method.invoke(main, annotation.a(), annotation.b());


            }
        }
    }
}
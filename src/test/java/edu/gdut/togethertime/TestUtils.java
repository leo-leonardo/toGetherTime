package edu.gdut.togethertime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestUtils {

    public static <T> T invoke (String methodName, Class clz, Object... objects) {
        T obj = null;
        try {
            Method method = clz.getDeclaredMethod(methodName);
            obj = (T) method.invoke(clz.newInstance(), objects);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }
}

package com.github.maciejwalkowiak.as.bonus;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class BonusATest {
    @Test
    public void test() {
        String s = "1";
        Integer i = 1;

        s = add(s, 1);
        assertEquals("2", s);
        s = add(s, 5);
        assertEquals("7", s);

        i = add(i, 2);
        assertEquals((Integer) 3, i);
        i = add(i, 1);
        assertEquals((Integer) 4, i);
    }

    private <T> T add(T a, int b) {
        try {
            Method m = a.getClass().getMethod("valueOf", int.class);
            return (T) m.invoke(null, Integer.valueOf(a.toString()) + b);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.github.maciejwalkowiak.as.bonus;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;

public class BonusBTest {
    @Test
    public void testChangeFooBar() {

        TestClass testClass = new TestClass();
        assertEquals("test", testClass.getFoobar());

        ReflectionTestUtils.setField(testClass, "foobar", "SUCCESS");

        assertEquals("SUCCESS", testClass.getFoobar());
    }

}

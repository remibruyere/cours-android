package com.bruyere.tptest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MainActivityUnitTest {
    IComparator comparator = new MainActivity();

    @Test
    public void isEqual_NullNull_Ok() {
        assertTrue(comparator.isEqual(null, null));
    }

    @Test
    public void isEqual_NullText_Ok() {
        assertFalse(comparator.isEqual(null, "text"));
    }

    @Test
    public void isEqual_TextNull_Ok() {
        assertFalse(comparator.isEqual("text", null));
    }

    @Test
    public void isEqual_TextText_Ok() {
        assertTrue(comparator.isEqual("text", "text"));
        assertTrue(comparator.isEqual("text", "Text"));
    }
}
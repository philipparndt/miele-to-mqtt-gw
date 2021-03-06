package de.rnd7.miele.api;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DurationParserTest {
    @Test
    public void testNull() throws Exception {
        assertEquals(0,
            DurationParser.parse(null).getSeconds());
    }

    @Test
    public void testInvalid() throws Exception {
        assertEquals(0,
            DurationParser.parse(new JSONArray("[]")).getSeconds());
        assertEquals(0,
            DurationParser.parse(new JSONArray("[1, 2, 3, 4]")).getSeconds());
    }

    @Test
    public void testWithSeconds() {
        assertEquals(3600 + 2 * 60 + 3,
            DurationParser.parse(new JSONArray("[1, 2, 3]")).getSeconds());
    }

    @Test
    public void testWithoutSeconds() {
        assertEquals(3600 + 2 * 60,
            DurationParser.parse(new JSONArray("[1, 2]")).getSeconds());
    }
}

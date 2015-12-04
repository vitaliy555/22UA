package ua.twotwo.utils;

import static junit.framework.Assert.assertFalse;

import org.junit.Test;

public class StubToolTest {

    @Test
    public void testReadStubFromResource() throws Exception {
        String stubData = StubTool.readStubFromResource("stubForTest.json");
        assertFalse(stubData.isEmpty());
    }
}
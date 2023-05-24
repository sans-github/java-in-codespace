package com.app;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TopKTest {
    TopK topK;

    @Before
    public void setUp() {
        topK = new TopK();
    }

    @Test
    public void testTopThree() {
        List<String> events = Arrays.asList(new String[] {
                "A", "A", "A",
                "B", "B", "B", "B",
                "K", "K", "K", "K", "K", "K",
                "C", "C", "C", "C", "C",
                "Y"
        });
        List<HeavyHitter> heavyHitters = topK.getTopK(events, 3);
        assertTrue("There are 3 heavy hitters", heavyHitters.size() == 3);

        for (HeavyHitter heavyHitter : heavyHitters) {
            System.out.printf("%s - %d\n", heavyHitter.getId(), heavyHitter.getFrequency());
            switch (heavyHitter.getId()) {
                case "B": {
                    assertTrue("4 B", heavyHitter.getFrequency() == 4);
                    break;
                }
                case "C": {
                    assertTrue("5 C", heavyHitter.getFrequency() == 5);
                    break;
                }
                case "K": {
                    assertTrue("6 K", heavyHitter.getFrequency() == 6);
                    break;
                }
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullEvents() {
        topK.getTopK(null, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoEvents() {
        topK.getTopK(new ArrayList<>(), 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSufficientEvents() {
        topK.getTopK(Arrays.asList(new String[] { "A" }), 3);
    }

    @Test
    public void testSingleElement() {
        List<String> events = Arrays.asList(new String[] { "A" });
        List<HeavyHitter> heavyHitters = topK.getTopK(events, 1);
        assertTrue("There is 1 heavy hitters", heavyHitters.size() == 1);
        assertTrue("A", heavyHitters.get(0).getId() == "A");
        assertTrue("Only 1 A", heavyHitters.get(0).getFrequency() == 1);
    }
}

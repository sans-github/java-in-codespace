package com.app;

import org.junit.Before;
import org.junit.Test;
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
        List<String> events = Arrays.asList(new String[]{
            "A", "A", "A", 
            "B", "B", "B", "B",
            "K", "K", "K", "K", "K", "K", 
            "C", "C", "C", "C", "C", 
            "Y"
        });
        List<HeavyHitter> heavyHitters = topK.getTopK(events, 3);
        assertTrue("There are 3 heavy hitters", heavyHitters.size() == 3);

        for(HeavyHitter heavyHitter : heavyHitters) {
            switch (heavyHitter.getId()) {
                case "B" : {
                    assertTrue("4 B", heavyHitter.getFrequency()==4);
                    break;
                }
                case "C" : {
                    assertTrue("5 C", heavyHitter.getFrequency()==5);
                    break;
                }
                case "K" : {
                    assertTrue("6 K", heavyHitter.getFrequency()==6);
                    break;
                }
            } 
        }
    }
}

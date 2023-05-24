package com.app;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

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
        // for(HeavyHitter heavyHitter : heavyHitters) {
        //     System.out.printf("%s - %d\n", heavyHitter.getId(), heavyHitter.getFrequency());
        // }
        
        // System.out.println();
    }
}

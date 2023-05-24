package com.app;

import java.util.Comparator;

public class HeavyHitterComparator implements Comparator<HeavyHitter> {

    @Override
    public int compare(HeavyHitter o1, HeavyHitter o2) {
        if (o1.getFrequency() < o2.getFrequency()) {
            return 1;
        } else if (o1.getFrequency() > o2.getFrequency()) {
            return -1;
        } else {
            return 0;
        }
    }

}

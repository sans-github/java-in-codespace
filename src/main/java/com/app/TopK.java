package com.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class TopK {
    public List<HeavyHitter> getTopK(List<String> events, Integer k) {
        Map<String, Integer> map = new Hashtable<String, Integer>();

        for (String event : events) {
            map.put(event, map.getOrDefault(event, 0) + 1);
        }

        PriorityQueue<HeavyHitter> queue = new PriorityQueue<HeavyHitter>(Comparator.comparing(e->e.getFrequency()));

        final Set<Entry<String, Integer>> entrySet = map.entrySet();

        for (Entry<String, Integer> entry : entrySet) {
            queue.add(new HeavyHitter(entry.getKey(), entry.getValue()));
            if(queue.size()>k) {
                queue.poll();
            }
        }

        List<HeavyHitter> list = new ArrayList<>(k);

        queue.forEach(t -> list.add(t));
        return list;
    }
}

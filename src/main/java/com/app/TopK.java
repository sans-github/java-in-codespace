package com.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class TopK {
    public List<HeavyHitter> getTopK(List<String> events, Integer k) {
        if (events == null || events.isEmpty()) {
            throw new IllegalArgumentException("events cannot be empty");
        }

        if (k > events.size()) {
            throw new IllegalArgumentException("No sufficient events");
        }

        Map<String, Integer> map = new Hashtable<String, Integer>();

        for (String event : events) {
            map.put(event, map.getOrDefault(event, 0) + 1);
        }

        PriorityQueue<HeavyHitter> queue = addTopEventsToQueue(map, k);
        return createListOfQueueElements(queue);
    }

    private PriorityQueue<HeavyHitter> addTopEventsToQueue(Map<String, Integer> map, Integer k) {
        PriorityQueue<HeavyHitter> queue = new PriorityQueue<HeavyHitter>(Comparator.comparing(e -> e.getFrequency()));

        final Set<Entry<String, Integer>> entrySet = map.entrySet();

        for (Entry<String, Integer> entry : entrySet) {
            queue.add(new HeavyHitter(entry.getKey(), entry.getValue()));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue;
    }

    private List<HeavyHitter> createListOfQueueElements(PriorityQueue<HeavyHitter> queue) {
        List<HeavyHitter> heavyHitters = new ArrayList<>();
        while (!queue.isEmpty()) {
            heavyHitters.add(queue.poll());
        }

        Collections.reverse(heavyHitters);
        return heavyHitters;
    }
}

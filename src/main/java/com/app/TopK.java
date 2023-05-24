package com.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Consumer;

public class TopK {
    public List<HeavyHitter> getTopK(List<String> events, Integer k) {
        Map<String, Integer> map = new Hashtable<String, Integer>();

        for (String event : events) {
            map.put(event, map.getOrDefault(event, 0) + 1);
        }

        PriorityQueue<HeavyHitter> queue = new PriorityQueue<HeavyHitter>(new HeavyHitterComparator());

        final Set<Entry<String, Integer>> entrySet = map.entrySet();

        for (Entry<String, Integer> entry : entrySet) {
            queue.add(new HeavyHitter(entry.getKey(), entry.getValue()));

            // HeavyHitter heavyHitter = queue.peek();
            // System.out.printf("%s - %d\n", heavyHitter.getId(),
            // heavyHitter.getFrequency());

            // if (queue.size() > k) {
            // queue.poll();
            // }

            showQueueElements(queue);
        }

        List<HeavyHitter> list = new ArrayList<>(k);

        queue.forEach(t -> list.add(t));
        return list;
    }

    private void showQueueElements(PriorityQueue<HeavyHitter> queue) {

        while(!queue.isEmpty()) {
            HeavyHitter heavyHitter = queue.poll();
            System.out.printf("%s - %d\n", heavyHitter.getId(), heavyHitter.getFrequency());
        }
    //     queue.forEach(new Consumer<HeavyHitter>() {

    //         @Override
    //         public void accept(HeavyHitter heavyHitter) {
    //             System.out.printf("%s - %d\n", heavyHitter.getId(), heavyHitter.getFrequency());
    //         }
            
    //     }
        
    //     );
    //     System.out.println("\n");
    
    // }
    }
}

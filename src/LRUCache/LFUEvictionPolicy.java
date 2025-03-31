package LRUCache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class LFUEvictionPolicy<K> implements EvictionPolicy<K> {
    private final Map<K, Integer> frequencyMap = new HashMap<>();

    public void keyAccessed(K key) {
        frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
    }

    public K evictKey() {
        K leastFrequentKey = null;
        int minFrequency = Integer.MAX_VALUE;

        for (Map.Entry<K, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() < minFrequency) {
                minFrequency = entry.getValue();
                leastFrequentKey = entry.getKey();
            }
        }
        return leastFrequentKey;
    }
}

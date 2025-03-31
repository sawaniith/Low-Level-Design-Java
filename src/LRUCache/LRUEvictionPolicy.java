package LRUCache;

import java.util.LinkedHashMap;

// LRU Eviction Policy
class LRUEvictionPolicy<K> implements EvictionPolicy<K> {
    private final LinkedHashMap<K, Boolean> accessOrderMap;

    public LRUEvictionPolicy() {
        this.accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
    }

    public void keyAccessed(K key) {
        accessOrderMap.put(key, true);
    }

    public K evictKey() {
        if (accessOrderMap.isEmpty()) return null;
        return accessOrderMap.keySet().iterator().next();
    }
}

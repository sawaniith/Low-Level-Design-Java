package LRUCache;

import java.util.concurrent.*;
import java.util.function.Supplier;


// Generic Cache Class
class GenericCache<K, V> {
    private final int capacity;
    private final boolean useTTL;
    private final long ttlMillis;
    private final ConcurrentHashMap<K, V> cache = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<K, Long> expiryMap = new ConcurrentHashMap<>();
    private final EvictionPolicy<K> evictionPolicy;
    private final ScheduledExecutorService cleaner;

    public GenericCache(int capacity, boolean useTTL, long ttlMillis, EvictionPolicy<K> evictionSupplier) {
        this.capacity = capacity;
        this.useTTL = useTTL;
        this.ttlMillis = ttlMillis;
        this.evictionPolicy = evictionSupplier;

        cleaner = Executors.newScheduledThreadPool(1);
        if (useTTL) {
            cleaner.scheduleAtFixedRate(() -> removeExpiredKeys(), ttlMillis / 2, ttlMillis / 2, TimeUnit.MILLISECONDS);
        }
    }

    public synchronized void put(K key, V value) {
        if (cache.size() >= capacity) {
            K evictedKey = evictionPolicy.evictKey();
            if (evictedKey != null) {
                cache.remove(evictedKey);
                expiryMap.remove(evictedKey);
            }
        }
        cache.put(key, value);
        evictionPolicy.keyAccessed(key);
        if (useTTL) expiryMap.put(key, System.currentTimeMillis() + ttlMillis);
    }

    public synchronized V get(K key) {
        if (useTTL && isExpired(key)) {
            remove(key);
            return null;
        }
        evictionPolicy.keyAccessed(key);
        return cache.get(key);
    }

    public synchronized void remove(K key) {
        cache.remove(key);
        expiryMap.remove(key);
    }

    private boolean isExpired(K key) {
        return expiryMap.getOrDefault(key, 0L) < System.currentTimeMillis();
    }

    private void removeExpiredKeys() {
        expiryMap.keySet().removeIf(this::isExpired);
        cache.keySet().removeIf(this::isExpired);
//        for(K k : expiryMap.keySet()){
//            if(isExpired(k)){
//                expiryMap.remove(k);
//            }
//        }
    }

    public void shutdown() {
        cleaner.shutdown();
    }

    public synchronized void display() {
        System.out.println(cache);
    }
}



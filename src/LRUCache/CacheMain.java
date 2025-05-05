package LRUCache;

// Testing Different Configurations
public class CacheMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Using LRU with TTL:");
        GenericCache<Integer, String> lruTtlCache = new GenericCache<>(3, true, 3000, new LRUEvictionPolicy<Integer>());
        lruTtlCache.put(1, "A");
        Thread.sleep(1000);
        lruTtlCache.put(2, "B");
        Thread.sleep(1000);
        lruTtlCache.put(3, "C");
        Thread.sleep(1000);
        lruTtlCache.get(1);
        Thread.sleep(1000);
        lruTtlCache.put(4, "f");
        Thread.sleep(4000); // TTL expiry
        lruTtlCache.display(); // Should be empty
        lruTtlCache.shutdown();

        System.out.println("\nUsing LFU without TTL:");
        GenericCache<Integer, String> lfuCache = new GenericCache<>(3, false, 0, new LFUEvictionPolicy<Integer>());
        lfuCache.put(1, "X");
        lfuCache.put(2, "Y");
        lfuCache.put(3, "Z");
        lfuCache.get(1);
        lfuCache.get(1);
        lfuCache.put(4, "W"); // Evicts LFU key
        lfuCache.display(); // Should not contain least used key
        lfuCache.shutdown();
    }
}

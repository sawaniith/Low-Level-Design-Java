package LRUCache;

interface EvictionPolicy<K> {
    void keyAccessed(K key);
    K evictKey();
}
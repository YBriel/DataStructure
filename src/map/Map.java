package map;

/**
 * 映射的接口
 * yuzq
 * 2018.12.18
 * @param <K>
 * @param <V>
 */
public interface Map<K,V> {
    void add(K key,V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key,V newValue);
    int getSize();
    boolean isEmpty();
}

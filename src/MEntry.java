import java.util.Map;

/**
 * Created by 1081_1 on 02.05.17.
 */

final class MEntry<K, V> implements Map.Entry<K, V> {
    private final K key;
    private V value;

    public MEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }
}


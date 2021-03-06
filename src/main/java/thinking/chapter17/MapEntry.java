package thinking.chapter17;

import java.util.Map;

/**
 * TODO
 *
 * @version: 1.0
 * @author: faraway
 * @date: 2021-04-26 10:53
 */

public class MapEntry<K,V> implements Map.Entry<K,V> {
    private K key;
    private V value;
    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key;}
    public V getValue() { return value;}
    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }
    public int hashCode() {
        return (key==null ? 0 : key.hashCode()) ^ (value==null ? 0 : value.hashCode());
    }
    public boolean equals(Object o) {
        if(!(o instanceof MapEntry)) { return false;}
        MapEntry me = (MapEntry)o;
        return
                (key==null ?
                        me.getKey() == null : key.equals(me.getKey())) &&
                        (value == null ?
                                me.getValue()==null : value.equals(me.getValue()));
    }
    public String toString() { return key + "=" + value;}
}

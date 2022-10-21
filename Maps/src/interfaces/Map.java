package interfaces;
/* 
@Author: mohammed.shalan 
@Date: 04-Sep-22
*/

import java.util.Iterator;
import java.util.Map.Entry;

public interface Map<K,V> {

    public int size();
    boolean isEmpty();
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    Iterator<K> keySet();
    Iterator<V> values();
    Iterator<Entry<K,V>> entrySet();
    
}

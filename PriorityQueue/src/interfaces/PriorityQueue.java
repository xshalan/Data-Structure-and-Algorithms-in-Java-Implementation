package interfaces;
/* 
@Author: mohammed.shalan 
@Date: 22-Aug-22
*/

public interface PriorityQueue<K,V> {
    int size();
    boolean isEmpty();
    Entry<K,V> insert(K key,V value);
    Entry<K,V> min();
    Entry<K,V> removeMin();

}

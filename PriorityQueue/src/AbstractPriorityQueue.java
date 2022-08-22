/*
@Author: mohammed.shalan 
@Date: 22-Aug-22
*/

import NodeBased.NodeBasedList;
import NodeBased.interfaces.PositionList;
import interfaces.Entry;
import interfaces.PriorityQueue;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
    private Comparator<K> comp;

    public AbstractPriorityQueue(Comparator<K> comp) {
        this.comp = comp;

    }

    public AbstractPriorityQueue() {
        this(new DefaultComparator<>());
    }

    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return comp.compare(key, key) == 0;
        } catch (ClassCastException exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    protected static class SimpleEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        public SimpleEntry() {
        }

        public SimpleEntry(K key, V value) {
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

        public void setKey(K key) {
            this.key = key;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}

/*
@Author: mohammed.shalan 
@Date: 22-Aug-22
*/

import NodeBased.NodeBasedList;
import NodeBased.interfaces.Position;
import NodeBased.interfaces.PositionList;
import interfaces.Entry;

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
    private int size;
    private PositionList<Entry<K,V>> list ;

    public SortedPriorityQueue() {
        super();
        size = 0;
        list = new NodeBasedList<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Entry<K, V> insert(K key, V value) {
        checkKey(key);
        Entry<K,V> entry = new SimpleEntry<>(key,value);
        Position<Entry<K,V>> position = null;
        if(!list.isEmpty()){
            position  = list.getLast();
            while (position!=null && compare(entry,position.element())<0){
                position = list.before(position);
            }
        }
        if (position==null)
            list.addFirst(entry);
        else
            list.addAfter(position,entry);


        return entry;
    }

    @Override
    public Entry<K, V> min() {
        if(!isEmpty())
            return list.getFirst().element();
        else
            return null;
    }

    @Override
    public Entry<K, V> removeMin() {
        if(!isEmpty())
            return list.remove(list.getFirst());
        else
            return null;
    }


}

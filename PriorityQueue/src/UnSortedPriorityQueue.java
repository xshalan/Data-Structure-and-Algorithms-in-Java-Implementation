/*
@Author: mohammed.shalan 
@Date: 22-Aug-22
*/

import NodeBased.DNode;
import NodeBased.NodeBasedList;
import NodeBased.interfaces.Position;
import NodeBased.interfaces.PositionList;
import interfaces.Entry;

import java.util.Iterator;

public class UnSortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>{
    private int size;
    private PositionList<Entry<K,V>> list ;
    public UnSortedPriorityQueue() {
        super();
        size = 0;
        list = new NodeBasedList<>();

    }

    public PositionList<Entry<K, V>> getList() {
        return list;
    }


    // ISSUE: I want to return Position<E> to pass it to list.remove(Position) but the iterator itself return the value Entry.
    // TODO: [x] Edit nodelist implementation to return position wrapper instead of the E itself.
    private Position<Entry<K,V>> findMin(){
        Position<Entry<K,V>> first = null;
        if (!isEmpty()){
            first = list.getFirst();
            for (Iterator<Position<Entry<K, V>>> it = list.iterator(); it.hasNext(); ) {
                Position<Entry<K, V>> position = it.next();
                if(compare(first.element(),position.element())<0){
                    first = position;
                }

            }
        }
        return first;
    }
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) {
        checkKey(key);
        Entry<K,V> entry = new SimpleEntry<>(key,value);
        list.addLast(entry);
        return entry;
    }

    @Override
    public Entry<K, V> min() {
        if(!isEmpty())
            return findMin().element();
        else
            return null;
    }

    @Override
    public Entry<K, V> removeMin() {
        if(!isEmpty()){
            return list.remove(findMin());
        }
        else
            return null;
    }
}

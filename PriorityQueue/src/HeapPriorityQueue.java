/*
@Author: mohammed.shalan 
@Date: 25-Aug-22
*/

import NodeBased.exceptions.EmptyListException;
import interfaces.Entry;

import java.util.ArrayList;

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    private ArrayList<Entry<K, V>> heap;

    public HeapPriorityQueue() {
        super();
        this.heap = new ArrayList<>();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) {
        Entry<K, V> entry = new SimpleEntry<>(key, value);
        heap.add(entry);
        heapify();
        return entry;
    }

    public Entry<K, V> insert(Entry<K, V> entry) {
        heap.add(entry);
        heapify();
        return entry;
    }

    @Override
    public Entry<K, V> min() {
        if (heap.isEmpty())
            throw new EmptyListException("The heap is empty!");
        return heap.get(0);
    }

    @Override
    public Entry<K, V> removeMin() {
        if (heap.isEmpty())
            throw new EmptyListException("The heap is empty!");
        Entry<K, V> min = heap.get(0);
        swap(0,size()-1);
        heap.remove(size()-1);
        heapifyDown();
        return min;
    }

    protected int parent(int idx) {
        return (idx - 1) / 2;
    }

    protected int left(int idx) {
        return 2 * idx + 1;
    }

    protected int right(int idx) {
        return 2 * idx + 2;
    }

    protected boolean hasLeft(int idx) {
        return left(idx) < heap.size();
    }

    protected boolean hasRight(int idx) {
        return right(idx) < heap.size();
    }

    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    protected void heapify() {
        int last_index = heap.size()-1;
        while (last_index>0){
            if(compare(heap.get(parent(last_index)), heap.get(last_index))>0){
                swap(parent(last_index),last_index);
            }
            last_index = parent(last_index);
        }
    }

    protected void heapifyDown() {
        int start_index =0;
        while (hasLeft(start_index)){
            int smaller_index = left(start_index);
            if(hasRight(start_index) && compare(heap.get(right(start_index)),heap.get(smaller_index))<0){
                smaller_index = right(start_index);
            }

            if(compare(heap.get(smaller_index),heap.get(start_index))<0){
                swap(smaller_index,start_index);
            }
            start_index = smaller_index;
        }
    }
}

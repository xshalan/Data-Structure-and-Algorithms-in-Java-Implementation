/*
@Author: mohammed.shalan 
@Date: 22-Aug-22
*/

import NodeBased.interfaces.Position;
import interfaces.Entry;
import interfaces.PriorityQueue;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

public class main {
    public static void main(String[] args) {
        UnSortedPriorityQueue<Integer,String> unsortedQueue = new UnSortedPriorityQueue<>();
        SortedPriorityQueue<Integer,String> sortedQueue = new SortedPriorityQueue<>();
        unsortedQueue.insert(1,"First element");
        unsortedQueue.insert(2,"second element");
        unsortedQueue.insert(0,"Zero element");
        unsortedQueue.insert(4,"Fourth element");

        sortedQueue.insert(1,"First element");
        sortedQueue.insert(2,"second element");
        sortedQueue.insert(3,"Third element");
        sortedQueue.insert(0,"Zero element");
        sortedQueue.insert(-1,"negative element");

//        System.out.println(unsortedQueue.min().getValue());
//        Entry<Integer,String> min = sortedQueue.min();
//        System.out.println(min.getValue());
        System.out.println("Unsorted queue: ");
        for(Position<Entry<Integer,String>> entry:unsortedQueue.getList()){
            System.out.println("key: "+entry.element().getKey() + "  Value: " + entry.element().getValue());
        }
        System.out.println("Sorted queue: ");
        for(Position<Entry<Integer,String>> entry:sortedQueue.getList()){
            System.out.println("key: "+entry.element().getKey() + "  Value: " + entry.element().getValue());
        }
        System.out.println("unsortedQueue : " +unsortedQueue.min().getValue());
        System.out.println("sortedQueue : "+sortedQueue.min().getValue());

    }
}

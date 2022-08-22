/*
@Author: mohammed.shalan 
@Date: 22-Aug-22
*/

import interfaces.Entry;
import interfaces.PriorityQueue;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Queue;

public class main {
    public static void main(String[] args) {
        PriorityQueue<Integer,String> unsortedQueue = new UnSortedPriorityQueue<>();
        PriorityQueue<Integer,String> sortedQueue = new SortedPriorityQueue<>();
        unsortedQueue.insert(1,"First element");
        unsortedQueue.insert(2,"second element");
        unsortedQueue.insert(3,"Third element");
        unsortedQueue.insert(0,"Zero element");

        /////

        sortedQueue.insert(1,"First element");
        sortedQueue.insert(2,"second element");
        sortedQueue.insert(3,"Third element");
        sortedQueue.insert(0,"Zero element");

        System.out.println(unsortedQueue.min().getValue());


    }
}

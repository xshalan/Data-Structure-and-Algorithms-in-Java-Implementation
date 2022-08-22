/*
@Author: mohammed.shalan 
@Date: 22-Aug-22
*/

import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E>  {


    @Override
    public int compare(E o1, E o2) throws ClassCastException{
        return ((Comparable<E>)o1).compareTo(o2);
    }
}

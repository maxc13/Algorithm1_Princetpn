/**
 * Created by caingmico on 06/07/2017.
 */
public interface Iterable<Item>
{
    Iterator<Item> iterator;
}


public interface Iterator<Item>
{
    boolean hasNext();
    Item next();
    //optional
    void remove();
}
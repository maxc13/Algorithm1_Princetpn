import java.util.Iterator;
/**
 * Created by caingmico on 05/07/2017.
 */
public class Stack<Item> implements Iterable<Item>
{
    /** implement a stack data structure
     *  using linked list to store data with generic
     *  contains push, pop method and fulfill LIFO
     */

    /** define linked list data structure
     */

    public Iterator<Item> iterator() { return new ListIterator(); }

    private class ListIterator<Item> implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext()
        {   return current != null;   }

        public void remove() { /* not suppoted */   }

        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private Node first = null;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty()
    {   return first == null;   }

    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        return item;
    }
}

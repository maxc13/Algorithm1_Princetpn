/**
 * Created by caingmico on 06/07/2017.
 */
public class QueueOfStrings
{
    private int size = 0;
    private Node first, last;

    private class Node
    {
        String item;
        Node next;
    }
    public void QueueOfStrings()
    {
        first.item = null;
        first.next = null;
    }

    public void enqueue(String item)
    {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        size += 1;
    }

    public String dequeue()
    {
        String item = first.item;
        first = first.next;
        size -= 1;
        if (isEmpty())   last = null;
        return item;
    }

    public boolean isEmpty()
    {   return first == null;   }

    public int size()
    {   return size;   }
}

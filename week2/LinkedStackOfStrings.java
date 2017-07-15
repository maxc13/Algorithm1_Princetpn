/**
 * Created by caingmico on 05/07/2017.
 */
public class LinkedStackOfStrings
{
    /** implement a stack data structure
     *  using linked list to store data
     *  contains push, pop method and fulfill LIFO
     */

    /** define linked list data structure
     */

    private Node first = null;

    private class Node
    {
        String item;
        Node next;
    }

    public boolean isEmpty()
    {   return first == null;   }

    public void push(String item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    public String pop()
    {
        String item = first.item;
        first = first.next;
        return item;
    }
}

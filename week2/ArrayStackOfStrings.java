/**
 * Created by caingmico on 06/07/2017.
 */
public class ArrayStackOfStrings
{
    /** Using array data structure to implement Stack.
     *  contains pop, push method.
     */

    private String[] stack;
    private int size = 0;

    public void ArrayStackOfStrings(int capacity)
    {   stack = new String[capacity];   }

    public boolean isEmpty()
    {   return size == 0;   }

    public void push(String item)
    {
        //stack[size] = item;
        //size = size + 1;
        stack[size++] = item; //index to the array, then increment size
    }

    public String pop()
    {

        String item = stack[--size];
        stack[size] = null;
        return item;
        //return stack[--size];
        /** the -- operation :decrement size, then use to index array, but LOITERING.
         *  reassign the unused reference to null;
         */

    }

    public int size()
    {   return this.size;   }

}

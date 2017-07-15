/**
 * Created by caingmico on 13/07/2017.
 */
public class HeapSort
{
    /** implement sort using binary heap structure */

    public void sort(Comparable[] pq)
    {
        int N = pq.length;
        // construct heap array
        for (int k = N/2; k >= 1; k--)
            sink(pq, k, N);
        // sort by "remove" largest item one by one
        while (N > 1)
        {
            exch(pq, 1, N);
            sink(pq, 1, --N);
        }
    }

    private boolean less(Comparable[] a, int i, int j)
    {    return a[i].compareTo(a[j]) < 0;    }
    private void sink(Comparable[] a, int k, int N)
    {
        while ( 2*k <= N)
        {
            int j = 2 * k;
            if (j < N && less(a, j, j+1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }
    private void exch(Comparable[] a, int i, int j)
    {
        Comparable k = a[i];
        a[i] = a[j];
        a[j] = k;
    }


}

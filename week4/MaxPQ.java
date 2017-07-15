/**
 * Created by caingmico on 13/07/2017.
 */
public class MaxPQ<Key extends Comparable<Key>>
{
    /** implement Max Priority Queue using binary heap */

    private Key[] pq;
    private int N;

    public void Maxpq(int capacity)
    {    pq = (Key[]) new Comparable[capacity+1];    }
    // pq index start from 1, so initialize pq with one more entry

    public boolean isEmpty()
    {    return N == 0;    }

    public void insert(Key key)
    {
        pq[++N] = key; // be careful about ++N, pq effect index from 1
        swim(N);
    }

    public Key delMax()
    {
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }

    private void swim(int i)
    {
        while (i >= 1)
        {
            if (less(i/2, i))
            {
                exch(i, i/2);
                i = i / 2;
            }
            else break;
        }
    }
    private void sink(int j)
    {
        while (2*j <= N)
        {
            int k = 2 * j;
            if (k < N && less(k, k+1)) k++;
            if (less(k, j)) break;
            exch(j, k);
            j = k;
        }
    }

    private boolean less(int i, int j)
    {    return pq[i].compareTo(pq[j]) < 0;    }
    private void exch(int i, int j)
    {
        Key swap = pq[j];
        pq[j] = pq[i];
        pq[i] = swap;
    }

}

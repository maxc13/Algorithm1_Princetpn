/**
 * Created by caingmico on 13/07/2017.
 */
public class UnorderedMaxPQ<Key extends Comparable<Key>> {

    /** implement unordered Max Priority Queue using array */
    private Key[] pq;    // pq[i] = ith element of pq
    private int N;       // number of elements in pq

    public void UnorderedMaxPQ(int capacity)
    {    pq = (Key[]) new Comparable[capacity];   }

    public boolean isEmpty()
    {    return N == 0;    }

    public void insert(Key x)
    {    pq[N++] = x;    }

    public Key delMax()
    {
        int max = 0;
        for (int i = 1; i < N; i++)
            if (pq[i] > pq[max]) max = i;
        exch(pq, max, N-1);
        return pq[N--];
    }

    private void exch(Key[] a, int i, int j)
    {
        Key swap = a[j];
        a[j] = a[i];
        a[i] = swap;
    }
}

/**
 * Created by caingmico on 09/07/2017.
 */
public class MergeBU
{
    /** implement sort using Bottop-Up Merge sort algorithm */

    private static Comparable[] aux;

    public static void merge(Comparable[] a, int lo, int mid, int hi)
    {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);
        aux = new Comparable[hi - lo + 1]
        for (int i = lo; i <= hi; i ++)
            aux[i] = a[i];

        int i = lo, j = mid;
        for (int k = lo; k <= hi; k++)
        {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else                           a[k] = aux[j++];
        }

        assert isSorted(a, lo, hi);
    }

    public static void sort(Comparable[] a)
    {
        int N = a.length;
        aux = new Comparable[N]
        for (int sz = 1; sz < N; sz = sz + sz)
        {
            for (int i = 0; i < N - sz; i = i + sz + sz)
                merge(a, i, i + sz - 1 , Math.min(i+sz+sz-1, N-1));
        }
    }
}

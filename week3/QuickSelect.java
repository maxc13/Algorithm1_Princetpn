/**
 * Created by caingmico on 10/07/2017.
 */
public class QuickSelect
{
    /** implement select using partition algorithm */

    public static int select(Comparable[] a, int k)
    {
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo)
        {
            int j = partition(a, lo, hi);
            if      (j > k) hi = j - 1;
            else if (j < k) lo = j + 1;
            else            return a[k];
        }
        return a[k];
    }

    public static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi + 1;
        while (true)
        {
            while (less(a[++i], a[lo]))
                if (i == hi) break;
            while (less(a[lo], a[--j]))
                if (j == lo) break;

            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
}

/**
 * Created by caingmico on 10/07/2017.
 */
public class QuickSort
{
    /** implement sort using quick sort algorithms */

    public static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi + 1; 
        /* convenient to use ++i and --j operation */

        while (true)
        {
            while (less(a[++i], a[lo])) 
            /* find item left large than a[lo] */
                if (i == hi) break;

            while (less(a[lo], a[--j])) 
            /* find item right less than a[lo] */
                if (j == lo) break;

            if (i >= j) break; // check if pointer crossed
            exch(a, i, j);
            /** exchange a[i] and a[j], 
             *  to make left items less and right items large
             */ 
        }
        exch(a, lo, j); // swap with partitioning item
        return j; // return index of item now known to be in place
    }

    private static void sort(Comparable[] a, int lo, int hi) 
    // no duplicate keys
    {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);// sort a[lo:j-1] recursively
        sort(a, j+1, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi) 
    // has duplicate keys
    {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        while (i <= gt)
        {
            int cmp = a[i].compareTo(v);
            /** every time only compare a[i] with selected v, 
             *  simply quick sort */

            if      (cmp < 0) exch(a, i++, lt++);
            // less, excahge a[i] to the left part
            else if (cmp > 0) exch(a, i, gt--);
            //greater, exchange a[i] to the gt part and decarease gt
            else              i++;
            //equal, increase i
        }

        sort(a, lo, lt-1);
        sort(a, gt+1, hi);

    }

    public static void sort(Comparable[] a)
    {
        StdRandom.shuffle(a); // shuffle needed to guarantee performance
        sort(a, 0, a.length - 1);
    }
}

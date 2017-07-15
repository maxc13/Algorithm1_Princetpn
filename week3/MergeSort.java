/**
 * Created by caingmico on 09/07/2017.
 */
public class MergeSort
{
    /** implement sort using mergesort algorithm */

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        for (int i = lo; i <= hi; i++) // copy a to aux.
            aux[i] = a[i];

        int i = lo, j = mid + 1; //merge aux to a.
        for (int k = 0; k <= hi; k++)
        {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else                           a[k] = aux[j++];
        }

        assert isSorted(a, lo, hi);  //post condition: a[lo:hi] is sorted
    }

    // Using recursion to implement merge sort
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
    {
        if (hi < lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        if (less(a[mid], a[mid+1])) return; // stop if the sub-array already sorted
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi)
    {
        for (int i = lo; i < hi; i++)
            if (less(a[i+1], a[i])) return false;
        return true;
    }
}

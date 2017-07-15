/**
 * Created by caingmico on 07/07/2017.
 */
public class SelectionSort
{
    /** implement sort function using selection sort */

    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int min = i;
            for (int j = i + 1; j < N; j++)
            {
                if (less(a[j], a[i]))
                    min = j;
            }
            swap(a, min, i);
        }
    }

    private static void swap(Comparable[] a, int i, int j)
    {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(Comparable a, Comparable b)
    { return a.compareTo(b) < 0; }
}

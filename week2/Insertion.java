/**
 * Created by caingmico on 09/07/2017.
 */
public class Insertion
{
    /** implement sort using insertion mechanism */

    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 1; i < N; i++)
        {
            for (int j = i - 1; j >= 0; j--)
            {
                if (less(a[i], a[j]))
                    exch(a, i, j);
                else break;
            }
        }
    }


}

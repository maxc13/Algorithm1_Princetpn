/**
 * Created by caingmico on 29/06/2017.
 */
public class QuickFindUF {

    private int[] id;
    private int[] sz;
    //Initialize QuickFindUF
    public QuickFindUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i =0; i < N; i ++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // find the root of entry i, using tree-like structure
    private int root(int i)
    {
        while (id[i] != i)
        {
            id[i] = id[id[i]];//improve the structure after each root search
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q)
    {
        return root(p) == root(q)
    }

    //change root of p point to root of q
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    //change root of p and q, to make a small size tree
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else               { id[j] = i; sz[i] += sz[j]; }
    }
    // change all entries with id[p] to id[q]
    public void uninon(int p, int q) {
       int pid = id[p];
       int qid = id[q];
       for (int i = 0; i < id.length; i ++) {
           if (id[i] == pid) id[i] = qid;
       }
    }
}

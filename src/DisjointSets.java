/**
 * Created by shuffleres on 5/1/2015.
 */
public class DisjointSets {
    private int[] set;

    public DisjointSets(int num)
    {
        set = new int[num];
        for (int i = 0; i < set.length; i++)
        {
            set[i] = -1;
        }
    }

    public void union(int setOne, int setTwo)
    {
        set[setTwo] = setOne;
    }

    public int find(int x)
    {
        if (set[x] < 0)
        {
            return x;
        }
        else {
            return find(set[x]);
        }
    }

}

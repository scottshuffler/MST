/**
 * Created by shuffleres on 5/1/2015.
 * Scott Shuffler
 * Devin Sink
 */

//DisjointSet class found on page 335-336 of the text book
//Data Structures and algorithm analysis in java -- third edition
public class DisjointSets {
    private int[] set;

    //Constructor for DisjointSet
    //Creates the blank array filled with -1
    public DisjointSets(int num)
    {
        set = new int[num];
        for (int i = 0; i < set.length; i++)
        {
            set[i] = -1;
        }
    }

    //Union of the two given params
    public void union(int setOne, int setTwo)
    {
        set[setTwo] = setOne;
    }

    //Finds the specified element and returns
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

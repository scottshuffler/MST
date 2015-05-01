/**
 * Created by shuffleres on 5/1/2015.
 */


public class Edge  implements Comparable<Edge>{
    private int i;
    private int j;
    private int weight;

    public Edge(int i, int j, int weight)
    {
        setI(i);
        setJ(j);
        setWeight(weight);
    }

    public int getI()
    {
        return i;
    }

    public void setI(int i)
    {
        this.i = i;
    }

    public int getJ()
    {
        return j;
    }

    public void setJ(int j)
    {
        this.j = j;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public int compareTo(Edge e)
    {
        return this.getWeight() - e.getWeight();
    }
}

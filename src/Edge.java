/**
 * Created by shuffleres on 5/1/2015.
 * Scott Shuffler
 * Devin Sink
 */

//Edge class
//Creates the edges and weights
public class Edge  implements Comparable<Edge>{
    private int i;
    private int j;
    private int weight;

    //Constructor for Edge
    //Sets the given variables to the correct field
    public Edge(int i, int j, int weight)
    {
        setI(i);
        setJ(j);
        setWeight(weight);
    }

    //Getter for i
    public int getI()
    {
        return i;
    }

    //Setter for i
    public void setI(int i)
    {
        this.i = i;
    }

    //Getter for j
    public int getJ()
    {
        return j;
    }

    //Setter for j
    public void setJ(int j)
    {
        this.j = j;
    }

    //Getter for weight
    public int getWeight()
    {
        return weight;
    }

    //Setter for weight
    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    //CompareTo method
    //Checks the difference between the current Edge and a given edge
    public int compareTo(Edge e)
    {
        return this.getWeight() - e.getWeight();
    }
}

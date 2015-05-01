import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by shuffleres on 5/1/2015.
 * Scott Shuffler
 * Devin Sink
 */
public class MST {

    //Main method
    //Makes a file object for graph1.dat
    //Inits i, j, weight, numEdge, numVert, mst, and edge
    //Creates a new Arraylist of Edges, Edges are populated with the i, j, and weight from file
    public static void main(String[] args) {
        File file = new File("graph1.dat");
        int i = 0;
        int j = 0;
        int weight = 0;
        int numEdge = 0;
        int numVert = 0;
        Edge edge;
        MST mst = new MST();
        ArrayList<Edge> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            numEdge = scanner.nextInt();
            numVert = scanner.nextInt();
            //Parses file and sets appropriate variable
            while (scanner.hasNextInt()) {
                for (int count = 0; count < 3; count++) {
                    if (count == 0) {
                        i = scanner.nextInt();
                    } else if (count == 1) {
                        j = scanner.nextInt();
                    } else {
                        weight = scanner.nextInt();
                    }
                }
                //Creates the edge for the 3 variables and adds to list
                edge = new Edge(i, j, weight);
                list.add(edge);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Creates a temp array list that is populated by the return result of kruskals
        //Prints the weights of the selected edges
        ArrayList<Edge> temp = mst.kruskal(list, numVert);
        for (int ij = 0; ij < temp.size(); ij++) {
            System.out.print(temp.get(ij).getWeight());
            System.out.print(" ");
        }
    }

    //Kruskals algorithm found on page 399 of the text book
    //Data Structures and algorithm analysis in java -- third edition
    ArrayList<Edge> kruskal( List<Edge> edges, int numVertices )
    {
        DisjointSets ds = new DisjointSets( numVertices );
        PriorityQueue<Edge> pq = new PriorityQueue<>( edges );
        ArrayList<Edge> mst = new ArrayList<>( );
        while( mst.size() != numVertices - 1 )
        {
            Edge e = pq.poll(); // Edge e = (u, v)
            if (e != null) {
                int uset = ds.find(e.getI());
                int vset = ds.find(e.getJ());
                if (uset != vset) {
                    mst.add(e);
                    ds.union(uset, vset);
                }
            }
            else
            {
                break;
            }
        }
        return mst;
    }
}

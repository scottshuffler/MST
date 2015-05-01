import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by shuffleres on 5/1/2015.
 */
public class MST {

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
            while (scanner.hasNextInt()) {
                for (int count = 0; count < 3; count++) {
                    if (count == 0){
                        i = scanner.nextInt();
                    }
                    else if(count == 1) {
                        j = scanner.nextInt();
                    }
                    else {
                        weight = scanner.nextInt();
                    }
                }
                edge = new Edge(i,j,weight);
                System.out.println("i: "+edge.getI()+" j: "+edge.getJ()+" w: "+edge.getWeight());
                list.add(edge);
            }
            System.out.println("Number of edges"+numEdge);
            System.out.println("Number of vertices: " + numVert);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Edge> temp = mst.kruskal(list, numVert);
        for (int ij = 0; ij < temp.size(); ij++) {
            System.out.println(temp.get(ij).getWeight());
        }
    }

    ArrayList<Edge> kruskal( List<Edge> edges, int numVertices )
    {
        DisjointSets ds = new DisjointSets( numVertices );
        PriorityQueue<Edge> pq = new PriorityQueue<>( edges );
        ArrayList<Edge> mst = new ArrayList<>( );
        while( mst.size() != numVertices - 1 )
        {
            Edge e = pq.poll(); // Edge e = (u, v)
            if (e != null) {
                System.out.println("NO NULL");
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

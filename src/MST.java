import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by shuffleres on 5/1/2015.
 */
public class MST {
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

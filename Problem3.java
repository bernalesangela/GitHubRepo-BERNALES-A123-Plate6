import java.util.*;

public class Problem3 {
    private int V;
    private LinkedList<Integer> adj[];

    Problem3 (int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v,int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
    boolean isCyclic(int v, boolean visited[], int parent) {
        visited[v] = true;
        for (int i : adj[v]) {
            if (!visited[i]) {
                if (isCyclic(i, visited, v))
                    return true;
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }
    boolean hasCycle() {
        boolean visited[] = new boolean[V];
        for (int i=0; i<V; ++i)
            if (!visited[i])
                if (isCyclic(i, visited, -1))
                    return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println("\nCycle of a Graph : Problem #3 \n [BERNALES, ANGELA NAREEN F.]\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the number of vertices in the graph: ");
        int n = Integer.parseInt(sc.nextLine());
    
        System.out.print("Input the number of edges in the graph: ");
        int m = Integer.parseInt(sc.nextLine());
    
        Problem3 g = new Problem3 (n);

        System.out.println("Input nodes less than " + (n) + ". (Example: n n).");
        for (int i = 0; i < m; i++) {
            System.out.print("Edge " + (i+1) + ": ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u,v);
        }
        sc.close();
        
        if (g.hasCycle())
            System.out.println("The graph has a cycle.");
        else
            System.out.println("The graph does not have a cycle.");
    }
}
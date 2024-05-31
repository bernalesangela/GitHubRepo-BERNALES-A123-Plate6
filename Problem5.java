import java.util.*;

public class Problem5 {
    private static final ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static int[] color;

    public static void main(String[] args) {
        int u, v, n, m;

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n The Bipartite Graph : Problem #5 \n [BERNALES, ANGELA NAREEN F.]\n");
        System.out.print("Input the number of vertices in the graph: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        System.out.print("Input the number of edges in the graph: ");
        m = scanner.nextInt();

        System.out.println("Input nodes less than " + (m) + ". (Example: n n).");
        for (int i = 0; i < m; i++) {
            u = scanner.nextInt();
            v = scanner.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        scanner.close();

        // Initialize the color array
        color = new int[n];
        Arrays.fill(color, -1);

        // Check if the graph is bipartite
        if (isBipartite(n)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }

    private static boolean dfs(int u, int c) {
        color[u] = c;
        for (int v : adj.get(u)) {
            if (color[v] == -1) { // if no color has been assigned to the vertex
                if (!dfs(v, 1 - c)) { // if neighbor 'v' has not been visited before
                    return false;
                }
            } else if (color[v] == c) { // if 'v' is in the same color/set as 'u'
                return false;
            }
        }
        return true;
    } // end of dfs method

    private static boolean isBipartite(int n) {
        // Perform DFS on each connected component of the graph
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) { // if no color has been assigned to the vertex
                if (!dfs(i, 0)) {
                    return false;
                }
            }
        }
        return true;
    } // end of isBipartite method
}
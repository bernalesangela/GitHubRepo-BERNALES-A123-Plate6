import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n The Adjacency Matrix of a Graph : Problem #6 \n [BERNALES, ANGELA NAREEN F.]\n");
        int n = 0;
        int m = -1;

        System.out.print("Input the number of vertices in the graph: ");
        n = sc.nextInt();

        System.out.print("Input the number of edges in the graph: ");
        m = sc.nextInt();

        // Construct the adjacency matrix
        int[][] adjMatrix = new int[n][n];

        // Accept vertex pairs
        for (int i = 0; i < m; i++) {
            System.out.print("Vertex pair for Edge " + (i + 1) + ": ");
            int u = sc.nextInt();
            int v = sc.nextInt();

            System.out.print("Is the edge Directed? (y/n): ");
            String isDirected = sc.next().toLowerCase();
            if (isDirected.equals("y")) {
                adjMatrix[u][v]++;
            } else if (isDirected.equals("n")) {
                adjMatrix[u][v]++;
                adjMatrix[v][u]++;
            } else {
                System.out.println("Invalid input. Please enter either y or n.");
                i--;
            }
        }
        sc.close();

        // Print the adjacency matrix
        System.out.println("Adjacency Matrix of the Graph:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Problem4 {

    private static final ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static final ArrayList<String> strAdj = new ArrayList<>();

    public static void main(String[] args) {
        int u, v, n, m, size, total = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nThe Degree of a Vertex in an Undirected Graph : Problem #4 \n [BERNALES, ANGELA NAREEN F.]\n");
        System.out.print("Input the number of vertices in the graph: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.print("Input the number of edges in the graph: ");
        m = scanner.nextInt();

        System.out.println("Input nodes less than " + (m) + ". (Example: n n).");
        for (int i = 0; i < m; i++) {
            System.out.print("Edge " + (i+1) + ": ");
            u = scanner.nextInt();
            v = scanner.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        scanner.close();

        // Compute and display degrees per vertex
        for (int i = 0; i < n; i++) {
            size = adj.get(i).size(); // gets no. of adjacent vertices for every vertex i
            total += size; // computes total degrees
            System.out.println("deg(" + i + "): " + size); // degrees per vertex
        }
        System.out.println("\nTotal Degree of Graph: " + total); // total degrees
    }
}
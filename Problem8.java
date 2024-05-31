import java.util.Scanner;

public class Problem8 {
    private static int[][] adj1, adj2;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nThe Graph Isomorphism : Problem #8\n[BERNALES, ANGELA NAREEN F.]\n");

        // Get the number of vertices
        System.out.print("Enter the number of vertices in the graphs: ");
        n = scanner.nextInt();

        // Create adjacency matrices for the 2 graphs
        adj1 = new int[n][n];
        adj2 = new int[n][n];

        // Get the edges of the first graph
        System.out.println("Enter the edges of the 1st graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
        readEdges(adj1, scanner);

        // Get the edges of the second graph
        System.out.println("Enter the edges of the 2nd graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
        readEdges(adj2, scanner);

        scanner.close();

        // Check if the graphs are isomorphic
        if (isIsomorphic()) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    }

    private static void readEdges(int[][] adj, Scanner scanner) {
        int u, v;
        while (true) {
            u = scanner.nextInt();
            v = scanner.nextInt();
            if (u == -1 && v == -1) break;
            if (u < 0 || u >= n || v < 0 || v >= n) {
                System.out.println("Invalid vertex number. Vertex numbers must be between 0 and " + (n-1) + ".");
            } else {
                adj[u][v]++;
                adj[v][u]++;
            }
        }
    }

    private static boolean isIsomorphic() {
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
        }
        return isIsomorphic(permutation, 0);
    }

    private static boolean isIsomorphic(int[] permutation, int index) {
        if (index == n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adj1[i][j] != adj2[permutation[i]][permutation[j]]) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            for (int i = index; i < n; i++) {
                swap(permutation, index, i);
                if (isIsomorphic(permutation, index + 1)) {
                    return true;
                }
                swap(permutation, index, i);
            }
            return false;
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
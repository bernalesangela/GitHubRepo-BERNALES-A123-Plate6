import java.util.*;

public class Problem1 {
    public static void main(String args[]) {
        System.out.println("\nConnectivity of a Simple Graph : Problem #1 \n [BERNALES, ANGELA NAREEN F.]\n");

        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of vertices in the graph: ");
        int vert = sc.nextInt();
        System.out.print("Input number of edges in the graph: ");
        int edges = sc.nextInt();

        int[][] arr = new int[edges][2];

        System.out.println("Input nodes less than " + (edges) + ". (Example: n,n). ");
        for (int i = 0; i < edges; i++) {
            System.out.println("Edge " + (i + 1) + ": ");
            int x = sc.nextInt();
            int n = sc.nextInt();
            arr[i][0] = x;
            arr[i][1] = n;
        }

        int connectedComponents = 0;
        boolean[] visited = new boolean[vert];

        for (int v = 0; v < vert; v++) {
            if (!visited[v]) {
                dfs(arr, visited, v);
                connectedComponents++;
            }
        }

        if (connectedComponents == 1) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected. It has " + connectedComponents + " connected components.");
        }
    }

    public static void dfs(int[][] arr, boolean[] visited, int vertex) {
        visited[vertex] = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == vertex && !visited[arr[i][1]]) {
                dfs(arr, visited, arr[i][1]);
            } else if (arr[i][1] == vertex && !visited[arr[i][0]]) {
                dfs(arr, visited, arr[i][0]);
            }
        }
    }
}
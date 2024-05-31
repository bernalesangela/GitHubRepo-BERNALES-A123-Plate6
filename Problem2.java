import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        System.out.println("\nThe Edges of a Graph via Adjacency Matrix : Problem #2 \n [BERNALES, ANGELA NAREEN F.]\n");
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the number of vertices in the graph: ");
        int vert = sc.nextInt();
        
        int[][] adjMatrix = new int[vert][vert];
        Map<String, Integer> edgeCount = new LinkedHashMap<>();

        System.out.println("Input the adjacency matrix of the graph:");
        for (int i = 0; i < vert; i++) {
            for (int j = 0; j < vert; j++) {
                adjMatrix[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < vert; i++) {
            for (int j = i; j < vert; j++) {
                if (adjMatrix[i][j] > 0) {
                    String edge = "Edge " + i + " , " + j;
                    edgeCount.put(edge, adjMatrix[i][j]);
                }
            }
        }
        System.out.println("Number of times each edge appears: ");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
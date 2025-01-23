import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {

    public static void dfs(List<List<Integer>> list, int[] visited, List<Integer> path) {
        for(int neighbour: list.get(path.get(path.size()-1))) {
            if(visited[neighbour]!=1) {
                visited[neighbour] = 1;
                path.add(neighbour);
                dfs(list, visited, path);
            }
        }
    }

    public static List<Integer> dfsTraversal(int V, int[][] edges) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=V; i++)
            list.add(new ArrayList<>());
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        int visited[] = new int[V+1];
        visited[1] = 1;
        path.add(1);
        dfs(list, visited, path);
        return path;
    }
    public static void main(String[] args) {
        System.out.println("This is DFS Traversal.");
        // int V = 10;
        // int edges[][] = {{1, 2}, {1, 7}, {2, 3}, {2, 6}, {3, 4}, {3, 5}, {7, 8}, {7, 10}, {8, 9}};
        int V = 5;
        int edges[][] = {{1, 2}, {1, 5}, {2, 3}, {2, 5}, {3, 4}, {3, 5}, {4, 5}};
        List<Integer> result = dfsTraversal(V, edges);
        System.out.println("BFS Traversal: " + result);
    }
}

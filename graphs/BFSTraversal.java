import java.util.*;
class BFSTravesal {
    public static List<Integer> bfsTraversal(int V, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=V; i++)
            list.add(new ArrayList<>());
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        List<Integer> path = new ArrayList<>();
        int visited[] = new int[V+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = 1;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            path.add(current);
            for(int neighbour: list.get(current)) {
                if(visited[neighbour]!=1){
                    queue.add(neighbour);
                    visited[neighbour] = 1;
                }
            }
        }
        return path;
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int V = 10;
        int edges[][] = {{1, 2}, {1, 7}, {2, 3}, {2, 6}, {3, 4}, {3, 5}, {7, 8}, {7, 10}, {8, 9}};
        List<Integer> result = bfsTraversal(V, edges);
        System.out.println("BFS Traversal: " + result);
    }
}
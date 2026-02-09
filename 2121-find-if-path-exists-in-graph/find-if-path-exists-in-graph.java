class Solution {
    public boolean validPath(int n, int[][] edges, int sc, int dest) {
        if (sc== dest) return true;
        List<Integer>[] adj = new ArrayList[n];
        for (int i=0;i<n;i++) adj[i] = new ArrayList<>();
        for(int[] e:edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        boolean visited[]= new boolean [n];
        dfs(sc,adj,visited);
        return (visited[dest])? true:false;

    }
    private static void dfs(int node ,List<Integer>[] adj,boolean[] visited ){
        visited[node]=true;
        for(int nbr:adj[node]){
            if(!visited[nbr]){
                dfs(nbr,adj,visited);
            }
        }
    }
}
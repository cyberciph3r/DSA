class Solution {
    public boolean isBipartite(int[][] adj) {
        
        int v = adj.length;
        int color[] = new int[v];
        Arrays.fill(color,-1);
        
        for(int i = 0 ; i < v ; i++){
            if(color[i] == -1){
                // if(!bfs(i,adj,color)){
                //     return false;
                // }
                if(!dfs(i,0,color,adj)){
                    return false;
                }
            }
        }
        
        return true;
    }
    public static boolean bfs(int v, int adj[][], int color[]){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        color[v] = 0;
        
        while(!q.isEmpty()){
            
            int pop = q.poll();
            
            for(int nei : adj[pop]){
                if(color[nei] == -1){
                    color[nei] = 1 - color[pop];
                    q.add(nei);
                }else if(color[nei] == color[pop]){
                    return false;
                }
            }
        }
        
        return true;
    }
    public static boolean dfs(int v, int c, int color[], int adj[][]){
        
        color[v] = c;
        
        for(int nei : adj[v]){
            if(color[nei] == -1){
                if(!dfs(nei,(1^c),color,adj)){
                    return false;
                }
            }else if(color[nei] == color[v]){
                return false;
            }
        }
        
        return true;
    }
}
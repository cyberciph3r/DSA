//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Solution {

    List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {
        
        List<Integer> ans = new ArrayList<>();
        
        
        // DFS...
        
        int vis[] = new int[v];
        HashSet<Integer> hs = new HashSet();
        int safeNodes[] = new int[v];
        
        for(int i = 0 ; i < v ; i++){
            if(vis[i] != 1){
                isCycle(i,adj,vis,hs,safeNodes);
            }
        }
        
        for(int i = 0 ; i < v ; i++){
            if(safeNodes[i] == 1){
                ans.add(i);
            }
        }
        
        return ans;
        
        
        
        
        // BFS....
        
        // ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        
        // for(int i = 0 ; i < v ; i++){
        //     revAdj.add(new ArrayList<>());
        // }
        
        // for(int i = 0 ; i < adj.size() ; i++){
            
        //     for(int nei : adj.get(i)){
        //         revAdj.get(nei).add(i);
        //     }
        // }
        
        // int indeg[] = new int[v];
        
        // for(ArrayList<Integer> neis : revAdj){
        //     for(int nei : neis){
        //         indeg[nei]++;
        //     }
        // }
        
        // Queue<Integer> q = new LinkedList<>();
        
        // for(int i = 0 ; i < v ; i++){
        //     if(indeg[i] == 0){
        //         q.add(i);
        //     }
        // }
        
        // while(!q.isEmpty()){
        //     int pop = q.poll();
        //     ans.add(pop);
            
        //     for(int nei : revAdj.get(pop)){
        //         indeg[nei]--;
        //         if(indeg[nei] == 0){
        //             q.add(nei);
        //         }
        //     }
        // }
        
        // Collections.sort(ans);
        
        // return ans;
    }
    
    public static boolean isCycle( int v,List<List<Integer>> adj,int vis[],
                                   HashSet<Integer> hs, int safeNodes[] ){
        
        vis[v] = 1;
        hs.add(v);
        
        for(int nei : adj.get(v)){
            if(vis[nei] == 0){
                if(isCycle(nei,adj,vis,hs,safeNodes)){
                    return true;
                }
            }else if(hs.contains(nei)){
                return true;
            }
        }
        
        hs.remove(v);
        safeNodes[v] = 1;
        
        return false;
    }
}

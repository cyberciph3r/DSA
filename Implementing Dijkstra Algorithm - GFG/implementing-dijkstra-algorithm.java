//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Solution
{
    static class Pair {
        int v,w;
        Pair(int v,int w){
            this.v = v;
            this.w = w;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int dis[] = new int[V];
        for(int i = 0 ; i < V ; i++){
            dis[i] = 10000000;
        }
        int vis[] = new int[V];
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) ->
            {
            //     if(a.w>b.w)
            //         return b.w;
            //     else 
            //         return a.w;
            // }
                return (a.w-b.w);
            });
            
        dis[S] = 0;
        q.offer(new Pair(S,0));
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            
            // if(vis[cur.v]==1)
            //     continue;
            
            // vis[cur.v] = 1;
            
            ArrayList<ArrayList<Integer>> arr = adj.get(cur.v);
            
            for(ArrayList<Integer> a : arr){
                int vv = a.get(0);
                int wt = a.get(1);
                
                if(dis[vv]>dis[cur.v]+wt){
                    dis[vv] = dis[cur.v] + wt;
                    q.offer(new Pair(vv,dis[vv]));
                }
            }
        }
        return dis;
    }
}


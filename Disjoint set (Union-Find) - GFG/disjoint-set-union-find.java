//{ Driver Code Starts
import java.util.*;
class Disjoint{
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n+1];
			for(int i=1;i<=n;i++)
				a[i]=i;
			int k=sc.nextInt();
			GfG g=new GfG();
			for(int i=0;i<k;i++){
				String s=sc.next();
				if(s.equals("UNION")){
					int x=sc.nextInt();
					int z=sc.nextInt();
					g.unionSet(a,x,z);
				}
				else{
					int x=sc.nextInt();
					int parent=g.find(a,x);
					System.out.print(parent+" ");
				}
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


class GfG
{
    //Simple and naive....
    
    
// 	int find(int parent[],int x)
//     {
//           if(parent[x]!=x){
//               return find(parent,parent[x]);
//           }
          
//           return x;
// 	}
// 	void unionSet(int parent[],int x,int z)
//     {
//          int parX = find(parent,x);
//          int parZ = find(parent,z);
         
//          if(parX==parZ){
//              return;
//          }
         
//          parent[parX] = parZ;
// 	}
	
	
	
	
	
	
	
	
// little bit optimized with rank..
	
// 	int find(int parent[],int x)
//     {
//           if(parent[x]!=x){
//               parent[x] = find(parent,parent[x]);
//           }
          
//           return parent[x];
// 	}
// 	void unionSet(int parent[],int x,int z)
//     {
//          int parX = find(parent,x);
//          int parZ = find(parent,z);
//          int n = parent.length;
//          int rank[] = new int[n+1];
         
//          if(parX==parZ){
//              return;
//          }
        
         
//         if(rank[parX]>rank[parZ]){
//             parent[parX] = parZ;
//         }else if(rank[parX]>rank[parZ]){
//             parent[parZ] = parX;
//         }else{
//             parent[parX] = parZ;
//             rank[parZ]++;
//         }

// 	}
	
	
	
	
	
	
	
	
	
	
	// Optimized... constant TC for find()
	
	int find(int parent[],int x)
    {
          if(parent[x]!=x){
              parent[x] = find(parent,parent[x]);
          }
          
          return parent[x];
	}
	void unionSet(int parent[],int x,int z)
    {
         int parX = find(parent,x);
         int parZ = find(parent,z);
         
         if(parX==parZ){
             return;
         }
         
         parent[parX] = parZ;
	}


}

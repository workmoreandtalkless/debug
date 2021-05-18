public class RedundantConnection684 {
    int MAX_EDGE_VAL = 1000;
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(MAX_EDGE_VAL+1);
        for(int [] edge: edges){
            if(!dsu.union(edge[0],edge[1])) return edge;
        }
        throw new AssertionError();
    }
    class DSU{
        int[] parent;
        int[] rank;

        public DSU(int size){
            parent = new int[size];
            for(int i=0;i<size;i++) parent[i] =i;
            rank = new int[size];
        }

        public int find(int x){
            if(parent[x]!=x) parent[x]=find(parent[x]);
            return parent[x];
        }
        public boolean union(int x, int y){
            int xr = find(x), yr = find(y);
            if(xr==yr) return false;
            else if(rank[xr]<rank[yr]) parent[xr]=yr;
            else if(rank[xr]>rank[yr]) parent[yr]=xr;
            else{
                parent[yr]=xr;
                rank[xr]++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
       int  [][] edges1={
               {1,2},{1,3},{2,3}
       } ;
       int [][] edges2={
               {1,2},{2,3},{3,4},{1,4},{1,5}
       };
       RedundantConnection684 r=new RedundantConnection684();
       //int []ans = r.findRedundantConnection(edges1);
       int []ans = r.findRedundantConnection(edges2);
        for (int i: ans
             ) {
            System.out.print(i+" ");
        }

    }
}

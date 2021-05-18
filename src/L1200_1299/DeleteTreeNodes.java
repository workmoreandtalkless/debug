package L1200_1299;

import java.util.ArrayList;
import java.util.List;

public class DeleteTreeNodes {
    public int deleteTreeNodes(int n, int[] par, int[] val) {
        List<List<Integer>> graph = new ArrayList(n);// Create graph for the tree
        for(int i=0;i<n;i++) graph.add(new ArrayList());
        for(int i=0;i<n;i++) {
            if(par[i]!= -1){
                graph.get(par[i]).add(i);
            }
        }
        return dfs(graph,val,0)[1];
    }

    private int[] dfs(List<List<Integer>> graph, int[] val, int root){
        int sum = val[root];
        int cntRemainNodes = 1;
        for(int child : graph.get(root)){
            int []temp = dfs(graph,val,child);
            sum+= temp[0];
            cntRemainNodes += temp[1];
        }
        if(sum == 0) cntRemainNodes = 0;// Dont count nodes of this subtree
        return new int[]{sum,cntRemainNodes};
    }

    public static void main(String[] args) {
        int nodes = 7;
        int[] par = {-1,0,0,1,2,2,2};
        int[] val = {1,-2,4,0,-2,-1,-1};
        DeleteTreeNodes dtn = new DeleteTreeNodes();
        int x = dtn.deleteTreeNodes(nodes,par,val);
        System.out.print(x);
    }
}

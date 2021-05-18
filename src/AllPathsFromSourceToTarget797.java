import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget797 {
    private int target;
    private int [][] graph;
    private List<List<Integer>> results;

    protected void backtrack(int currNode, LinkedList<Integer> path){
        if(currNode == this.target){
            this.results.add(new ArrayList<Integer>(path));
            return;
        }
        for(int nextNode: this.graph[currNode]){
            path.addLast(nextNode);
            this.backtrack(nextNode,path);
            path.removeLast();
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      this.target = graph.length -1;
      this.graph = graph;
      this.results = new ArrayList<List<Integer>>();
      LinkedList<Integer> path = new LinkedList<>();
      path.addLast(0);

      this.backtrack(0,path);
      return this.results;
    }

    public static void main(String[] args) {
        int [][] grid={
                {1,2},
                {3},
                {3},
                {}
        };
        AllPathsFromSourceToTarget797 all= new AllPathsFromSourceToTarget797();
        List<List<Integer>> l = all.allPathsSourceTarget(grid);
        for (int k=0;k<l.size();k++) {
            List<Integer> ll = l.get(k);
            for (int i = 0; i <ll.size() ; i++) {
                System.out.print(ll.get(i)+" ");
            }
            System.out.println();

        }

    }
}

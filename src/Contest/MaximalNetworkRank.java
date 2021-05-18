package Contest;

public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int []count = new int[n];
        int[][] graph = new int[n][n];
        for(int i=0;i<roads.length;i++){
            int a=roads[i][0],b=roads[i][1];
            count[a]++;
            count[b]++;
            graph[a][b]++;
            graph[b][a]++;
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cur = count[i]+count[j]-graph[i][j];
                ans=Math.max(ans,cur);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximalNetworkRank mnr= new MaximalNetworkRank();
        int [][] roads = {
                {0,1},
                {1,2},
                {2,3},
                {2,4},
                {5,6},
                {5,7}
        };
        mnr.maximalNetworkRank(8,roads);
    }
}

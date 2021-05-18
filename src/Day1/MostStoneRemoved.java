package Day1;

public class MostStoneRemoved {
    int [] unions = new int[1000];
    public int removeStones(int[][] stones) {
        int len = stones.length;
        for(int i=0;i<len;i++){
            unions[i]=i;
        }
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(stones[i][0] == stones[j][0]||stones[i][1]==stones[j][1]){
                    union(i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<len;i++){
            if(unions[i]==i) count++;
        }
        return len - count;
    }
    private void union(int x, int y){
        x=find(x);
        y=find(y);
        if(x==y) return;
        unions[y]=x;
    }
    private int find(int x){
        if(unions[x] == x  ) return x;
        return find(unions[x]);
    }
}

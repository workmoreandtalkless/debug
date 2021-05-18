import java.util.ArrayList;
import java.util.List;

public class MinimumSwapsToArrangeABinaryGrid {
    public int minSwaps(int[][] grid) {
        List<Integer> list=new ArrayList<>();
        int n=grid.length;
        for(int i=0;i<grid.length;i++){
            list.add(check(grid[i]));
        }

        int res=0;

        for(int i=0;i<grid.length;i++){
            int zero=n-i-1;
            int index=-1;
            for(int j=0;j<list.size();j++){
                if(list.get(j)>=zero){
                    index=j;
                    break;
                }
            }
            if(index==-1)return -1;
            list.remove(index);
            res+=index;
        }

        return res;

    }
    public int check(int A[]){
        int cnt=0;
        for(int i=A.length-1;i>=0;i--){
            if(A[i]==0)cnt++;
            else break;
        }
        return cnt;
    }

    public static void main(String[] args) {
        MinimumSwapsToArrangeABinaryGrid m = new MinimumSwapsToArrangeABinaryGrid();
        int [][] grid={{0,0,1},{1,1,0},{1,0,0}};
        int [][] grid1={{1,0,0},{1,1,0},{1,1,1}};
        int x=m.minSwaps(grid1);
        System.out.println(x);
    }
}

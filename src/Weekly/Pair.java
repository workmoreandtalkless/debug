package Weekly;

public class Pair {
    int []cnt ;
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        cnt=new int[n];
        for(int i=0;i<pairs.length;i++){
            int x=pairs[i][0];//0
            int y=pairs[i][1];//1
            ifh(preferences,x,y,cnt,pairs);
            ifh(preferences,y,x,cnt,pairs);
        }

        int res=0;
        for(int i=0;i<cnt.length;i++){
            if(cnt[i]==2) res++;
        }
        return res;
    }

    public void ifh(int[][] preferences,int x,int y,int []cnt,int [][]pairs){
        if(cnt[x]==1||cnt[x]==2) return;
        int [] px = preferences[x];
        //int [] py = preferences[y];
        int index = 0;
        //find the position of y
        for(int i=0;i<px.length;i++){
            if(px[i]==y) {
                index=i;
                break;
            }
        }
        if(index==0){
            cnt[x]=1;
            return;
        }
        //find the unhappy
        for(int i=0;i<index;i++){
            int u = px[i];
            int v = pair(pairs,u);
            int pox=position(preferences,u,x);
            int pov=position(preferences,u,v);
            if(pox<pov) {
                cnt[x]=2;
                cnt[u]=2;
                return;}
        }
        cnt[x]=1;
        return;
    }
    public int pair(int[][] pairs,int someone){
        for(int i=0;i<pairs.length;i++){
            if(pairs[i][0]==someone){
                return pairs[i][1];
            }else if(pairs[i][1]==someone){
                return pairs[i][0];
            }
        }

        return 0;
    }
    public int position(int[][] preferences,int u,int x){
        int []pu = preferences[u];
        for(int i=0;i<pu.length;i++){
            if(pu[i]==x){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int [][] preferences = {
                {1, 2, 3},
                {3, 2, 0},
                {3, 1, 0},
                {1, 2, 0}
        };
        int n = 4;
        int [][]pairs ={
                {0,1},
                {2,3}
        };
        int [][]p={{1,3,2},{2,3,0},{1,0,3},{1,0,2}
        };
        int [][]pa={
                {2,1},{3,0}
        };
        Pair pair = new Pair();
       int x= pair.unhappyFriends(n,p,pa);
       System.out.print(x);
    }
}

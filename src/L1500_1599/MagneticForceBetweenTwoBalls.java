package L1500_1599;

import Weekly.MinOperation;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l=1,r=999999999;
        while(l<r){
            int mid = (r+l)/2 +1;
            if(check(position,m,mid))
                l=mid;
            else
                r = mid -1;
        }
        return l;
    }
    public boolean check(int []position,int m, int force){
        int pos = position[0];
        for(int i=1;i<position.length&&m>1;i++){
            if(position[i]-pos >=force){
                --m;
                pos = position[i];
            }
        }
        return m<2;
    }

    public static void main(String[] args) {
        MagneticForceBetweenTwoBalls mf= new MagneticForceBetweenTwoBalls();
        int []p={1,2,3,4,7};
        int m=3;
        mf.maxDistance(p,m);
    }
}


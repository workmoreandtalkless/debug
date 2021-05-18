package L1000_1099;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < weights.length; i++) {
            sum+=weights[i];
            if(max<weights[i]) max = weights[i];
            if(min>weights[i]) min = weights[i];

        }
        int low = min;
        int high = sum;
        int mid = low +(high-low)/2;
        while (low<high){
            mid = low +(high-low)/2;
            if(!check(weights,D,mid)){
                low = mid+1;
            }
            else {
                high = mid;
            }

        }

        return mid;
    }
    public boolean check(int[]weights,int D, int mid){
        int acc=0;
        for (int i = 0; i < weights.length; i++) {

            acc+=weights[i];
            if(acc>mid){
                i--;
                acc=0;
                D--;
                if(D<0) return false;
            }
            if(acc==mid){
                acc=0;
                D--;
                if(D<0) return false;
            }

        }
        if(acc>0) {
            D--;
            if(D<0) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays ct= new CapacityToShipPackagesWithinDDays();
        int []w ={1,2,3,4,5,6,7,8,9,10};
        int []ww={147,73,265,305,191,152,192,293,309,292,182,157,381,287,73,162,313,366,346,47};
        int D =10;
        int x=ct.shipWithinDays(ww,D);
//        boolean test= ct.check(w,D,16);
//        System.out.println(test);
        System.out.println(x);
    }
}

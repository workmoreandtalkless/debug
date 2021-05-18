public class FindSmallestCommonElementInAllRows1198 {
    public int smallestCommonElement(int[][] mat) {
        int [] l= mat[0];
        int x=0;
        for(int i=0;i<l.length;i++){
            for (int j = 1; j < mat.length; j++) {
                x = find(mat[j],l[i]);
                if(x==-1) break;
            }
            if(x!=-1){
                return x;
            }
        }

        return x;
    }

    public int find(int [] list,int val){
        int i=0;
        int j=list.length-1;
        int mid ;
        while(i<=j){
           mid = i+(j-i)/2;
           if(val<list[mid]){
               j=mid-1;
           }
           else if(val>list[mid]){
               i=mid+1;
           }
           else return list[mid];
        }
        return -1;
    }

    public static void main(String[] args) {
        int [][]mat = {
                {1,2,3,4,5},
                {2,4,5,8,10},
                {3,5,7,9,11},
                {1,2,3,5,7,9}

        };
        FindSmallestCommonElementInAllRows1198 f=new FindSmallestCommonElementInAllRows1198();
        int x=f.smallestCommonElement(mat);
        System.out.print(x);
    }
}

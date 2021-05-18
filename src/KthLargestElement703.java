public class KthLargestElement703 {
    int [] arr;
    int index;
    int k;

    public KthLargestElement703(int k, int[] nums) {
        this.k = k;
        this.index = nums.length;
        this.arr = new int[index];
        for(int i=0;i<arr.length;i++){
            arr[i]=nums[i];
        }
        sort(arr);
    }

    public int add(int val) {
        if(this.index==arr.length){
            int [] old = this.arr;
            this.arr = new int[2*arr.length];
            for(int i=0;i<old.length;i++){
                this.arr[i]=old[i];
            }
            addval(val);
        }
        else addval(val);
        //this.index++;
        //Arrays.sort(this.arr);
        return arr[this.k-1];
    }
    public void sort(int []arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
    public void addval(int val){
        int temp = this.index;
        int curr=index-1;
        if(arr[curr]>=val){ arr[temp]=val; index++; return;}

        while(arr[curr]<val&&temp>=0){
            if(curr==-1){
                arr[0]=val;
                break;
            }
            arr[temp]=arr[curr];
            arr[curr]=val;
            temp--;
            curr--;
            if(curr==-1){
                arr[0]=val;
                break;
            }
        }
        index++;
    }

    public static void main(String[] args) {
        int k=3;
        int [] arr={4,5,8,2};
        KthLargestElement703 kth = new KthLargestElement703(k,arr);
        int a=kth.add(3);
        int b=kth.add(5);
        int c=kth.add(10);
        int d=kth.add(9);
        int e=kth.add(4);

        System.out.print(a+" "+b+" "+c+" "+d+" "+e+" ");
    }
}

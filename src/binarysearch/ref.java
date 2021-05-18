package binarysearch;

public class ref {
    int [] items = {1,2,3,4};
    public void solve(){
        items = null;
    }
    public void solve(int[]items){
        items[1]=100;
    }

    public static void main(String[] args) {
        ref re = new ref();
        int [] items = {1,2,3,4};//
        re.solve(items);
        System.out.println(items);
    }


}

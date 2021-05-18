package Dynamic;

public class fib {
    int [] arr = new int[1000];


    public  int  fibna(int n , int []memo){
        if(memo[n]!=0) return memo[n];
        if(n<=2) return 1;
        memo[n] = fibna(n-1,memo) + fibna(n-2,memo);
        return memo[n];
    }
    public int fib(int n){
        if(n<=2) return 1;
        int a,b;
        if(arr[n-1]!=0){
          a = arr[n-1];
        }else {
            a = fib(n-1);
            arr[n-1] = a;
        }

        if(arr[n-2]!=0){
          b = arr[n-2];
        }else{
            b = fib(n-2);
            arr[n-2] = b;
        }

        return a + b;
    }
    public  void foo(int n){
        if(n<=1) return ;
        foo(n-1);
    }
    public void bar(int n){
        if(n<=1)return;
        bar(n-2);
    }
    public void dib(int n){
        if(n<=1) return;
        dib(n-1);
        dib(n-1);
    }
    public void lib(int n){
        if(n<=1) return;
        dib(n-2);
        dib(n-2);
    }
    public static void main(String[] args) {
            fib f = new fib();
           System.out.println(f.fib(50)); ;
           System.out.println(f.fibna(50,new int[100])) ;
    }
}

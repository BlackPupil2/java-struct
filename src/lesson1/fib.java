package lesson1;

public class fib {
    public int fib(int n) {
        if(n<=1) {
            return n;
        }
        int first=0;
        int second=1;
        for (int i = 0; i < n - 1; i++) {
            int sum=first+second;
            first=second;
            second=sum;
        }
        return second;
    }
    public static int fib3(int n){
        if(n<=1) {
            return 0;
        }
        int first=0;
        int second=1;
        while (n-->1){
            second=first+second;
            first=second-first;
        }
        return second;
    }
}

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
}

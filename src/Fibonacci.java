
public class Fibonacci {

    public static void main(String[] args) {

        int finbNum = 30;
        int[] fibCache = new int[finbNum];
        for(int i = 0; i < fibCache.length; i++)
        {
            fibCache[i] = -1;
        }

        System.out.println(fib(finbNum - 1, fibCache));
    }

    public static int fib(int n, int[] fibCache)
    {
        if(n == 0 || n == 1)
        {
            return n;
        }
        if(fibCache[n] == -1)
        {
            fibCache[n] = fib(n - 1, fibCache) + fib(n - 2, fibCache);
        }
        return fibCache[n];
    }
}



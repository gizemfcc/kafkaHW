package com.i2i.intern.operationClasses;

public class IsFibonacci {
    static  boolean isPerfectSquare(int x)
    {
        int s = (int) Math.sqrt(x);
        return (s*s == x);
    }

    // Returns true if n is a Fibonacci Number, else false
    public static boolean isFibonacci(int n)
    {
        // n is Fibonacci if one of 5*n*n + 4 or 5*n*n - 4 or both
        // is a perfect square
        return isPerfectSquare(5*n*n + 4) ||
                isPerfectSquare(5*n*n - 4);
    }
}

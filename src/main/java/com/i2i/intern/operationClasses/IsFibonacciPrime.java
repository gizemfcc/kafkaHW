package com.i2i.intern.operationClasses;
import java.lang.Math;

import static com.i2i.intern.operationClasses.IsFibonacci.isFibonacci;
import static com.i2i.intern.operationClasses.IsPrime.isPrime;

public class IsFibonacciPrime {
    public static  boolean isFibonacciPrime(int num)
    {
        if(isPrime(num) && isFibonacci(num)){
            return true;
        }
        else{
            return false;
        }
    }
}

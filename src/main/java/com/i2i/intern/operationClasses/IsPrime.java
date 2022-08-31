package com.i2i.intern.operationClasses;
import java.lang.Math;

public class IsPrime {
    public static boolean isPrime(int n){
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        int sqrtN= (int) Math.sqrt(n);

        for (int i = 2; i<= sqrtN; i++){
            if (n % i == 0)
                return false;}
        return true;
    }
}

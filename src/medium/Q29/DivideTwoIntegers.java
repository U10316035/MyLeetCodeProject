package medium.Q29;

class Solution {
    public static int divide(int dividend, int divisor) {
        int neg = 1;
        int count = 0;

        if(dividend == divisor) return 1;
        else if(dividend == divisor*-1) return -1;

        if(divisor == 1) return dividend;
        else if(divisor == -1){
            if(dividend == Integer.MIN_VALUE) dividend++;
            return dividend * -1;
        }

        if(dividend == 0) return 0;
        else if(dividend < 0){
            int neg_divisor = -1;
            if(divisor > 0){
                neg = -1;
                neg_divisor = 1;
            }
            while(dividend <= 0 && count > Integer.MIN_VALUE){
                dividend += divisor * neg_divisor;
                count++;
            }

        }else{
            if(divisor < 0) neg = -1;

            while(dividend >= 0 && count < Integer.MAX_VALUE){
                dividend -= divisor * neg;
                count++;
            }
        }


        return (count - 1) * neg;
    }
}

public class DivideTwoIntegers {
    public static void main(String[] args){
        System.out.println(Solution.divide(2147483647, 1));
    }
}

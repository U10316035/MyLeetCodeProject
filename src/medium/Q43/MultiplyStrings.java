package medium.Q43;

import java.util.ArrayList;
import java.util.List;


// 未完成
class Solution {
    public static String multiply(String num1, String num2) {
        List<String> nL = new ArrayList<>();
        int sum = 0;
        int timesX = 1;
        for(int i = num2.length() - 1; i >= 0 ; i--){
            int timesY = 1;
            int x = Character.getNumericValue(num2.charAt(i));
            for(int j = num1.length() - 1; j >= 0 ; j--){
                int y = Character.getNumericValue(num1.charAt(j));

                sum += x * y;
                int times = timesX * timesY;
                String tempStr = Integer.toString(sum);
                while(times != 1){
                    tempStr += 0;
                    times /= 10;
                }
                nL.add(tempStr);
                timesY *= 10;
            }
            timesX *= 10;
        }
        return Integer.toString(sum);
    }
}

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(Solution.multiply("2", "3"));
    }
}

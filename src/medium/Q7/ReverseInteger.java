package medium.Q7;

class Solution {
    public static int reverse(int x) {
        String signed = "";
        int output = 0;
        if(x < 0){
            signed = "-";
            x = x * -1;
        }

        char[] cArr = Integer.toString(x).toCharArray();

        for(int i=0;i<cArr.length/2;i++){
            char temp =cArr[i];
            cArr[i] = cArr[cArr.length-i-1];
            cArr[cArr.length-i-1] = temp;
        }

        try{
            String valStr = signed + String.valueOf(cArr);
            output = Integer.valueOf(valStr);
        }catch(NumberFormatException ne){
            return 0;
        }

        return  output;
    }
}

public class ReverseInteger {
    public static void main(String[] args){
        System.out.println(Solution.reverse(-1334));
    }
}

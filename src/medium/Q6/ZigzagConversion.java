package medium.Q6;

class Solution {
    public static String convert(String s, int numRows) {
        char[][] list = new char[numRows][s.length()];
        int[] count = new int[numRows];

        int i = 0;
        tag:
        while(i < s.length()){
            for(int j = 0 ; j < numRows ; j++){
                list[j][count[j]] = s.charAt(i);
                i++;
                count[j]++;
                if(i >= s.length()) break tag;
            }

            for(int j = numRows-2 ; j > 0 ; j--){
                list[j][count[j]] = s.charAt(i);
                i++;
                count[j]++;
                if(i >= s.length()) break tag;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int j = 0 ; j < numRows ; j++){
            String tempS = new String(list[j]);
            sb.append(tempS.trim());
        }

        return sb.toString();
    }
}

public class ZigzagConversion {
    public static void main(String[] args){
        System.out.println(Solution.convert("PAYPALISHIRING", 3));
    }
}

package easy.Q14;


class Solution {
    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
        int i = 0;
        while(i<strs[0].length()){
            char temp = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<=i) return ans;
                if(strs[j].charAt(i) != temp) return ans;
            }
            ans += temp;
            i++;
        };
        return ans;
    }
}
public class LongestCommonPrefix {
    public static void main(String[] args){
        System.out.println(Solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}

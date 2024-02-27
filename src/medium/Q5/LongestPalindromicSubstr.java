package medium.Q5;

class Solution {
    public static String longestPalindrome(String s) {
        String maxStr = s.substring(0, 1);
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                if(j-i+1 <= maxStr.length()) continue;
                String temp = s.substring(i, j+1);
                if(checkPalindromic(temp)){
                    maxStr = temp;
                }
            }
        }
        return maxStr;
    }

    static boolean checkPalindromic(String s){
        int length = s.length();
        boolean isP = true;
        for(int i=0;i<length/2;i++){
            if(s.charAt(i) != s.charAt(length-i-1)){
                isP = false;
                break;
            }
        }
        return isP;
    }
}

public class LongestPalindromicSubstr {
    public static void main(String[] args){
        System.out.println(Solution.longestPalindrome("babad"));
    }
}

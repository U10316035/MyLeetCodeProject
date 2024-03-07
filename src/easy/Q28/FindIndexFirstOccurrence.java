package easy.Q28;

class Solution {
    public static int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)) return -1;
        for(int i=0;i<haystack.length();i++){
            Boolean isSame = true;
            if(haystack.charAt(i)==needle.charAt(0) && haystack.length()-i >= needle.length()){
                for(int j=0;j<needle.length();j++){
                    if(haystack.charAt(i+j)!=needle.charAt(j)){
                        isSame = false;
                        break;
                    }
                }
            }else isSame = false;
            if(isSame) return i;
        }
        return -1;
    }
}
public class FindIndexFirstOccurrence {
    public static void main(String[] args) {
        System.out.println(Solution.strStr("sadbutsad", "sad"));
    }
}
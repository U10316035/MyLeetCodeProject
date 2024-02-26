package medium.Q3;

import org.graalvm.collections.Pair;

import java.util.LinkedHashSet;
import java.util.Set;

// Pair結構不同JDK有不同實現

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int index = 0;
        int max = 0;
        String maxStr = "";
        while(index != length){
            Pair<Integer, String> p = getMap(s.substring(index, length));
            if(p.getLeft() > max){
                max = p.getLeft();
                maxStr = p.getRight();
            }
            index++;
        }
        return max;
    }

    static Pair<Integer, String> getMap(String s){
        Set<Character> words = new LinkedHashSet<>();
        int cal = 0;
        String sub = "";
        for(int i=0;i<s.length();i++){
            if(words.contains(s.charAt(i))){
                cal = i;
                sub = s.substring(0, i-1);
                break;
            }
            words.add(s.charAt(i));
        }
        if(cal == 0){
            cal = s.length();
            sub = s;
        }

        return Pair.create(cal, sub);
    }
}

public class LongestSubStrNotRepeating {
    public static void main(String[] args){
        System.out.println(Solution.lengthOfLongestSubstring("abcabcbb"));
    }
}

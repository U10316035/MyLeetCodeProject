package hard.Q30;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

// TLE need to think better solution
class Solution {
    public static List<Integer> findSubstring(String s, String[] words) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();

        int len = words.length;
        int letterCount = words[0].length();
        int totalLen = len * letterCount;

        Arrays.stream(words).forEach(www -> {
            HashMap<String, Integer> hm = new HashMap<>();
            for( String w: words ){
                hm.merge(w, 1, Integer::sum);
            }

            for(int i = 0 ; i <= s.length() - totalLen; i++){
                String temp = s.substring(i, i + letterCount);
                if(temp.equals(www)){
                    hm.put(temp, hm.get(temp) - 1);
                    String judge = s.substring(i, i + totalLen);
                    for (int j = letterCount; j < totalLen; j += letterCount) {
                        String ttt = judge.substring(j, j + letterCount);
                        if (hm.get(ttt) != null) {
                            hm.put(ttt, hm.get(ttt) - 1);
                        }
                    }

                    AtomicBoolean isIn = new AtomicBoolean(true);
                    hm.forEach((k, v) -> {
                        if(v != 0) isIn.set(false);
                    });

                    if(isIn.get()) lhs.add(i);
                    hm.clear();
                    for (String w : words) {
                        hm.merge(w, 1, Integer::sum);
                    }

                }


            }
        });

        return lhs.stream().toList();
    }
}

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        List<Integer> ans = Solution.findSubstring("bcabbcaabbccacacbabccacaababcbb", new String[]{"c","b","a","c","a","a","a","b","c"});
        ans.forEach(System.out::println);
    }
}

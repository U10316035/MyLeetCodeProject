package medium.Q18;

import java.util.*;

// 暴力解，可想其他解
class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        nums = trimArray(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < nums.length-3 ; i++){
            for(int j = i+1 ; j < nums.length-2 ; j++){
                for(int k = j+1 ; k < nums.length-1 ; k++){
                    for(int l = k+1 ; l < nums.length ; l++){
                        Long tempB = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];
                        if(tempB > Integer.MAX_VALUE || tempB < Integer.MIN_VALUE) continue;
                        if(tempB == target){
                            int[] ttt = new int[]{nums[i], nums[j], nums[k], nums[l]};
                            Arrays.sort(ttt);
                            if(checkExist(ans, ttt)) continue;
                            List<Integer>temp = new ArrayList<>();
                            temp.add(ttt[0]);
                            temp.add(ttt[1]);
                            temp.add(ttt[2]);
                            temp.add(ttt[3]);
                            ans.add(temp);
                        }
                    }
                }
            }
        }
        return ans;
    }

    static boolean checkExist(List<List<Integer>> target, int[] ttt){
        for(List<Integer> clone : target){
            if(clone.get(0) == ttt[0] &&
                    clone.get(1) == ttt[1] &&
                    clone.get(2) == ttt[2] &&
                    clone.get(3) == ttt[3]){

                return true;
            }
        }
        return false;
    }

    static int[] trimArray(int[] temp){
        List<Integer> newList = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int element : temp){
            if(countMap.get(element) == null){
                countMap.put(element, 1);
            }else if(countMap.get(element) == 4){
                continue;
            }else{
                countMap.put(element, countMap.get(element)+1);

            }
            newList.add(element);
        }
        return newList.stream().mapToInt(Integer::intValue).toArray();
    }
}
public class FourSum {
    public static void main(String[] args) {
        System.out.println(Solution.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
        System.out.println(Solution.fourSum(new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}, 8));

    }
}

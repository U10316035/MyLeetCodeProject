package easy.Q1;


import java.util.Arrays;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        var index1 = -1;
        var index2 = -1;
        for(int i = 0 ; i < nums.length-1 ; i++){
            var found = false;
            for(int j = i+1 ; j < nums.length ; j++){
                if(nums[i] + nums[j] == target){
                    index1 = i;
                    index2 = j;
                    found = true;
                    break;
                }
            }
            if(found) break;
        }
        return new int[]{index1, index2};
    }
}
public class TwoSum {
    public static void main(String[] args){
        System.out.println(Arrays.toString(Solution.twoSum(new int[]{2,7,11,15}, 9)));
    }
}

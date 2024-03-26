package medium.Q34;

import java.util.Arrays;

// 可以遞迴更簡化思路
class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int targetIdx = -1;
        int targetEndIdx = -1;
        if(nums.length == 0) return new int[]{targetIdx, targetEndIdx};
        int startIdx = 0;
        int endIdx = nums.length - 1;
        if(target < nums[startIdx] || target > nums[endIdx]){
            return new int[]{targetIdx, targetEndIdx};
        }
        if(target == nums[startIdx]){
            targetIdx = targetEndIdx = startIdx;
        }
        else if(target == nums[endIdx]){
            targetIdx = targetEndIdx = endIdx;
        }else{
            while(startIdx < endIdx){
                int half = startIdx + (endIdx - startIdx) / 2;
                if(target == nums[half]){
                    targetIdx = targetEndIdx = half;
                    break;
                }
                else if(nums[half] < target) startIdx = half+1;
                else endIdx = half;
            }
        }
        if(targetIdx != -1){
            int pathBack = targetIdx;
            while(pathBack > 0 && nums[pathBack] == target){
                targetIdx = pathBack--;
            }

            int pathForward = targetEndIdx;
            while(pathForward < nums.length && nums[pathForward] == target){
                targetEndIdx = pathForward++;
            }
        }

        return new int[]{targetIdx, targetEndIdx};
    }
}
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.searchRange(new int[]{5,7,7,8,8,10} , 8)));
    }
}
package easy.Q35;

class Solution {
    public static int searchInsert(int[] nums, int target) {
        int startIdx = 0;
        int endIdx = nums.length - 1;
        if(target <= nums[startIdx]) return 0;
        else if(target > nums[endIdx]) return endIdx+1;
        while(startIdx < endIdx){
            int half = startIdx + (endIdx - startIdx) / 2;
            if(target == nums[half]) return half;
            else if(nums[half] < target) startIdx = half+1;
            else endIdx = half;
        }
        return startIdx;
    }
}

public class SearchInsertPosition {
    public static void main(String[] args){
        System.out.println(Solution.searchInsert(new int[]{1,3,5,6}, 4));
    }
}

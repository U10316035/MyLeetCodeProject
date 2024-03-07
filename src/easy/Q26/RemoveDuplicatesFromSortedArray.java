package easy.Q26;

class Solution {
    public static int removeDuplicates(int[] nums) {
        int currentIdx = 0;
        int currentNum = -101;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>currentNum){
                currentNum = nums[i];
                int temp = nums[i];
                nums[currentIdx] = currentNum;
                nums[i] = temp;
                currentIdx++;
            }
        }

        int count = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(Solution.removeDuplicates(new int[]{1, 1, 2, 3, 4}));
    }
}
package easy.Q27;

import java.util.Arrays;

class Solution {
    public static int removeElement(int[] nums, int val) {
        int currentIdx = nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                int temp;
                while(nums[currentIdx]==val && currentIdx>0){
                    currentIdx--;
                }
                if(currentIdx<=i) break;
                temp = nums[currentIdx];
                nums[currentIdx] = nums[i];
                nums[i] = temp;
                currentIdx--;
            }
        }

        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                count++;
            }else{
                break;
            }
        }
        System.out.println("nums: ");
        Arrays.stream(nums).forEach(System.out::println);
        return count;
    }
}
public class RemoveElement {
    public static void main(String[] args) {
        int a = Solution.removeElement(new int[]{3,2,2,3}, 3);
        System.out.println("Get first count: ");
        System.out.println(a);
    }
}
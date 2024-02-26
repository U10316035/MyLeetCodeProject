package hard.Q4;

import java.util.Arrays;

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] both = new int[nums1.length + nums2.length];
        for(int i=0;i<nums1.length;i++){
            both[i] = nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            both[i+nums1.length] = nums2[i];
        }
        Arrays.sort(both);
        double out = 0.0;
        if(both.length % 2 == 0){
            int start = both.length / 2;
            out = (both[start] + both[start-1]) / 2.0;
        }else{
            int start = both.length / 2;
            out = both[start];
        }

        return out;
    }
}
public class MediumOfTwoSortedArray {
    public static void main(String[] args){
        int[] test1 = {1,3};
        int[] test2 = {2};

        System.out.println(Solution.findMedianSortedArrays(test1, test2));

        int[] test3 = {1,2};
        int[] test4 = {3, 4};

        System.out.println(Solution.findMedianSortedArrays(test3, test4));
    }
}

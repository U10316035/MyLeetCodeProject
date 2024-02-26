package easy.Q100;

/*
    利用遞迴做檢查
 */

public class SameTree {
    public static void main(String[] args){
        TreeNode test1 = new TreeNode(1, null, null);
        TreeNode test2 = new TreeNode(1, null, null);

        // true
        System.out.println(Solution.isSameTree(test1, test2));

        TreeNode test3 = new TreeNode(1, null, null);
        TreeNode test4 = new TreeNode(1, new TreeNode(2, null, null), null);

        // false
        System.out.println(Solution.isSameTree(test3, test4));
    }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}

class Solution {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isLeftSame;
        boolean isRightSame;
        if(p == q) return true;
        else if(p == null || q == null) return false;
        else if(p.val != q.val) return false;
        else{
            if(p.left == null && q.left == null){
                isLeftSame = true;
            }else if(p.left != null && q.left != null){
                isLeftSame = isSameTree(p.left, q.left);
            }else{
                return false;
            }

            if(p.right == null && q.right == null){
                isRightSame = true;
            }else if(p.right != null && q.right != null){
                isRightSame = isSameTree(p.right, q.right);
            }else{
                return false;
            }
        }

        return isLeftSame && isRightSame;

    }
}

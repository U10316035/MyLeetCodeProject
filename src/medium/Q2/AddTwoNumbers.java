package medium.Q2;

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pass = 0;
        ListNode iter1 = l1;
        ListNode iter2 = l2;
        while(iter1 != null && iter2 != null){
            int tempSum = iter1.val + iter2.val;
            if(pass == 1){
                tempSum++;
            }

            if(tempSum >= 10){
                pass = 1;
                tempSum -= 10;
            }else{
                pass = 0;
            }
            iter1.val = tempSum;
            iter2.val = tempSum;
            if(iter1.next == null || iter2.next == null) break;
            iter1 = iter1.next;
            iter2 = iter2.next;
        }

        if(iter1.next == null && iter2.next == null && pass == 1){
            iter1.next = new ListNode(1, null);
            return l1;
        }
        else if(iter1.next != null){
            iter1 = iter1.next;
            while(iter1 != null){
                int tempSum = iter1.val;
                if(pass == 1){
                    tempSum++;
                }
                if(tempSum >= 10){
                    pass = 1;
                    tempSum -= 10;
                }else{
                    pass = 0;
                }
                iter1.val = tempSum;
                if(iter1.next == null && pass == 1){
                    iter1.next = new ListNode(1, null);
                    break;
                }
                iter1 = iter1.next;
            }
            return l1;
        }else if(iter2.next != null){
            iter2 = iter2.next;
            while(iter2 != null){
                int tempSum = iter2.val;
                if(pass == 1){
                    tempSum++;
                }
                if(tempSum >= 10){
                    pass = 1;
                    tempSum -= 10;
                }else{
                    pass = 0;
                }
                iter2.val = tempSum;
                if(iter2.next == null && pass == 1){
                    iter2.next = new ListNode(1, null);
                    break;
                }
                iter2 = iter2.next;
            }
            return l2;
        }
        return l1;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args){
        ListNode test1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode test2 = new ListNode(4, new ListNode(5, new ListNode(6)));

        System.out.println("[1, 2, 3] + [4, 5, 6] = ");
        ListNode ans1 = Solution.addTwoNumbers(test1, test2);
        System.out.print("[" + ans1.val);
        ans1 = ans1.next;
        do{
            System.out.print(", " + ans1.val);
            ans1 = ans1.next;
        }while(ans1 != null);
        System.out.println("]");

        System.out.println("\n---\n");

        ListNode test3 = new ListNode(7, new ListNode(8, new ListNode(9)));
        ListNode ans2 = Solution.addTwoNumbers(test3, test3);
        System.out.println("[7, 8, 9] + [7, 8, 9]");
        System.out.print("[" + ans2.val);
        ans2 = ans2.next;
        do{
            System.out.print(", " + ans2.val);
            ans2 = ans2.next;
        }while(ans2 != null);
        System.out.println("]");
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

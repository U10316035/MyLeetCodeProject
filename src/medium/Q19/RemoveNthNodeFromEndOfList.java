package medium.Q19;

// 兩次遍歷可解
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode iterator = head;
        while(iterator != null){
            count++;
            iterator = iterator.next;
        }

        n = count - n + 1;
        count = 1;
        ListNode temp = null;
        iterator = head;
        if(n == 1){
            head = head.next;
            return head;
        }
        while(iterator != null){
            if(temp != null){
                temp.next = iterator.next;
                break;
            }
            if(count == n-1){
                temp = iterator;
            }
            iterator = iterator.next;
            count++;
            if(iterator == null){
                temp.next = null;
            }
        }
        return head;
    }
}

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))));

        ListNode head = Solution.removeNthFromEnd(a, 2);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

package easy.Q21;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

        ListNode o = new ListNode();
        if(list1.val<list2.val){
            o = new ListNode(list1.val);
            list1 = list1.next;
        }else{
            o = new ListNode(list2.val);
            list2 = list2.next;
        }

        ListNode current = o;

        do{
            if(list2 == null){
                current.next = new ListNode(list1.val);
                list1 = list1.next;
            }else if(list1 == null){
                current.next = new ListNode(list2.val);
                list2 = list2.next;
            }else{
                if(list1.val < list2.val){
                    current.next = new ListNode(list1.val);
                    list1 = list1.next;
                }else{
                    current.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            }
            current = current.next;
        }while(list1 != null && list2 != null);

        if(list1 == null){
            current.next = list2;
        }else if(list2 == null){
            current.next = list1;
        }

        return o;
    }
}
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(4, null)));

        ListNode b = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        ListNode head = Solution.mergeTwoLists(a, b);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}

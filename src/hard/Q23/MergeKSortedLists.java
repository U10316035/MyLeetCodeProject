package hard.Q23;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode minNode = getMin(lists);
        ListNode firstNode = minNode != null ? new ListNode(minNode.val) : null;
        ListNode iterNode = firstNode;
        while(minNode != null){
            boolean isAllNull = true;
            for(int j = 0;j < lists.length ; j++){
                if (lists[j] != null) {
                    isAllNull = false;
                    if(minNode.equals(lists[j])){
                        lists[j] = lists[j].next;
                    }
                }
            }

            if(isAllNull) break;
            else{
                minNode = getMin(lists);
                iterNode.next = minNode != null ? new ListNode(minNode.val) : null;
                iterNode = iterNode.next;
            }
        }
        return firstNode;
    }

    static ListNode getMin(ListNode[] lists){
        int min = 10001;
        ListNode minNode = null;
        boolean isAllNull = true;
        for(ListNode temp: lists){
            if (temp != null) {
                isAllNull = false;
                if(temp.val < min){
                    min = temp.val;
                    minNode = temp;
                }
            }
        }

        // if(minNode != null) minNode = minNode.next;
        // ListNode returnNode = isAllNull ? null : new ListNode(min, null);
        return minNode;//returnNode;
    }
}
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode a = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode b = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode c = new ListNode(2, new ListNode(6, null));

        ListNode head = Solution.mergeKLists(new ListNode[]{a, b, c});
        while(head != null){
            System.out.println(head.val);

            head = head.next;
        }
    }
}
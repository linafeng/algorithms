package leetcode;

/**
 * 两两交换链表中的节点
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        SwapNodesInPairs.ListNode testnode = new SwapNodesInPairs.ListNode(1);
        testnode.next = new SwapNodesInPairs.ListNode(2);
        testnode.next.next = new SwapNodesInPairs.ListNode(3);
        testnode.next.next.next = new SwapNodesInPairs.ListNode(4);
        testnode.next.next.next.next = new SwapNodesInPairs.ListNode(5);
        SwapNodesInPairs.ListNode node = swapPairs(testnode);
        System.out.println(1);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        //第一个节点
        ListNode first = head;
        //第二个节点
        ListNode second = head.next;

        //保存记录第二个节点后的节点引用
        ListNode next = second.next;

        //第二个节点指向第一个节点
        second.next = first;

        //第二个节点指向第一个节点，第一个节点指向(原第二个节点的下一个节点)
        first.next = swapPairs(next);//2,1.next=交换（3,4,5）
        return second;


    }

    public static class ListNode {
        int val;
        SwapNodesInPairs.ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

package leetcode;

import java.util.Objects;

/**
 * 206反转链表
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode testnode = new ListNode(1);
        testnode.next = new ListNode(2);
        testnode.next.next = new ListNode(3);
        testnode.next.next.next = new ListNode(4);
        testnode.next.next.next.next = new ListNode(5);
        ListNode node= reverseList2(testnode);
        ListNode node2= reverseList(null);
        System.out.println(1);
    }

    /**
     * 自己写的
     *基本思路每次取出头节点指向新的链表的头部，形成逆置
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if(Objects.isNull(head)){
            return null;
        }
        ListNode newone = head;
        ListNode current = null;
        int count=1;
        while (Objects.nonNull(newone.next)) {
            ListNode nextTemp = new ListNode(1);
            nextTemp.next = current;
            current = nextTemp;
            current.val = newone.val;
            newone = newone.next;
        }
        ListNode nextTemp = new ListNode(newone.val);
        nextTemp.next = current;
        return nextTemp;
    }

    /**
     * 官方答案
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;//先把后面的链子拷贝一份放一边
            curr.next = prev;//将后面的链子替换为前置节点
            prev = curr;//对前置节点赋值为当前节点，于是前置节点的下一个节点还是他自己
            curr = nextTemp;
        }
        return prev;
    }
    public static ListNode reverseList3(ListNode head) {
        if(Objects.isNull(head)){
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;

        int count=1;
        while (Objects.nonNull(cur.next)) {
            ListNode nextTemp = new ListNode(1);
            nextTemp.next = prev;
            prev = nextTemp;
            prev.val = cur.val;
            cur = cur.next;
        }
        ListNode nextTemp = new ListNode(cur.val);
        nextTemp.next = prev;
        return nextTemp;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

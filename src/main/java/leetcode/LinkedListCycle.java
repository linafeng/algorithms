package leetcode;

import java.util.*;

/**
 * 环形链表
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycle.ListNode testnode = new LinkedListCycle.ListNode(1);
        testnode.next = new LinkedListCycle.ListNode(2);
        testnode.next.next = new LinkedListCycle.ListNode(3);
        testnode.next.next.next = new LinkedListCycle.ListNode(4);
        testnode.next.next.next.next = new LinkedListCycle.ListNode(5);
        testnode.next.next.next.next.next=testnode.next;

        System.out.println(hasCycle(testnode));
        System.out.println(hasCycle2(testnode));
        System.out.println(hasCycle3(testnode));

        ListNode node=detectCycle(testnode);
        System.out.println(1);
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        Map<ListNode, Integer> map = new HashMap<>();
        boolean hasCycle = false;
        ListNode curr = head;
        while (Objects.nonNull(curr)) {
            if (Objects.nonNull(map.get(curr))) {
                hasCycle = true;
                break;
            }
            map.put(curr, curr.val);
            curr = curr.next;
        }
        return hasCycle;
    }

    /**
     * 同样是contains判断，set比list快一倍
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 双指针
     * 前后2个指针，如果不循环,快的必先到达尾部。
     * 每次走快一步，如果循环必追上
     * @param head
     * @return
     */
    public static boolean hasCycle3(ListNode head){
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 单指

     * 前后2个指针，
     * @param head
     * @return
     */
    public static boolean wrong(ListNode head){
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        boolean hasCycle=true;
        while (slow!=null) {
            if (slow.next == null ) {
                hasCycle=false;
                break;
            }
            slow = slow.next;

        }
        return hasCycle;
    }

    /**
     * 升级版。找入口节点
     * 第一次相遇
     * f为快的步数，s为慢的步数
     * f=s+nb， f=2s，得知f = 2nb，s =nb
     * 那么所有 走到链表入口节点时的步数 是：k=a+nb
     * slow指针 位置不变 ，将fast指针重新 指向链表头部节点 ；slow和fast同时每轮向前走 1步；
     * TIPS：此时 f = 0,s=nb ；
     * 当 fast 指针走到f = a 步时，slow 指针走到步s = a+nb，此时 两指针重合，并同时指向链表环入口 。第二次相遇了
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }


    public static  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

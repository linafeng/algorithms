package leetcode;

import java.util.Objects;

/**
 *按照k值每几个翻转一次
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode testnode = new ListNode(1);
        testnode.next = new ListNode(2);
        testnode.next.next = new ListNode(3);
        testnode.next.next.next = new ListNode(4);
        testnode.next.next.next.next = new ListNode(5);
        ListNode node= reverseKGroup(testnode,2);

        System.out.println(1);
    }

    /**
     * 这是错误的需求，这个是按照输入值指定从头开始到第k个翻转过来
     * @param head
     * @param k
     * @return
     */
    public static  ListNode reverseKGroup2(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode headNode=head;
        while (k>0&&curr != null) {
            ListNode nextTemp = curr.next;//先把后面的链子拷贝一份放一边
            curr.next = prev;//取用第一个值，将后面的链子替换为前置节点，（新尾部构造起，尾部next节点为空）
            prev = curr;//对前置节点赋值为当前节点，curr.next为新的链带到下次循环
            curr = nextTemp;//将当前节点赋值为备份的后面的链子用于新循环
            k--;

        }
        headNode.next=curr;
        return prev;
    }

    /**
     * 这是错误的需求，这个是按照输入值指定从头开始到第k个翻转过来
     * @param head
     * @param k
     * @return
     */
    public static  ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmpNode=head;
        for(int i=k;i>0;i--){
            if(Objects.isNull(tmpNode))
                return head;
            tmpNode=tmpNode.next;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode headNode=head;
        int i=k;

        while (i>0&&curr != null) {
            ListNode nextTemp = curr.next;//先把后面的链子拷贝一份放一边
            curr.next = prev;//取用第一个值，将后面的链子替换为前置节点，（新尾部构造起，尾部next节点为空）
            prev = curr;//对前置节点赋值为当前节点，curr.next为新的链带到下次循环
            curr = nextTemp;//将当前节点赋值为备份的后面的链子用于新循环
            i--;

        }
        headNode.next=reverseKGroup(curr,k);
        return prev;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

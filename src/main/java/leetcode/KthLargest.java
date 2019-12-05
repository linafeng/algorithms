package leetcode;

import java.util.PriorityQueue;

/**
 * 703 第k个最大值
 */
public class KthLargest {
    public static void main(String[] args) {
        int k=3;
        int [] nums=new int[]{1,8,5,4};
        KthLargest obj = new KthLargest(k, nums);
        int param_1 = obj.add(7);
        int param_2 = obj.add(8);
        int param_3 = obj.add(10);
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
    }

    final PriorityQueue<Integer> q;
    final int k;

    public KthLargest(int k, int[] a) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int n : a)
            add(n);
    }

    public int add(int n) {
        if (q.size() < k)
            q.offer(n);
        else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }
}

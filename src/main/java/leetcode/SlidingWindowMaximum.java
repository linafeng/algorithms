package leetcode;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,-1};//{-1, -3, 5, 4, 3,3,6, 7};
        int k = 1;
        SlidingWindowMaximum SlidingWindowMaximum=new SlidingWindowMaximum();
        int[] rs2 = SlidingWindowMaximum.maxSlidingWindow(nums, k);//answer code
        System.out.println(Arrays.toString(rs2));
    }

    /**
     * 优先级队列
     * 很慢
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] rs = new int[nums.length - k + 1];
        Queue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (i >= k - 1) {
                rs[i - k + 1] = queue.peek();
                queue.remove(nums[i - k + 1]);
            }
        }
        return rs;
    }
    public  void clean_deque(ArrayDeque<Integer> queue,int []nums,int curr) {
        while (!queue.isEmpty() && nums[curr] > nums[queue.getLast()]) {
            queue.removeLast();
        }
    }
    public  int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] rs = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>(k);
        for (int i = 0; i < nums.length; i++) {
            clean_deque(queue,nums,i);
            queue.addLast(i);
            if (i >= k - 1) {
                rs[i-k+1]=nums[queue.getFirst()];
                if(i-k+1>queue.getFirst()-1) {
                    queue.removeFirst();
                }
            }
        }
        return rs;
    }
}

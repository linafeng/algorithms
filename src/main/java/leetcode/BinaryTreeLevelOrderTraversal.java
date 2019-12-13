package leetcode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        if(root==null) return rs;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        queue.add(root);
        rs.add(Arrays.asList(root.val));
        while (!queue.isEmpty()) {
            TreeNode obj = queue.poll();
            addNodeData(nextQueue,list,obj);
            if(queue.isEmpty()){
                if(list.size()>0)  rs.add(list);
                queue=nextQueue;
                nextQueue=new LinkedList<>();
                list=new ArrayList<>();
            }
        }
        return rs;
    }

    public void addNodeData(Queue<TreeNode> queue,List<Integer> list, TreeNode obj) {
        if (obj.left != null) {
            queue.add(obj.left);
            list.add(obj.left.val);
        }
        if (obj.right != null) {
            queue.add(obj.right);
            list.add(obj.right.val);
        }
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: ${description}
 * @Author: lina.feng
 * @Date: 2020/5/25 12:38
 * @Version: 1.0
 */
public class SerializeBtree {
    public static void main(String[] args) {
        SerializeBtree tool = new SerializeBtree();
        TreeNode node = tool.deserialize("1,2,3,null,null,4,5");
        System.out.println(tool.serialize(node));
    }

    public String rserialize(TreeNode root, String str) {
        // Recursive serialization.
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }


    /*    public TreeNode rdeserialize(List<String> l) {
            // Recursive deserialization.
            if(l.size()==0){return null;}
            if (l.get(0).equals("null")) {
                l.remove(0);
                return null;
            }

            TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
            l.remove(0);
            root.left = rdeserialize(l);
            root.right = rdeserialize(l);

            return root;
        }*/
    public TreeNode rdeserialize(List<String> l) {
        // Recursive deserialization.
        if (l.size() == 0) {
            return null;
        }
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
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

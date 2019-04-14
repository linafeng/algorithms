package com.fiona.algorithms;
/**
 * 
 * <p>
 *  二叉查找树
 *  二叉搜索树
 * </p>
 * rights reserved.
 * </p>
 * <p>
 * CreateDate:2019年4月14日
 * </p>
 * 
 * @author fenglili
 * @history 创建文档；Mender:fenglili；Date:2019年4月14日；
 */
public class BinarySearchTree {
	private Node tree;  
	/**
	 * 查找
	 * 如果要查找的数小于 当前节点，返回左节点
	 * 如果要查找的数大于 当前节点，返回右节点
	 * @param data
	 * @return
	 * @author fenglili
	 * Date:2019年4月14日；
	 */
	public  Node find(int data) {  
		Node p = tree;   
		while (p != null) {  
			if (data < p.data) {
				p = p.left;  
			}else if (data > p.data) {
				p = p.right;    
			}else { 
				return p;
			}   
		}   
		return null; 
	}
	/**
	 * 插入
	 * @param data
	 * @author fenglili
	 * Date:2019年4月14日；
	 */
	public void insert(int data) { 
		if (tree == null) {   
			tree = new Node(data);   
			return; 
		} 
		Node p = tree; 
		while (p != null) { 
			if (data > p.data) {    
				if (p.right == null) {  
					p.right = new Node(data);  
					return;    
				}
				p = p.right; 
			} else {// data < p.data    
				if (p.left == null) { 
					p.left = new Node(data);  
					return;  
				}   
				p = p.left;   
			} 
		}
	} 
	/**
	 * 需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。然后再删除掉 这个最小节点
	 * @param data
	 * @author fenglili
	 * Date:2019年4月14日；
	 */
	public void delete(int data) { 
		Node p = tree;		// p指向要删除的节点，初始化指向根节点
		Node pp = null; // pp记录的是p的父节点
		while (p != null && p.data != data) {  
			pp = p;   
			if (data > p.data) {
				p = p.right;   
			}else 
			{
				p = p.left; 
			}
		}
		if (p == null) 	return; // 没有找到  
		// 要删除的节点有两个子节点
		if (p.left != null && p.right != null) { // 查找右子树中最小节点  
			Node minP = p.right;   
			Node minPP = p; // minPP表示minP的父节点  
			while (minP.left != null) {   
				minPP = minP;    
				minP = minP.left;   
			}   
			p.data = minP.data; // 将minP的数据替换到p中  
			p = minP; // 下面就变成了删除minP了    
			pp = minPP; 
		}  
		// 删除节点是叶子节点或者仅有一个子节点 
		Node child; // p的子节点  
		if (p.left != null) {
			child = p.left; 
		} else if (p.right != null) {
			child = p.right; 
		}else {
			child = null; 
			if (pp == null) {
				tree = child;		// 删除的是根节点 
			}else if (pp.left == p) { 
				pp.left = child; 
			}else {
				pp.right = child; 
			} 
		}
	}
	/**
	 * 找最小节点
	 * @return
	 * @author fenglili
	 * Date:2019年4月14日；
	 */
	public Node findMin() {
		if (tree == null) return null;
		Node p = tree;
		while (p.left != null) {
			p = p.left;
		}
		return p;
	}
	/**
	 * 找最大节点
	 * @return
	 * @author fenglili
	 * Date:2019年4月14日；
	 */
	public Node findMax() {
		if (tree == null) return null;
		Node p = tree;
		while (p.right != null) {
			p = p.right;
		}
		return p;
	}


	public static class Node {  
		private int data;   
		private Node left;   
		private Node right;   
		public Node(int data) {    
			this.data = data;  
		} 

	} 

	public static void main(String[] args) {
		Node node15=new Node(15);
		Node node17=new Node(17);
		Node node19=new Node(19);
		Node node27=new Node(27);

		Node node50=new Node(50);

		Node node25=new Node(25);
		node25.left=node19;
		node25.right=node27;

		Node node18=new Node(18);
		node18.left=node17;
		node18.right=node25;

		Node node16=new Node(16);
		node16.left=node15;
		node16.right=node18;

		Node node33=new Node(33);
		node33.left=node16;
		node33.right=node50;

		
		BinarySearchTree tree=new BinarySearchTree();
		tree.tree=node33;
		System.out.println(tree.find(16).data);
		System.out.println("最小的"+tree.findMin().data);
		System.out.println("最大的"+tree.findMax().data);

		tree.delete(18);

		System.out.println(tree);


	}

}

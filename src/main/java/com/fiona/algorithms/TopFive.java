package com.fiona.algorithms;

import java.util.PriorityQueue;
/**
 * 
 * <p>
 *  优先级队列实现top5
 * </p>
 * rights reserved.
 * </p>
 * <p>
 * CreateDate:2019年4月28日
 * </p>
 * 
 * @author fenglili
 * @history 创建文档；Mender:fenglili；Date:2019年4月28日；
 */
public class TopFive {

	public static void main(String[] args) {
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>(5);//除了传数量还可以传排序规则
		queue.add(3);
		queue.add(6);
		queue.add(8);
		queue.add(1);
		queue.add(4);
		int num=2;
		/*if(queue.peek()<num) {
			queue.poll();
			queue.add(num);
		}*/
		if(queue.peek()<num) {
			queue.poll();
			queue.add(num);
		}
		queue.remove();
		
		System.out.println(queue.peek());		
		System.out.println(queue.size());
		//queue.add(3);

	}

}

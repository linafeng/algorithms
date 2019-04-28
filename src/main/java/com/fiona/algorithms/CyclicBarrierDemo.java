package com.fiona.algorithms;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * 
 * <p>
 *  并发工具类之排队上车，人满发车
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
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier CyclicBarrier=new CyclicBarrier(1,()-> {
			System.out.println("发车");
		});
		System.out.println(1);
		try {
			CyclicBarrier.await();
			System.out.println(2);
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

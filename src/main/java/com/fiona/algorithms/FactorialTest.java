package com.fiona.algorithms;

import java.math.BigDecimal;
/**
 * 阶乘测试
 * <p>
 *  module
 * </p>
 * @author lina.feng
 * @history Mender:lina.feng；Date:2019年3月22日；
 */
public class FactorialTest {

	public static void main(String[] args) {
		showMemInfo();

		test1();
		test2();



	}
	/**
	 * 自实现
	 */
	public static void test1() {
		long time1=System.currentTimeMillis();
		int nums=1000;
		int len=5000;
		int[] arr=new int[len];	
		arr[len-1]=1;
		for(int i=1;i<=nums;i++) {
			arr=bigDataMultiple(arr, i);
		}
		System.out.println((System.currentTimeMillis()-time1)+"ms");
		showMemInfo();
		/*boolean find=false;
		for(int e:arr) {
			if(find) {
				System.out.print(e);
			}else if(e!=0){
				find=true;
				System.out.print(e);

			}
		}*/
	}
	/**
	 * java bigdecimal
	 */
	public static void test2() {
		long time=System.currentTimeMillis();
		BigDecimal n=BigDecimal.valueOf(1000);
		BigDecimal num=BigDecimal.valueOf(1);
		for(long i=1;i<=n.longValue();i++) {
			num=num.multiply(BigDecimal.valueOf(i));
		}
		System.out.println((System.currentTimeMillis()-time)+"ms");
		//System.out.println(num);
		showMemInfo();
	}
	public static int[] bigDataMultiple(int[]arr,int n) {
		for(int i=0;i<arr.length;i++) {
			arr[i]*=n;
		}
		for(int i=arr.length-1;i>0;i--) {
			arr[i-1]+=arr[i]/10;
			arr[i]=arr[i]%10;

		}
		return arr;
	}


	public static void showMemInfo() {
		// 已分配内存中的剩余空间 ：
		long free = Runtime.getRuntime().freeMemory();
		// 分配内存：
		long total = Runtime.getRuntime().totalMemory();
		// 最大内存：
		long max = Runtime.getRuntime().maxMemory();
		// 已占用的内存：

		long used = total - free;

		System.out.println("\n 最大内存 = " + max/1024+"KB");
		System.out.println("已分配内存 = " + total/1024+"M");
		System.out.println("已分配内存中的剩余空间 = " + free/1024+"KB");
		System.out.println("已用内存 = " + used/1024+"kb");
		System.out.println("时间 = " + System.currentTimeMillis());
		System.out.println("");
	}


}

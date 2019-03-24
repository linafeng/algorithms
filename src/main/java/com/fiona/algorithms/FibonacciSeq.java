package com.fiona.algorithms;
/**
 * 斐波拉契数列
 * @author Administrator
 *
 */
public class FibonacciSeq {

	public static void main(String[] args) {
		//1,1,2,3,5,8,13
		System.out.println(getResultByLoop(4));
		System.out.println(getResultByRecursive(4));
	}
	/**
	 * 循环实现
	 * 性能好
	 * @param n
	 * @return
	 */
	public static int getResultByLoop(int n) {
		int num1=1;
		int num2=1;
		int num3=0;
		for(int i=2;i<n;i++) {
			num3=num1+num2;
			num1=num2;
			num2=num3;
		}
		return num3;
	}
	/**
	 * 递归实现
	 * 性能差
	 * @param n
	 * @return
	 */
	public static int getResultByRecursive(int n) {
		if(n<3) {
			return 1;
		}else {
			return getResultByRecursive(n-1)+getResultByRecursive(n-2);
		}
	}


}

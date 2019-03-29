package com.fiona.algorithms;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 *  module
 * </p>
 * @author lina.feng
 * @history Mender:lina.feng；Date:2019年3月25日；
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] arr= {5,3,7,1,4};
		//insertsort(arr);
		int[] arr2= {2,3,6,7,4,8,9};
		insertsort2(arr2);
		//System.out.println(Arrays.toString(arr));

	}
	/**
	 * 三重循环
	 *  思想。
	 * i向右走，如果遇到前一个比i大的。则另起一个循环，
	 * j从0开始找找到比i大的话，则将i位置的数拿出来放临时变量，j位置开始到i-1位置向后平移一位，然后再讲临时变量放到j位置
	 * 原来{5,3,7,1,4
	 *[3, 5, 7, 1, 4]
	 *[1, 3, 5, 7, 4]
	 *[1, 3, 4, 5, 7]
	 * @param arr
	 */
	public static void insertsort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<arr[i-1]) {//i位置需要插入到前面
				for(int j=0;j<i;j++) {
					if(arr[i]<arr[j]) {//找到插入位置
						int temp=arr[i];
						for(int k=i-1;k>=j;k--) {
							arr[k+1]=arr[k];
						}
						arr[j]=temp;
						System.out.println(Arrays.toString(arr));
						//break;
					}
				}
			}
		}

	}
	/**
	 * 两重循环
	 *  思想。
	 * i向右走，如果遇到前一个比i大的。则另起一个循环，
	 * 因为j需要在左边找到比i大的，所以从左往右遍历可以把比i大但相对小的数先找出来j从0开始找找到比i大的话，
	 * 原来{2,3,6,7,4,8,9};
	 *[2, 3, 4, 7, 6, 8, 9]
	 *[2, 3, 4, 6, 7, 8, 9]
	 * @param arr
	 */
	public static void insertsort2(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<arr[i-1]) {//i位置需要插入到前面
				for(int j=0;j<=i-1;j++) {
					if(arr[i]<arr[j]) {//找到插入位置
						arr[i]=arr[i]^arr[j];
						arr[j]=arr[i]^arr[j];
						arr[i]=arr[i]^arr[j];
						System.out.println(Arrays.toString(arr));
					}
				}
			}
		}

	}

}

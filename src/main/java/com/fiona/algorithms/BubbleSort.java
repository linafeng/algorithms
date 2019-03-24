package com.fiona.algorithms;

import java.util.Arrays;

/**
 * 冒泡排序
 * 原理：比较两个相邻的元素，将值大的元素交换至右端。
 * 交换 如：A=A^B;B=A^B;A=A^B;
 * 原理：利用一个数异或本身等于０和异或运算符合交换率。
 * @author Administrator
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int arr[]= {8,7,6,5,4};
		System.out.println(Arrays.toString(bubblesort(arr)));

	}
	public static int[] bubblesort(int[] arr){
		for(int i=0;i<arr.length-1;i++){//外层循环控制排序趟数，规律5个数走4趟
			for(int j=0;j<arr.length-1-i;j++){//内层循环控制每一趟排序多少次
				if(arr[j]>arr[j+1]){
					arr[j]=arr[j]^arr[j+1];
					arr[j+1]=arr[j]^arr[j+1];
					arr[j]=arr[j]^arr[j+1];
				}
			}
			System.out.print("第"+(i+1)+"次排序后的结果:");
			for(int k=0;k<arr.length;k++){
				System.out.print(arr[k]+" ");
			}
			System.out.println("");
		}
		return arr;

	}

}

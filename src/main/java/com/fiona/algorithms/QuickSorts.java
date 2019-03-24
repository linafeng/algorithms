package com.fiona.algorithms;

import java.util.Arrays;

/**
 * 快速排序
 * @author Administrator
 *
 */
public class QuickSorts {

	public static void main(String[] args) {
		int arr[]= {5,3,8,6};
		System.out.println(Arrays.toString(quicksort(arr)));

	}
	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] quicksort(int[] arr) {
		//j先走发现比标示小的就抛给i;
		//i开始走，发现比标示大的就抛给j
		int num=arr[0];//标杆
		int i=0;
		int j=arr.length-1;
		while(i<j) {
			if(arr[j]<num) {
				arr[i]=arr[i]^arr[j];
				arr[j]=arr[i]^arr[j];
				arr[i]=arr[i]^arr[j];
				continue;
			}
			j--;
			
		}
		while(i<j) {
			if(arr[i]>=num) {
				arr[i]=arr[i]^arr[j];
				arr[j]=arr[i]^arr[j];
				arr[i]=arr[i]^arr[j];
				continue;
			}
			i++;
			
		}
		return arr;

	}

}

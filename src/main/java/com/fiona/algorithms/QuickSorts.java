package com.fiona.algorithms;

import java.util.Arrays;

/**
 * 快速排序
 * @author Administrator
 *
 */
public class QuickSorts {

	public static void main(String[] args) {
		int[] arr= {5,3,7,1,8,2,9,4,6,0};
		quicksort(arr,0,arr.length-1);
	}
	/**
	 * 
	 * @param arr
	 * @return
	 */
	public static void quicksort(int[] arr,int s,int e) {
		int num=arr[s];//标杆
		int i=s;
		int j=e;
		while(i<j) {
			while(i<j) {
				if(arr[j]<num) {//j负责找小的，扔给i
					arr[i]=arr[j];
					break;
				}
				j--;
			}
			while(i<j) {
				if(arr[i]>=num) {//i负责找大的,扔给j
					arr[j]=arr[i];				
					break;
				}
				i++;
			}
		}
		arr[i]=num;
		System.out.println("排序后"+Arrays.toString(arr));
		//递归
		if(i>s) {
			quicksort(arr,s,i-1);//左边序列。第一个索引位置到关键值索引-1
		}else if(j<e) {
			quicksort(arr,j+1,e);//右边序列。从关键值索引+1到最后一个
		}
		


	}


}

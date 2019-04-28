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
		int i=s;
		int num=arr[i];//标杆
		System.out.println("标杆"+num);
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
			System.out.println("左边序号间隔["+s+"-"+(i-1)+"]开始排序");
			quicksort(arr,s,i-1);//左边序列。第一个索引位置到关键值索引-1
		}
		if(j<e) {
			System.out.println("右边序号间隔["+(j+1)+"-"+(e)+"]开始排序");
			quicksort(arr,j+1,e);//右边序列。从关键值索引+1到最后一个
		}

	}

}

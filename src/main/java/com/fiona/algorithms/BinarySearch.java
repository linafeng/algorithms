package com.fiona.algorithms;
/**
 * 
 * @author Administrator
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr= {1,2,4,6,9,13,24};
		int tatget=9;
		int s=0;//start
		int e=arr.length-1;//end
		int m=0;//middle
		while(s<=e) {
			m=(s+e)/2;
			if(tatget==arr[m]) {
				System.out.println("find:"+m);
				return;
			}else if(tatget<arr[m]) {//left
				e=m-1;
			}else {//right
				s=m+1;
			}
		}
		System.err.println("not exists");

	}

}

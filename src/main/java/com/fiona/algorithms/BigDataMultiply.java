package com.fiona.algorithms;
/**
 * 两个大数字相乘
 * <p>
 *  module
 * </p>
 * @author lina.feng
 * @history Mender:lina.feng；Date:2019年3月22日；
 */
public class BigDataMultiply {

	public static void main(String[] args) {
		int [] k=bigDataMultiple(new int[]{1,2,3},new int[]{6});
		for(int e:k) {
			System.out.print(e);
		}

	}
	public static int[] bigDataMultiple(int[]arr1,int arr2[]) {
		int len=arr1.length+arr2.length+1;
		int[] arr3=new int[len];
		int offset=len-arr1.length;
		for(int q=arr2.length-1;q>=0;q--) {
			for(int i=arr1.length-1;i>=0;i--) {
				arr3[i+offset-(arr2.length-1-q)]+=arr1[i]*arr2[q]*Math.pow(10, (arr2.length-1-q));
				for(int k=arr1.length-1;k>0;k--) {
					arr3[k-1]+=arr3[k]/10;
					arr3[k]=arr3[k]%10;
				}

			}
		}

		return arr3;
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

}

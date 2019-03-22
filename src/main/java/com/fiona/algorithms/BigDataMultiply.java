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
		int [] k=bigDataMultiple(new int[]{1,2,3},new int[]{6,1});
		for(int e:k) {
			System.out.print(e);
		}

	}
	public static int[] bigDataMultiple(int[]arrI,int arrQ[]) {
		int len=arrI.length+arrQ.length+1;
		int[] rs=new int[len];
		int offset=len-arrI.length;
		for(int q=arrQ.length-1;q>=0;q--) {
			for(int i=arrI.length-1;i>=0;i--) {
				rs[i+offset-(arrQ.length-1-q)]+=arrI[i]*arrQ[q];
			}
			for(int k=rs.length-1;k>0;k--) {
				rs[k-1]+=rs[k]/10;
				rs[k]=rs[k]%10;
			}
		}
		return rs;
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

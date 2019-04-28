package com.fiona.algorithms;
/**
 *
 * <p>
 *   选择排序
 * </p>
 * @author lina.feng
 * @history Mender:lina.feng；Date:2019年4月28日；
 */
public class SelectionSorts {

	public static void main(String[] args) {
		int[] arr={1,3,2,45,65,33,12};
		System.out.println("交换之前:");
		for(int num:arr){
			System.out.print(num+" ");
		}     
		System.out.println();
		//选择排序的优化
		for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
			int k = i;			
			for(int j = i+1; j < arr.length; j++){// 选最小的记录
				if(arr[j] < arr[k]){ 
					k = j; //记下目前找到的最小值所在的位置
				}
			}
			//在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
			if(i != k){//不等于表示有找到比标杆小记录  //交换a[i]和a[k]
				arr[i]=arr[i]^arr[k];
				arr[k]=arr[i]^arr[k];
				arr[i]=arr[i]^arr[k];
			} 
			System.out.print("第"+(i+1)+"轮排序后");
			for(int num:arr){
				System.out.print(num+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("交换后：");
		for(int num:arr){
			System.out.print(num+" ");
		}
	}


}

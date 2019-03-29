package com.fiona.algorithms;
/**
 * 二分查找
 * 已经排好序，用中间数减少查找区间
 * @author Administrator
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] arr1={1,3,4,6,9,13,24};
		System.out.println(bsearch(arr1,arr1.length,9));
		int[] arr2={1,3,4,6,9,9,9,24};
		System.out.println(bsearch1(arr2,arr2.length,9));
		System.out.println(bsearch2(arr2,arr2.length,9));
		System.out.println(bsearch3(arr2,arr2.length,9));
		System.out.println(bsearch4(arr2,arr2.length,24));
		/*int tatget=9;
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
		System.err.println("not exists");*/
		
		

	}
	/**
	 * 标准二分查找，在有序集合中不存在重复数据
	 * {1,3,4,6,9,13,24};
	 *  目标值9
	 * 结果是4
	 * @param arr
	 * @param n
	 * @param target
	 * @return
	 */
	public static  int bsearch(int[] arr, int n, int target) {
		int s = 0;
		int e = n - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) {//右
				s = mid + 1;
			} else {//左边
				e = mid - 1;
			}
		}
		return -1;
	}
	/**
	 * 变体一:有序数据集合中存在重复的数据，查找第一个值等于目标值的位置
	 *  {1,3,4,6,9,9,13,24};
	 *   目标值9
	 *  结果4
	 * @param a
	 * @param n
	 * @param target
	 * @return
	 */
	public static int bsearch1(int[] a, int n, int target) {
		int s = 0;
		int e = n - 1;
		while (s <= e) {
			//System.out.println("e="+e +"s="+s);
			int mid = s + ((e - s) >> 1);//((e - s) >> 1)等7=111 >>1 ==11即3
			//System.out.println("m="+mid);
			if (a[mid] > target) {
				e = mid - 1;
			} else if (a[mid] < target) {
				s = mid + 1;
			} else {
				if ((mid == 0) || (a[mid - 1] != target)) return mid;//因为有序，所以前一个不是就直接返回
				else e = mid - 1;
			}
		}
		return -1;
	}
	/**
	 * 变体二:有序数据集合中存在重复的数据，查找最后一个值等于目标值的位置
	 *  {1,3,4,6,9,9,9,24};
	 *  结果6
	 * @param a
	 * @param n
	 * @param target
	 * @return
	 */
	public static int bsearch2(int[] a, int n, int target) {
		int s = 0;
		int e = n - 1;
		while (s <= e) {
			int mid = s + ((e - s) >> 1);
			if (a[mid] > target) {
				e = mid - 1;
			} else if (a[mid] < target) {
				s = mid + 1;
			} else {
				if ((mid == 0) || (a[mid +1] != target)) return mid;//因为有序，所以前一个不是就直接返回
				else s = mid + 1;
			}
		}
		return -1;
	}
	/**
	 * 变体三:有序数据集合中存在重复的数据，查找第一个值大于目标值的位置
	 *  {1,3,4,6,9,9,9,24};
	 *  目标值9
	 *  结果7
	 * @param a
	 * @param n
	 * @param target
	 * @return
	 */
	public static int bsearch3(int[] a, int n, int target) {
		int s = 0;
		int e = n - 1;
		while (s <= e) {
			int mid = s + ((e - s) >> 1);
			if (a[mid] > target) {
				e = mid - 1;
			} else if (a[mid] < target) {
				s = mid + 1;
			} else {
				if ((mid == 0) || (a[mid +1] != target)) return mid +1;//因为有序，所以前一个不是就直接返回
				else s = mid + 1;
			}
		}
		return -1;
	}
	/**
	 * 变体四:有序数据集合中存在重复的数据，查找最后一个值小于目标值的位置
	 *  {1,3,4,6,9,9,9,24};
	 *  目标值24
	 *  结果6
	 * @param a
	 * @param n
	 * @param target
	 * @return
	 */
	public static int bsearch4(int[] a, int n, int target) {
		int s = 0;
		int e = n - 1;
		while (s <= e) {
			int mid = s + ((e - s) >> 1);
			if (a[mid] > target) {
				e = mid - 1;
			} else if (a[mid] < target) {
				s = mid + 1;
			} else {
				if ((mid == 0) || (a[mid -1] != target)) return mid -1;//因为有序，所以前一个不是就直接返回
				else e = mid - 1;
			}
		}
		return -1;
	}


}

package com.fiona.algorithms;
/**
 * 小写放前面，数字放中间，大写放后面，字母间不排序
 * <p>
 *  module
 * </p>
 * @author lina.feng
 * @history Mender:lina.feng；Date:2019年3月29日；
 */
public class Test1 {

	public static void main(String[] args) {
		char[] arr= {'E','a','h','J','5','g'};
		System.out.println((int)'a');
		System.out.println((int)'A');
		System.out.println(sorts(arr));
	}
	public static char[] sorts(char[] arr) {
		StringBuilder aBuilder=new StringBuilder();
		StringBuilder bBuilder=new StringBuilder();
		StringBuilder cBuilder=new StringBuilder();
		for(char e:arr) {
			int i=(int)e;
			if(i>96) {
				aBuilder.append(e);
			}else if(i>64){
				cBuilder.append(e);
			}else {
				bBuilder.append(e);
			}
		}
		return (aBuilder.toString()+bBuilder.toString()+cBuilder.toString()).toCharArray();
	}

}

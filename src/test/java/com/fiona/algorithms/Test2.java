package com.fiona.algorithms;

import java.util.Random;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
	/*	SnowFlakeGenerator.Factory factory=new SnowFlakeGenerator.Factory();
		SnowFlakeGenerator generator = factory.create(6, 5);
		for(int i = 0; i < 10000; i++) {
			Thread.sleep(100);
			System.out.println(generator.nextId());
		}*/
		int a=5,b=6;
		a=a^b;
		b=a^b;
		System.out.println(a);
		System.out.println(b);
		Random random=new Random();
		System.out.println(random.nextInt(100));
		System.out.println(Math.random());
		
		
		
	}
	

}

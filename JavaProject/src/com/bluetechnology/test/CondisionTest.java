package com.bluetechnology.test;

import java.util.ArrayList;
import java.util.List;

public class CondisionTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long t;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ;i <=200000;i++){
			if(i%2==0){
				continue;
			}
			list.add(i);
		}
		t = System.currentTimeMillis();
		for (Integer integer : list) {
			if(integer%2!=0){
				
			}
			else{
				
			}
		}
		t = (System.currentTimeMillis()-t);
		System.out.println(t);
		
	}
}

package com.bluetechnology.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListAddTest {
	//資料大小
	int dataSize = 100000;
	// 紀錄開始時間
	long[]			testBaginTime	= new long[4];
	// 紀錄結束時間
	long[]			testEndTime		= new long[4];
	// 基本資料長度
	Integer[]		ia				= new Integer[dataSize];
	// 初始化隨機物件
	Random			random			= new Random();
	// 初始化ArrayList
	List<Integer>	arraylist		= null;
	// 初始化linkList
	List<Integer>	linklist		= null;
	
	{
		// 初始化ia陣列資料
		for (int i = 0; i < ia.length; i++) {
			ia[i] = i;
		}
		arraylist = new ArrayList<Integer>(Arrays.asList(ia));
		linklist = new LinkedList<Integer>(Arrays.asList(ia));
	}

	void testListRandomQuery() {
		testBaginTime[0] = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			arraylist.get(random.nextInt(dataSize));
		}
		testEndTime[0] = System.currentTimeMillis();
		testBaginTime[1] = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			linklist.get(random.nextInt(dataSize));
		}
		testEndTime[1] = System.currentTimeMillis();
		System.out.println("ArrayList time : " + ((testEndTime[0] - testBaginTime[0]) / 1000) + " sec");
		System.out.println("LinkedList time : " + ((testEndTime[1] - testBaginTime[1]) / 1000) + " sec");
	};

	void testListModify() {
	};

	public static void main(String[] args) throws InterruptedException {
		new ListTest().testListRandomQuery();
	}
}

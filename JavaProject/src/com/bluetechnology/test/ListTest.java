package com.bluetechnology.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListTest {
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
		testBaginTime[0] = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			arraylist.add(random.nextInt(dataSize),i);
		}
		testEndTime[0] = System.currentTimeMillis();
		testBaginTime[1] = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			linklist.add(random.nextInt(dataSize),i);
		}
		testEndTime[1] = System.currentTimeMillis();
		System.out.println("ArrayList time : " + ((testEndTime[0] - testBaginTime[0]) / 1000) + " sec");
		System.out.println("LinkedList time : " + ((testEndTime[1] - testBaginTime[1]) / 1000) + " sec");
	};
	
	void testListAdd() {
		testBaginTime[0] = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			arraylist.add(i,random.nextInt(dataSize));
		}
		testEndTime[0] = System.currentTimeMillis();
		testBaginTime[1] = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			linklist.add(i,random.nextInt(dataSize));
		}
		testEndTime[1] = System.currentTimeMillis();
		System.out.println("ArrayList time : " + ((testEndTime[0] - testBaginTime[0]) / 1000) + " sec");
		System.out.println("LinkedList time : " + ((testEndTime[1] - testBaginTime[1]) / 1000) + " sec");
	};
	
	void testListHeadAdd(){
		testBaginTime[0] = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			arraylist.add(0,random.nextInt(dataSize));
		}
		testEndTime[0] = System.currentTimeMillis();
		testBaginTime[1] = System.currentTimeMillis();
		for (int i = 0; i < dataSize; i++) {
			linklist.add(0,random.nextInt(dataSize));
		}
		testEndTime[1] = System.currentTimeMillis();
		System.out.println("ArrayList time : " + ((testEndTime[0] - testBaginTime[0]) / 1000) + " sec");
		System.out.println("LinkedList time : " + ((testEndTime[1] - testBaginTime[1]) / 1000) + " sec");
	}

	public static void main(String[] args) throws InterruptedException {
//		// 紀錄list查詢資料時間
//		long[] testBaginTime = new long[4];
//		// 紀錄list插入資料時間
//		long[] testEndTime = new long[4];
//		// 基本資料長度
//		Integer[] ia = new Integer[5000];
//		// 初始化ia陣列資料
//		for (int i = 0; i < ia.length; i++) {
//			ia[i] = i;
//		}
//		// 初始化隨機物件
//		Random random = new Random();
//		// 初始化ArrayList
//		List<Integer> arraylist = new ArrayList<Integer>(Arrays.asList(ia));
//		// 初始化linkList
//		List<Integer> linklist = new LinkedList<Integer>(Arrays.asList(ia));
//		// 查詢ArrayList
//		testBaginTime[0] = System.currentTimeMillis();
//		for (int i = 0; i < 2000000; i++) {
//			// 測試加入資料時機間
//			// arraylist.get(i);
//			/*
//			 * 測試隨機加入 array list time : 9 sec array link time : 3 sec
//			 */
//			arraylist.add(random.nextInt(5000), i);
//			/*
//			 * 測試隨機讀取array list time : 0 sec array link time : 4 sec
//			 */
//			// arraylist.get(random.nextInt(5000));
//			/*
//			 * 測試順序加入array list time : 3 sec array link time : 18 sec
//			 */
//			// arraylist.add(i, i);
//			/*
//			 * 測試隨機設定array list time : 0 sec array link time : 4 sec
//			 */
//			arraylist.set(random.nextInt(5000), i);
//			// hashmap.put(i, i);
//		}
//		testEndTime[0] = System.currentTimeMillis();
//		testBaginTime[1] = System.currentTimeMillis();
//		for (int i = 0; i < 2000000; i++) {
//			// 測試加入資料時機間
//			// linklist.get(i);
//			// 測試隨機加入
//			linklist.add(random.nextInt(5000), i);
//			// linklist.get(random.nextInt(5000));
//			// linklist.add(i, i);
//			// linklist.set(random.nextInt(5000), i);
//			// linklist.remove(random.nextInt(1000));
//			// linkedmap.put(i, i);
//		}
//		testEndTime[1] = System.currentTimeMillis();
//		System.out.println("array list time : " + ((testEndTime[0] - testBaginTime[0]) / 1000) + " sec");
//		System.out.println("array link time : " + ((testEndTime[1] - testBaginTime[1]) / 1000) + " sec");
//		System.out.println("array list sort time : " + (testEndTime[2] - testBaginTime[2]));
		// System.out.println("array link sort time : " + (testEndTime[3] - testBaginTime[3]));
		new ListTest().testListHeadAdd();
	}
}

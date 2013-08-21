package com.bluetechnology.test.Collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Random radom = new Random(45);
		for (int i = 0; i < 10; i++) {
			int temp = radom.nextInt(i + 10);
//			priorityQueue.offer(temp);
		}
		QueueDemo.printQ(priorityQueue);
		List<Integer> ints = Arrays.asList(25, 30, 15, 40, 11, 32);
		priorityQueue = new PriorityQueue<Integer>(ints);
//		QueueDemo.printQ(priorityQueue);
		
		String fact = "This is a good student";
		Set<Character> charSet = new HashSet<Character>();
		for(char c :fact.toCharArray()){
			charSet.add(c);
		}
		PriorityQueue<Character> priorityQueue2 = new PriorityQueue<Character>(charSet);
		QueueDemo.printQ(priorityQueue2);
	}
}

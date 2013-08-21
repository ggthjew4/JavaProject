package com.bluetechnology.test.Collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
	public static void printQ(Queue<?> queue) {
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

	public static void main(final String argp[]) {
		final Queue<Integer> linkedList = new LinkedList<Integer>();
		final Random r = new Random(47);
		for (int i = 0; i < 10; i++) {
			linkedList.offer(r.nextInt(i + 10));
		}
//		System.out.println(linkedList);
		printQ(linkedList);
	}
}

package com.sample.example.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

import com.sample.example.model.Order;
import com.sample.example.util.StatusEnum;

public class Consumer implements Runnable {
	private final BlockingQueue<Order> sharedQueue;
	private final String threadName;
	private final CountDownLatch count;

	public Consumer(BlockingQueue<Order> sharedQueue, String threadName,
			CountDownLatch count) {
		this.sharedQueue = sharedQueue;
		this.threadName = threadName;
		this.count = count;
	}

	public void run() {
		int i = 0;

		try {

			Order item = sharedQueue.take();
			item.setStatus(StatusEnum.CONSUMED);
			System.out.println("Thread name " + threadName + "Consumed: index "
					+ i++ + " " + item);
			count.countDown();
		} catch (InterruptedException ex) {

		}

	}

}

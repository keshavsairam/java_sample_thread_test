package com.sample.example.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import com.sample.example.model.Order;
import com.sample.example.util.StatusEnum;

public class Worker implements Runnable {
	private final BlockingQueue<Order> sharedQueue;

	public Worker(BlockingQueue<Order> sharedQueue) {
		this.sharedQueue = sharedQueue;

	}

	public void run() {

		int i = 0;
		while (true) {
			try {
				Order item = new Order();
				item.setOrdernum("Order no" + i++);
				item.setStatus(StatusEnum.CREATED);
				sharedQueue.put(item);
				System.out.println("Order::" + item.getStatus() + "i ::" + i);
				if (i == 10) {
					i = 0;
					break;
				}

			} catch (InterruptedException ex) {

			}
		}

	}

}

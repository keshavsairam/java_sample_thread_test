package com.sample.example.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import com.sample.example.model.Order;

public class TestWorker {
	public static void main(String[] args) {
		// Creating shared object
		BlockingQueue<Order> sharedQueue = new LinkedBlockingQueue<Order>();

		ExecutorService executor = Executors.newCachedThreadPool();
		CountDownLatch count = new CountDownLatch(10);
		executor.execute(new Worker(sharedQueue));
		for (int i = 0; i <= 10; i++) {

			executor.execute(new Consumer(sharedQueue, "Thread " + i, count));
		}

		executor.shutdownNow();
		while (!executor.isTerminated()) {

		}
		System.out.println("shutdown");

	}
}

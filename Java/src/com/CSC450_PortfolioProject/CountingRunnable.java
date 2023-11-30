package com.CSC450_PortfolioProject;

import java.util.concurrent.CountDownLatch;

public class CountingRunnable implements Runnable {
	
	int start = 0;
	int end = 0;
	int increment = 1;
	CountDownLatch latch;

	public CountingRunnable(CountDownLatch latch) {
		super();
		this.latch = latch;
	}

	public CountingRunnable(CountDownLatch latch, int start, int end) {
		super();
		this.start = start;
		this.end = end;
		this.latch = latch;
	}

	public CountingRunnable(CountDownLatch latch, int start, int end, int increment) {
		super();
		this.start = start;
		this.end = end;
		this.increment = increment;
		this.latch = latch;
	}

	@Override
	public void run() {
		
		//set increment
		if(start > end && increment > 0) {
			increment *= -1;
		}
		
		// Count
		for (int i = start; i != (end + increment); i+=increment) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second to simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
		latch.countDown();
	}

}

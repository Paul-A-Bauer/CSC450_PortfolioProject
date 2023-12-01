package com.CSC450_PortfolioProject;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		//Set number of threads to be used
		int totalThreads = 2;
		
		// Create an ExecutorService with a fixed thread pool of size 2
        ExecutorService executorService = Executors.newFixedThreadPool(totalThreads);
        CountDownLatch latch = new CountDownLatch(1);

        // Submit the first thread for execution
        executorService.submit(new CountingRunnable(latch, 0, 20));

        try {
			latch.await();
		} catch (InterruptedException e) {
			// Print messagef
			e.printStackTrace();
		}

        // Submit the second thread for execution
        executorService.submit(new CountingRunnable(latch, 20, 0));

        // Shut down the ExecutorService
        executorService.shutdown();

	}

}

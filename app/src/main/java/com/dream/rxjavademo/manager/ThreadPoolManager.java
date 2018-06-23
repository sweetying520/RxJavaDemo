package com.dream.rxjavademo.manager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by luoxinwu on 2018/3/13.
 * desc：线程池管理类
 */

public class ThreadPoolManager {
	private static final ThreadPoolManager S_THREAD_POOL_MANAGER = new ThreadPoolManager();
	private ExecutorService mThreadPool;

	private ThreadPoolManager(){
		int coreNum = Runtime.getRuntime().availableProcessors();
		mThreadPool = Executors.newFixedThreadPool(coreNum);
	}

	public static ThreadPoolManager getInstance(){
		return S_THREAD_POOL_MANAGER;
	}

	public void submit(Runnable task){
		mThreadPool.execute(task);
	}

}

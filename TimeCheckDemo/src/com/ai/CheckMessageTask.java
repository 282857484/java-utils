package com.ai;

import java.util.Calendar;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @author  作者 “WTF” E-mail: 1031248990@qq.com
 * @date 创建时间：2016年11月18日 下午5:19:47 
 * @version 
 * @since  
 */
public class CheckMessageTask extends TimerTask {

	// 处理线程池
	public static ExecutorService handlePool;
	
	private ConcurrentLinkedQueue<TimeObj> taskQueue;

	
	public CheckMessageTask(ConcurrentLinkedQueue<TimeObj> taskQueue) {
		super();
		this.taskQueue = taskQueue;
	}


	@Override
	public void run() {
		System.out.println("CheckMessageTask run ...");
		int POOL_SIZE = 100;
		long now = Calendar.getInstance().getTimeInMillis();
		// 处理线程池
		handlePool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * POOL_SIZE);
		System.out.println("Thread pool size"+Runtime.getRuntime().availableProcessors() * POOL_SIZE);
		boolean flag = true;
		while(flag){
			TimeObj timeObj  = taskQueue.peek();
			if(timeObj != null){
				if(timeObj.endTime <= now){
					System.out.println("find a expired object...");
					if(taskQueue.remove(timeObj)){
						handlePool.execute(new handleExpiredObj(timeObj));
					}
				} else {
					flag = false;
				}
			} else {
				flag = false;
			}
		}
	}

}

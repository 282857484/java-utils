package com.ai;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author 作者 “WTF” E-mail: 1031248990@qq.com
 * @date 创建时间：2016年11月17日 下午8:35:31
 * @version
 * @since
 */
public  class ScheduleCheckTask  implements Runnable {

	/**
	 *  简单线程安全的有序队列,这里为了方便就不用优先队列(PriorityQueue)展示了
	 */
	public static ConcurrentLinkedQueue<TimeObj> taskQueue;
//	public PriorityBlockingQueue<TimeObj> priorityTaskQueue;
	
	
	public ScheduleCheckTask() {
		taskQueue = new ConcurrentLinkedQueue<TimeObj>();
	}

	public static void main(String[] args) throws InterruptedException {
		new Thread(new HandleInsert(taskQueue)).start();
		new Thread(new HandleServer(taskQueue)).start();
	}
	
	public void offer(TimeObj element){
		taskQueue.offer(element);
	}
	
	public ConcurrentLinkedQueue<TimeObj> getQueue(){
		return taskQueue;
	}

	@Override
	public void run() {
		new Thread(new HandleServer(taskQueue)).start();
	}
}

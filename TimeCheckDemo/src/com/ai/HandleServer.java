package com.ai;

import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;

/** 
 * @author  作者 “WTF” E-mail: 1031248990@qq.com
 * @date 创建时间：2016年11月18日 下午5:16:22 
 * @version 
 * @since  
 */
public class HandleServer implements Runnable {

	private ConcurrentLinkedQueue<TimeObj> taskQueue;

	
	public HandleServer(ConcurrentLinkedQueue<TimeObj> taskQueue) {
		super();
		this.taskQueue = taskQueue;
	}

	
	@Override
	public void run() {
		System.out.println("HandleServer run ...");
		Timer timerCheckRepeatMessage = new Timer();
		timerCheckRepeatMessage.schedule(new CheckMessageTask(taskQueue), 1000, 1000);
	}

}

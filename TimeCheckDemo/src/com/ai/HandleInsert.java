package com.ai;

import java.util.Calendar;
import java.util.concurrent.ConcurrentLinkedQueue;

/** 
 * @author  作者 “WTF” E-mail: 1031248990@qq.com
 * @date 创建时间：2016年11月18日 下午7:50:36 
 * @version 
 * @since  
 */
public class HandleInsert implements Runnable {

	private ConcurrentLinkedQueue<TimeObj> taskQueue;

	public HandleInsert(ConcurrentLinkedQueue<TimeObj> taskQueue) {
		super();
		this.taskQueue = taskQueue;
	}

	@Override
	public void run() {
		while(true){
			for (int i = 0; i < 1000; i++) {
				MyTimeObj timeObj = new MyTimeObj();
				timeObj.endTime = Calendar.getInstance().getTimeInMillis() + (i * 200);
				timeObj.name = "my name is " + i + "^_^";
				taskQueue.offer(timeObj);
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

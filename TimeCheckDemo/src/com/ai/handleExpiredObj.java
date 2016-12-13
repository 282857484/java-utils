package com.ai;
/** 
 * @author  作者 “WTF” E-mail: 1031248990@qq.com
 * @date 创建时间：2016年11月18日 下午5:43:41 
 * @version 
 * @since  
 */
public class handleExpiredObj implements Runnable {

	private TimeObj timeObj;

	public handleExpiredObj(TimeObj timeObj) {
		this.timeObj = timeObj;
	}
	

	@Override
	public void run() {
		// TODO
		System.out.println("Expired Obj fire" + timeObj.name);
		// 这里可以强制转换成自己想要的类型
		// MyTimeObj myTimeObj = (MyTimeObj) timeObj;
	}

}

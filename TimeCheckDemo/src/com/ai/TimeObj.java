package com.ai;


/** 
 * @author  作者 “WTF” E-mail: 1031248990@qq.com
 * @date 创建时间：2016年11月17日 下午8:40:48 
 * @version 
 * @since  
 */
public class TimeObj extends Object implements Comparable<TimeObj> {

	public long endTime;
	public String name;
	
	
	@Override
	public String toString() {
		return "TimeObj [endTime=" + endTime + ", name=" + name + "]";
	}


	@Override
	public int compareTo(TimeObj o) {
		if(endTime < o.endTime){
			return 1;
		}else if(endTime > o.endTime){
			return -1;
		} else {
			return 0;
		}
	}
	
}

package util;

import java.util.Date;

/**
* @author 
* @version ����ʱ�䣺2019��10��3�� ����7:31:29
* 
*/
public class BackThread extends Thread {
	Date todayDate;
public void run() {
	while (!this.isInterrupted()) {
		todayDate=new Date();
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			
		}
		System.out.println(todayDate.toString()+this.getName());
	}
}}

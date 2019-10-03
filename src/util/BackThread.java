package util;
/**
* @author 
* @version 创建时间：2019年10月3日 下午7:31:29
* 
*/
public class BackThread extends Thread {
	
public void run() {
	while (!this.isInterrupted()) {
		try {
			Thread.sleep(2000);
			System.out.println("线程运行中");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}}

package util;
/**
* @author 
* @version ����ʱ�䣺2019��10��3�� ����7:31:29
* 
*/
public class BackThread extends Thread {
	
public void run() {
	while (!this.isInterrupted()) {
		try {
			Thread.sleep(2000);
			System.out.println("�߳�������");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}}

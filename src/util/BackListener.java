package util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author
 * @version ����ʱ�䣺2019��10��3�� ����7:20:54
 * 
 */
public class BackListener implements ServletContextListener {
	private BackThread backThread;

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if (backThread != null && backThread.isInterrupted()) {
			Thread.interrupted();
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		String string = null;
		if (string == null && backThread == null) {
			backThread = new BackThread();
			backThread.start();
		}
	}

}
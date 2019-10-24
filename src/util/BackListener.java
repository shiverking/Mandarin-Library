package util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author
 * @version 创建时间：2019年10月3日 下午7:20:54
 * 
 */
public class BackListener implements ServletContextListener {
	private BackThread backThread;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if (backThread != null && backThread.isInterrupted()) {
			Thread.interrupted();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		String string = null;
		if (string == null && backThread == null) {
			backThread = new BackThread();
			backThread.start();
		}
	}

}

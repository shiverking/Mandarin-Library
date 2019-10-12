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
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
if (backThread!=null&&backThread.isInterrupted()) {
	backThread.interrupt();
}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
if (backThread==null) {
	backThread=new BackThread();
	backThread.start();
}
	}

}

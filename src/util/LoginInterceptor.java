/**
 * 
 */
package util;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import model.Admin;

/**
 * @author ��Ĺ��Ӱ
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor{
	protected String doIntercept(ActionInvocation invocation) throws Exception {
	//��session�л�ȡAdmin����
	Admin admin=GetLoginAdmin.getAdmin();
	if(admin == null) {
		return Action.LOGIN;
	}
	//����
	return invocation.invoke();
	}
}

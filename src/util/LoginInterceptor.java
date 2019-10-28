/**
 * 
 */
package util;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import model.Admin;

/**
 * @author 古墓丽影
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor{
	protected String doIntercept(ActionInvocation invocation) throws Exception {
	//从session中获取Admin对象
	Admin admin=GetLoginAdmin.getAdmin();
	if(admin == null) {
		return Action.LOGIN;
	}
	//放行
	return invocation.invoke();
	}
}

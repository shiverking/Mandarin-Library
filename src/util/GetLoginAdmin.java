/**
 * 
 */
package util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.Admin;

/**
 * @author ��Ĺ��Ӱ
 *
 */
public class GetLoginAdmin {
	//��ȡsession����
	public static Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}
	//��ȡAdmin����
	public static Admin getAdmin() {
		return (Admin) getSession().get("admin");
	}
}

/**
 * 
 */
package util;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import model.Admin;

/**
 * @author 古墓丽影
 *
 */
public class GetLoginAdmin {
	//获取session对象
	public static Map<String, Object> getSession() {
		return ActionContext.getContext().getSession();
	}
	//获取Admin对象
	public static Admin getAdmin() {
		return (Admin) getSession().get("admin");
	}
}

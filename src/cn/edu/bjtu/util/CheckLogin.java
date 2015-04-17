package cn.edu.bjtu.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 判断session中是否有userid，用于判断用户是否存在 
 * @author RussWest0
 *
 */
//尚未使用
public class CheckLogin {

	public static boolean checkLogin(HttpServletRequest request,
			HttpServletResponse response) {
		if (request.getSession().getAttribute("username").equals("")
				|| request.getSession().getAttribute("userId").equals(""))
		{
			try {
				response.sendRedirect("loginForm");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("登录检查部分出错");
				e.printStackTrace();
			}
			return false;
		}
			
		else 
			return true;

	}
}

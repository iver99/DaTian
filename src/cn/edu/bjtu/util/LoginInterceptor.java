package cn.edu.bjtu.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final String[] IGNORE_URI = {"loginForm","adminLogin","linetransport","registerForm"};
 
    @Override
    /**
     * 控制器方法前执行，返回true则处理执行链继续，如果返回false则不执行控制器方法
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        String url = request.getRequestURL().toString();
        System.out.println(">>>: " + url);
        for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }
        //为false时拦截
        if (!flag) {
        	String username=(String)request.getSession().getAttribute(Constant.USER_NAME);
        	if(username==null){
        		//未登录状态下，返回登录页面
        		response.sendRedirect("loginForm");
        	}
           // T_supplier_user user = LoginController.getLoginUser(request);
            //if (user != null) flag = true;
        }
        return flag;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
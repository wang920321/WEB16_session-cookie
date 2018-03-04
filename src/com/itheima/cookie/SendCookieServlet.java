package com.itheima.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//1创建cookie对象
		Cookie cookie=new Cookie("name","zhangsan");
		//1.1为cookie设置持久化时间---cookie信息在硬盘上保持的时间
		cookie.setMaxAge(60*10);//10分钟---时间设置为0表示删除cookie
		//1.2设置cookie的携带路径
		//cookie.setPath("/WEB16_session-cookie/sendCookie");//访问sendCookie资源时才携带这个cookie
		cookie.setPath("/WEB16_session-cookie");//访问/WEB16_session-cookie下的任何路径都携带这个cookie
		//cookie.setPath("/");//访问服务器下的所有资源都携带这个cookie，实际开发一般不用
		//2将cookie中存储的信息发送到客户端----头
		res.addCookie(cookie);
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
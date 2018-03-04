package com.itheima.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//删除客户端保存name=zhangsan的cookie的信息
		Cookie cookie=new Cookie("name","");
		//将path设置成要删除cookie的path一致
		cookie.setPath("/WEB16_session-cookie");
		//设置时间是0
		cookie.setMaxAge(0);
		res.addCookie(cookie);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
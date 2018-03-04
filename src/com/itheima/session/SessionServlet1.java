package com.itheima.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//创建属于该客户端（会话）的私有的session区域
		//req.getSession()方法会判断该客户端是否在服务器端已经存在session，如果该客户端在服务器不存在session 那么久会创建一个新的session对象
		//如果该客户端在服务器已经存在session  获得已经存在的session返回
		HttpSession session=req.getSession();
		session.setAttribute("name", "jerry");
		String id = session.getId();//该session对象的编号id
		//手动创建一个存储JSESSION的cookie  为该cookie设置持久化时间
		Cookie cookie=new Cookie("JSESSIONID",id);
		cookie.setPath("/WEB16_session-cookie");
		cookie.setMaxAge(60*10);
		res.addCookie(cookie);
		res.getWriter().write("JSESSIONID:"+id);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
package com.itheima.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//获得客户端携带的cookie的数据
		Cookie[] cookies = req.getCookies();
		//cookie是一个键值对
		//通过cookie的名称获取值
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("name")){
					System.out.println(cookie.getValue());
				}
			}
		}
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
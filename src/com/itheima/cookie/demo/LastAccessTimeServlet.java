package com.itheima.cookie.demo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastAccessTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//获得当前时间
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime = format.format(date);
		//1创建cookie，记录当前的最新的访问时间
		Cookie cookie=new Cookie("lastAccessTime",currentTime);
		cookie.setMaxAge(60*10*500);
		res.addCookie(cookie);
		//2获得客户端携带的Cookie---lastAccessTime
		String lastAccessTime="";
		Cookie[] cookies = req.getCookies();
		if(cookies!=null){
			for (Cookie cookie2 : cookies) {
				if("lastAccessTime".equals(cookie2.getName())){
					lastAccessTime = cookie2.getValue();
				}
			}
			
		}
		res.setContentType("text/html;charset=UTF-8");
		if(lastAccessTime==""){
			res.getWriter().write("你是第一次访问");
		}else{
			res.getWriter().write("你上次访问时间为"+lastAccessTime);
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}

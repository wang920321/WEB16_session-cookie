package com.itheima.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		//验证码的校验
		//获得输入的验证码
		String checkCode_client=req.getParameter("checkCode");
		//获得生成图片的文字验证码
		String checkCode_session = (String) req.getSession().getAttribute("checkcode_session");
		
		//比对页面和生成的文字是否一致
		if(!checkCode_client.equals(checkCode_session)){
			req.setAttribute("loginInfo", "你输入的验证码不正确");
			req.getRequestDispatcher("login.jsp").forward(req, res);
			return;
		}
		//获得页面的用户名和密码进行数据校验
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
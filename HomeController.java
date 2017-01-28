package com.learning.web.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.learning.web.dao.LoginDAO;
import com.learning.web.dao.RegisterDAO;
import com.learning.web.entity.Login;
import com.learning.web.entity.Register;
import com.learning.web.services.*;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/")
	public ModelAndView home ()
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping(value = "/login")
	public ModelAndView loginhome ()
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}
	@RequestMapping(value = "/registerAndroid")
	@ResponseBody
	public String registerAndroid(HttpServletRequest req , HttpServletResponse res)throws IOException, ClassNotFoundException, SQLException
	{
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		//String uname= req.getParameter("uname");
		//String pwd = req.getParameter("pwd");
		String cpwd= req.getParameter("cpwd");
		String mobile= req.getParameter("mobile");
		String eid=req.getParameter("eid");
		//String location=req.getParameter("location");
		String college=req.getParameter("college");
		String qualification=req.getParameter("qualification");
		//String id=req.getParameter("id");
		String city=req.getParameter("city");
		String state=req.getParameter("state");
		String country=req.getParameter("country");
		
		Register reg = new Register();
		
		reg.setName(name);
		reg.setEid(eid);
	
		reg.setDob(dob);
		//reg.setUname(uname);
		//reg.setPwd(pwd);
		reg.setCpwd(cpwd);
		reg.setMobile(mobile);
		//reg.setId(id);
		//reg.setLocation(location);
		reg.setQualification(qualification);
		reg.setCollege(college);
		reg.setCity(city);
		reg.setCountry(country);
		reg.setState(state);
		RegisterDAO dao = new RegisterDAO();
		dao.registration(reg);	
		return "yes";
	}
	
	
	
	
	@RequestMapping(value = "/register")
	public ModelAndView Register(HttpServletRequest req , HttpServletResponse res)throws IOException, ClassNotFoundException, SQLException
	{
		ModelAndView mv = new ModelAndView();
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		//String uname= req.getParameter("uname");
		//String pwd = req.getParameter("pwd");
		String cpwd= req.getParameter("cpwd");
		String mobile= req.getParameter("mobile");
		String eid=req.getParameter("eid");
		//String location=req.getParameter("location");
		String college=req.getParameter("college");
		String qualification=req.getParameter("qualification");
		//String id=req.getParameter("id");
		String city=req.getParameter("city");
		String state=req.getParameter("state");
		String country=req.getParameter("country");
		
		Register reg = new Register();
		
		reg.setName(name);
		reg.setEid(eid);
	
		reg.setDob(dob);
		//reg.setUname(uname);
		//reg.setPwd(pwd);
		reg.setCpwd(cpwd);
		reg.setMobile(mobile);
		//reg.setId(id);
		//reg.setLocation(location);
		reg.setQualification(qualification);
		reg.setCollege(college);
		reg.setCity(city);
		reg.setCountry(country);
		reg.setState(state);
		RegisterDAO dao = new RegisterDAO();
		dao.registration(reg);	
		mv.setViewName("regsuccess");
		
		return mv;
	}
	@RequestMapping("/loginAndroid")
	@ResponseBody
	public String loginandroid(HttpServletRequest req , HttpServletResponse res) throws ClassNotFoundException, SQLException
	{
		System.out.println("Android connected");
		String email  = req.getParameter("email");
		String password = req.getParameter("password");
		Login obj = new Login();
		obj.setEmail(email);
		obj.setPwd(password);
		
		LoginDAO daoObj = new LoginDAO();
		obj = daoObj.login(obj);
		
		if(obj.isValid())
		{
			return "yes";
		}
		
		else
		{
			return "no";
		}	
		
	}
	@RequestMapping("/loginAction")	
	public ModelAndView login (HttpSession session,HttpServletRequest req , HttpServletResponse res)throws IOException, ClassNotFoundException, SQLException {
		
		ModelAndView mv = new ModelAndView();
		String email  = req.getParameter("email");
		String password = req.getParameter("password");
		session=req.getSession();
		
		Login obj = new Login();
		obj.setEmail(email);
		obj.setPwd(password);
		
		LoginDAO daoObj = new LoginDAO();
		obj = daoObj.login(obj);
		
		if(obj.isValid())
		{
			session.setAttribute("login",obj.getEmail());
			mv.addObject("Values", obj);
		
			mv.setViewName("videos");
		}
		
		else
		{
			mv.setViewName("Error");
		}

	return mv;
		
	}
	
	
	@RequestMapping("/contactus.htm")
	public ModelAndView Contact (HttpSession session, HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("Hello");
		ModelAndView mv = new ModelAndView();
		
		String username=(String) session.getAttribute("login");
		System.out.println(username);
		if(username == null)
		{		
		mv.setViewName("home");
		return mv;
		}
		else
			
		{
				
				mv.setViewName("videos");
				return mv;
			
			
			
			}
		}
	
	
	

@RequestMapping("/logout")
public ModelAndView AdminLogout(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
	ModelAndView mv = new ModelAndView("home");
	String username=(String) session.getAttribute("login");

	if (session.getAttribute("login") == null) {
		try {
			response.sendRedirect("Login");
		} catch (IOException e) {

			mv.setViewName("Error");
		}
	}
	session.removeAttribute("login");
	session = request.getSession(false);

	session.invalidate();
	System.out.print("logout");

	return mv;

}

}


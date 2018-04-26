package com.gps.controller;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.gps.entity.User;
import com.gps.service.UserService;
import com.gps.util.GPSUtil;

@Controller
@RequestMapping(value ="/user")  
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/loginOut")
	public ModelAndView loginOut(HttpSession session)
	{
		 session.removeAttribute("user");
		 ModelAndView mv=new ModelAndView();  
	    // List<User>  userList=userService.getUser();  
	   //  mv.addObject("userList",userList);  
	     mv.setViewName("/Login");  
	     return mv;  
	}
	@RequestMapping(value="/login")
	public ModelAndView login()
	{
		 ModelAndView mv=new ModelAndView();  
	    // List<User>  userList=userService.getUser();  
	   //  mv.addObject("userList",userList);  
	     mv.setViewName("/Login");  
	     return mv;  
	}
	
	@RequestMapping(value="/userLogin",method=RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("userName") String userName,@RequestParam("password") String password,HttpSession session,HttpServletRequest request)
	{
		 
		 ModelAndView mv=new ModelAndView();  
		 System.out.println("username is:"+userName);
	     System.out.println("password is:"+password);
	     User userInfo=userService.getUserInfoByPassWord(userName,password);
	     if(userInfo!=null)
	     {
	    	 session.setAttribute("user", userInfo);
	    	 mv.setViewName("/index");  
		     return mv;  
	     } else
	     {
	    	 request.setAttribute("error", "*用户名或密码有误！");
	    	 mv.setViewName("/Login");  
		     return mv;  
	     }
	    
	}
	
	@RequestMapping(value="/home")
	public ModelAndView userHome(HttpSession session,HttpServletRequest request)
	{
		 
		 ModelAndView mv=new ModelAndView();  
		 User userInfo=(User)session.getAttribute("user");
	     if(userInfo!=null)
	     {
	    	 request.setAttribute("user", userInfo);
	    	 mv.setViewName("/home");  
		     return mv;  
	     } else
	     {
	    	 request.setAttribute("error", "*用户名或密码有误！");
	    	 mv.setViewName("/Login");  
		     return mv;  
	     }
	    
	}
	
	@RequestMapping(value="/userList")
	public ModelAndView getUserList(HttpServletRequest request){
		List<User> userList=userService.getUserList();
		request.setAttribute("userList", userList);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("userList");
		return mv;
	}
	
	@RequestMapping(value="/changPassWord")
	public ModelAndView showUpdateUserPassWord()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("changePassWord");
		return mv;
	}
	
	@RequestMapping(value="/deleteUser")
	public String deleteUser(@RequestParam("userId")String userId)
	{
		userService.deleteUser(userId);
		return "forward:userList";
	}
	
	@RequestMapping(value="/updateUserPassWord")
	public ModelAndView updateUserPassWord(@RequestParam("userName")String userName,@RequestParam("password")String password,@RequestParam("newPassword")String newPassword,HttpServletRequest request)
	{
		User u=userService.getUserInfoByPassWord(userName, password);
		if(u!=null)
		{
			userService.updateUserById(u.getUserId(),newPassword);
			request.setAttribute("success", "√ 修改成功！");
		}else
		{
			System.out.println("error");
			request.setAttribute("error", "*原密码有误");
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("changePassWord");
		return mv;
	
	}
	
}

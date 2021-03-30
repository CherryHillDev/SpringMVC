package com.kj.springboard.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/loginPage.do")
	public String loginPage() {
		System.out.println("loginPage Controller...");
		return "login.jsp";
	}
}

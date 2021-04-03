package com.kj.springboard.view;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kj.springboard.user.UserService;
import com.kj.springboard.user.UserVO;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	JavaMailSenderImpl mailSender;
	
	@RequestMapping("/loginPage.do")
	public String loginPage() {
		return "login.jsp";
	}
	
	@RequestMapping(value="/insertUser.do", method=RequestMethod.POST)
	public String insertUser(UserVO vo) {
		System.out.println("insertUser...");
		userService.insertUser(vo);
		
		return "/loginPage.do";
	}
	
	@RequestMapping(value="/checkUsername.do", method=RequestMethod.GET)
	@ResponseBody
	public String checkUsername(String username) throws Exception {
		UserVO vo = new UserVO();
		vo.setUsername(username);
		
		if(userService.getUser(vo)!=null) {
			return "exist";
		}else {
			return "";
		}
	}
	
	@RequestMapping(value="/checkMail.do", method=RequestMethod.GET)
	@ResponseBody
	public String checkMail(String email) {
		
		Random random = new Random();
		int num = random.nextInt(999999)+100000;
		
		System.out.println("email : "+email+", "+num);
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				helper.setFrom("wndus549@gmail.com");
				helper.setTo(email);
				helper.setSubject("SpringMVC 가입 인증 이메일");
				helper.setText("인증번호 : "+num);
			}
		};
		
		mailSender.send(preparator);
		
		return Integer.toString(num);
	}
}

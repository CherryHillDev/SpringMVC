package com.kj.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.kj.springboard.board.BoardService;
import com.kj.springboard.board.BoardVO;
import com.kj.springboard.user.UserVO;

@Controller
@SessionAttributes("username")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("insert : "+vo.getId()+", "+vo.getTitle());
		boardService.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model, Authentication auth) {
		if(vo.getKeyword()==null) {
			vo.setKeyword("");
		}
		if(vo.getCondition()==null) {
			vo.setCondition("title");
		}
		
		if(auth!=null) {
			model.addAttribute("username", auth.getName());
		}
		
		
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		model.addAttribute("comments", boardService.getComments(vo));
		
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getUpdateBoard.do")
	public String getUpdateBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		
		return "getUpdateBoard.jsp";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, Model model) {
		boardService.updateBoard(vo);
		model.addAttribute("board", boardService.getBoard(vo));
		
		return "getBoard.do?id="+vo.getId();
	}
}

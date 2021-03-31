package com.kj.springboard.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.kj.springboard.Criteria;
import com.kj.springboard.Paging;
import com.kj.springboard.board.BoardService;
import com.kj.springboard.board.BoardVO;
import com.kj.springboard.comment.CommentService;
import com.kj.springboard.comment.CommentVO;
import com.kj.springboard.user.UserVO;

@Controller
@SessionAttributes("username")
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) {
		System.out.println("insert : "+vo.getContent()+", "+vo.getTitle());
		boardService.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		
		return "getBoardList.do";
	}
	
/*	@RequestMapping("/getBoardList.do")
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
 */
	
	@RequestMapping(value="/getBoardList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String getBoardList(@ModelAttribute("criteria") Criteria criteria, Model model, Authentication auth) throws Exception {
		if(auth!=null) {
			model.addAttribute("username", auth.getName());
		}
		
		System.out.println("condition, keyword : "+criteria.getCondition()+", "+criteria.getKeyword());
		model.addAttribute("boardList", boardService.getBoardList(criteria));	//초기값은 1페이지
		
		Paging paging = new Paging();
		paging.setCriteria(criteria);
		paging.setTotalCount(boardService.getTotalCount(criteria));
		
		model.addAttribute("paging", paging);
		
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/insertTest.do")
	public String insertTest() {
		for(int i=0;i<116;i++) {
			BoardVO vo = new BoardVO();
			vo.setTitle(i+"번 게시글");
			vo.setWriter("tester");
			vo.setContent(i+"번 게시글 내용");
			
			boardService.insertBoard(vo);
		}
		
		return "getBoardListTest.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		
		CommentVO c = new CommentVO();
		c.setBoard_id(vo.getId());
		model.addAttribute("comments", commentService.getCommentList(c));

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

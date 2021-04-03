package com.kj.springboard.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kj.springboard.Criteria;
import com.kj.springboard.board.BoardVO;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}
	
	@Override
	public void updateBoardCount(BoardVO vo) {
		boardDAO.updateBoardCount(vo);
	}
	
	public void updateBoardLove(BoardVO vo) {
		boardDAO.updateBoardLove(vo);
	}
	
	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	
	@Override
	public List<BoardVO> getBoardList(Criteria criteria) {
		return boardDAO.getBoardList(criteria);
	}
	
	@Override
	public int getTotalCount(Criteria criteria) {
		return boardDAO.getTotalCount(criteria);
	}
}

package com.kj.springboard.board;

import java.util.List;

import com.kj.springboard.Criteria;

public interface BoardService {
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(BoardVO vo);
	public List<BoardVO> getBoardListTest(Criteria criteria);
	public int getTotalCount(Criteria criteria);
	
}

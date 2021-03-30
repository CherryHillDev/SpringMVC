package com.kj.springboard.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kj.springboard.Criteria;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> insertBoard() ");
		mybatis.insert("boardMapping.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> updateBoard()");
		mybatis.update("boardMapping.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> deleteBoard() ");
		mybatis.delete("boardMapping.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> getBoard()");
		return mybatis.selectOne("boardMapping.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> getBoardList()");
		return mybatis.selectList("boardMapping.getBoardList", vo);
	}
	
	public List<BoardVO> getBoardListTest(Criteria criteria){
		System.out.println("===> getBoardListTest()");
		return mybatis.selectList("boardMapping.getBoardListTest", criteria);
	}
	
	public int getTotalCount(Criteria criteria) {
		return mybatis.selectOne("boardMapping.getTotalCount", criteria);
	}
}

package com.kj.springboard.comment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertComment(CommentVO vo) {
		System.out.println("===> insertComment()");
		mybatis.insert("commentMapping.insertComment", vo);
	}
	
	public void updateComment(CommentVO vo) {
		System.out.println("===> updateComment()");
		mybatis.update("commentMapping.updateComment", vo);
	}
	
	public void deleteComment(CommentVO vo) {
		System.out.println("===> deleteComment()");
		mybatis.delete("commentMapping.deleteComment", vo);
	}
	
	public List<CommentVO> getCommentList(CommentVO vo) {
		System.out.println("===> getCommentList()");
		return mybatis.selectList("commentMapping.getCommentList", vo);
	}
}

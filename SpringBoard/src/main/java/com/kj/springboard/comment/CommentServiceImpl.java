package com.kj.springboard.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kj.springboard.board.BoardVO;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public void insertComment(CommentVO vo) {
		commentDAO.insertComment(vo);
	}

	@Override
	public void updateComment(CommentVO vo) {
		commentDAO.updateComment(vo);
	}

	@Override
	public void deleteComment(CommentVO vo) {
		commentDAO.deleteComment(vo);
	}

	@Override
	public List<CommentVO> getCommentList(CommentVO vo) {
		return commentDAO.getCommentList(vo);
	}

}

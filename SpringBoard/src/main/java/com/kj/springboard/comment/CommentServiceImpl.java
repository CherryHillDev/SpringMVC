package com.kj.springboard.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public void insertComment() {
		
	}

	@Override
	public void updateComment() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteComment() {
		// TODO Auto-generated method stub

	}

	@Override
	public CommentVO getComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentVO> getCommentList() {
		// TODO Auto-generated method stub
		return null;
	}

}

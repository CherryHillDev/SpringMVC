package com.kj.springboard.comment;

import java.util.List;

public interface CommentService {
	public void insertComment();
	public void updateComment();
	public void deleteComment();
	public CommentVO getComment();
	public List<CommentVO> getCommentList();
}

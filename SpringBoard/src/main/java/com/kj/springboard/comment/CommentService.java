package com.kj.springboard.comment;

import java.util.List;

import com.kj.springboard.board.BoardVO;

public interface CommentService {
	public void insertComment(CommentVO vo);
	public void updateComment(CommentVO vo);
	public void deleteComment(CommentVO vo);
	public List<CommentVO> getCommentList(CommentVO vo);
}

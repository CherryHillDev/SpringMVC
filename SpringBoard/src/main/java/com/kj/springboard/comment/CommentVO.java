package com.kj.springboard.comment;

import com.kj.springboard.TimeVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentVO extends TimeVO {
	private int id;
	private int group_id;
	private int group_sequence;
	private int board_id;
	private String writer;
	private String content;
}

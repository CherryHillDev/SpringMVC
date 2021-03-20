package com.kj.springboard.board;

import com.kj.springboard.TimeVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO extends TimeVO {
	
	private int id;
	private String title;
	private String writer;
	private String content;
	private int count;
	
	//for Searching..
	private String condition;
	private String keyword;
}

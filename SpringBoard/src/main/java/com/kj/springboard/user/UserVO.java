package com.kj.springboard.user;

import com.kj.springboard.TimeVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO extends TimeVO {
	private int id;
	private String username;
	private String password;
	private String authority;
	private boolean enabled;
}


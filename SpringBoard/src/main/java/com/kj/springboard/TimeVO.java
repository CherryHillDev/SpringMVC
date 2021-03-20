package com.kj.springboard;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeVO {
	private LocalDateTime created_time;
	private LocalDateTime modified_time;
}

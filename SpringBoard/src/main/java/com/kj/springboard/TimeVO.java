package com.kj.springboard;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Getter;
import lombok.Setter;

@Setter
public class TimeVO {
	private LocalDateTime created_time;
	private LocalDateTime modified_time;
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm");
	
	public String getCreated_time() {
		return created_time.format(formatter);
	}
	public String getModified_time() {
		return modified_time.format(formatter);
	}
}

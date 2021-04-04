package com.kj.springboard.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertUser(UserVO vo) {
		System.out.println("===> insertUser() ");
		mybatis.insert("userMapping.insertUser", vo);
	}
	
	public void updateUser(UserVO vo) {
		System.out.println("===> updateUser() ");
		mybatis.update("userMapping.updateUser", vo);
	}
	
	public void deleteUser(UserVO vo) {
		System.out.println("===> deleteUser()");
		mybatis.delete("userMapping.deleteUser", vo);
	}
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> getUser()");
		return mybatis.selectOne("userMapping.getUser", vo);
	}
	
	
}

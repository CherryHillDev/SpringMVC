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
	
	
	public void insertUserBoard(UserBoardVO vo) {
		System.out.println("===> insertUserBoard()");
		mybatis.insert("userMapping.insertUserBoard", vo);
	}
	
	public void deleteUserBoard(UserBoardVO vo) {
		System.out.println("===> deleteUserBoard()");
		mybatis.delete("userMapping.deleteUserBoard", vo);
	}
	
	public UserBoardVO getUserBoard(UserBoardVO vo) {
		System.out.println("===> getUserBoard()");
		return mybatis.selectOne("userMapping.getUserBoard", vo);
	}
	
	public int getUserBoardCount(UserBoardVO vo) {
		return mybatis.selectOne("userMapping.getUserBoardCount", vo);
	}
}

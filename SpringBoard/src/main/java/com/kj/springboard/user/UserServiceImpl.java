package com.kj.springboard.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}

	@Override
	public void updateUser(UserVO vo) {
		userDAO.updateUser(vo);
	}

	@Override
	public void deleteUser(UserVO vo) {
		userDAO.deleteUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	
	@Override
	public void insertUserBoard(UserBoardVO vo) {
		userDAO.insertUserBoard(vo);	
	}
	
	@Override
	public void deleteUserBoard(UserBoardVO vo) {
		userDAO.deleteUserBoard(vo);
	}
	
	@Override
	public UserBoardVO getUserBoard(UserBoardVO vo) {
		return userDAO.getUserBoard(vo);
	}
	
	@Override
	public int getUserBoardCount(UserBoardVO vo) {
		return userDAO.getUserBoardCount(vo);
	}
}

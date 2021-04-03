package com.kj.springboard.user;

public interface UserService {
	public void insertUser(UserVO vo);
	public void updateUser(UserVO vo);
	public void deleteUser(UserVO vo);
	public UserVO getUser(UserVO vo);
	
	//user&board
	public void insertUserBoard(UserBoardVO vo);
	public void deleteUserBoard(UserBoardVO vo);
	public UserBoardVO getUserBoard(UserBoardVO vo);
	public int getUserBoardCount(UserBoardVO vo);
}

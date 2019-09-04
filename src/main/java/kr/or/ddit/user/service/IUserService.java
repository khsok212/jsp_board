package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public interface IUserService {
	
	public List<User> getUserList();
	
	public User getUser(String userId);

	public List<User> getUserListOnlyHalf();

	/**
	 * 
	* Method : getUserPagingList
	* 작성자 : 202-01
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	public Map<String, Object> getUserPagingList(Page page);
	
	int insertUser(User user);
	
	int deleteUser(String userId);
	
	int updateUser(User user);
}

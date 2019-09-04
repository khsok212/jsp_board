package kr.or.ddit.post.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.post.model.PostVO;
import kr.or.ddit.post.repository.IPostDao;
import kr.or.ddit.post.repository.PostDaoImpl;
import kr.or.ddit.postfile.model.PostFileVO;

public class PostServiceTest {
	
	private IPostService service;
	
	@Before
	   public void setup() {
		service = new PostServiceImpl();
	}
	
	/** 성공
   	* 
   	* Method : getPostTotalCntTest
  	* 작성자 : 202-01
  	* 변경이력 :
  	* Method 설명 : boardNo에 따른 게시물 전체 수 가져오기 테스트
   	*/
	@Test
	public void getPostTotalCntTest() {
		/***Given***/
		int boardNo = 1;

		/***When***/
		int cnt = service.getPostTotalCnt(boardNo);
		/***Then***/
		assertEquals(11, cnt);
	}
	
	/** 성공
	 * 
	* Method : getPostTotalCntTest1
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시물 전체 수 가져오기 테스트
	 */
	@Test
	public void getPostTotalCntTest1() {
		/***Given***/
		

		/***When***/
		int cnt = service.getPostTotalCnt1();
		
		/***Then***/
		assertEquals(12, cnt);
	}
	
	/** 성공
	 * 
	* Method : getPostPagingListTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시물 페이징 리스트 조회 테스트
	 */
	@Test
	public void getPostPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setBoardNo(1);
		page.setPage(1);
		page.setPagesize(10);

		int boardNo = 1;
		
		/***When***/
		Map<String, Object> map = service.getPostPagingList(page, boardNo);
		List<PostVO> postList = (List<PostVO>)map.get("postList");
		int psize = (Integer)map.get("paginationSize");
		/***Then***/
		assertEquals(10, postList.size());
		assertEquals(1, postList.get(0).getBoardNo());
		assertEquals(2, psize);
	}
	
	/** 성공
	 * 
	* Method : getPostTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시글 보기 테스트
	 */
	@Test
	public void getPostTest() {
		/***Given***/
		int postNo = 1;
		IPostDao dao = new PostDaoImpl();

		/***When***/
		PostVO vo = service.getPost(postNo);
		
		/***Then***/
		assertEquals(1, vo.getBoardNo());
		assertEquals("sally", vo.getUserId());
	}
	
	/** 성공
	 * 
	* Method : insertPostTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시물 추가 테스트
	 * @throws ParseException 
	 */
	@Test
	public void insertPostTest() throws ParseException {
		/***Given***/
		PostVO vo = new PostVO();
		vo.setBoardNo(2);
		vo.setPostTitle("testcode");
		vo.setPostContent("testcont");
		vo.setUserId("brown");
		vo.setParentPostNo(1);

		/***When***/
		int cnt = service.insertPost(vo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	/** 삭제 성공
	 * 
	* Method : deleteFileTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 파일 삭제 테스트
	 */
	@Test
	public void deleteFileTest() {
		/***Given***/
		int fileNo = 76;

		/***When***/
		int cnt = service.deleteFile(fileNo);
//		sqlSession.commit();
		/***Then***/
		assertEquals(1, cnt);
	}
	/** 성공
	 * 
	* Method : insertFileTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 파일 추가 테스트
	 */
	@Test 
	public void insertFileTest() {
		/***Given***/
		PostFileVO vo = new PostFileVO();

		vo.setFileName("brown.png");
		vo.setRealFileName("D:\\upload\\2019\\08\\brown.png");
		vo.setPostNo(1);
		/***When***/
		int cnt = service.insertFile(vo);
//		sqlSession.commit();
		/***Then***/
		assertEquals(1, cnt);
	}
	
	/** 성공
	 * 
	* Method : updatePostTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시물 수정 테스트
	 */
	@Test
	public void updatePostTest() {
		/***Given***/
		int postNo = 12;
		PostVO vo = service.getPost(postNo);
		
		vo.setPostTitle("testCode");
		vo.setPostContent("testCode");
		
		/***When***/
		int cnt = service.updatePost(vo);
		
		/***Then***/
		assertEquals(1, cnt);
	}
	
	/** 성공
	 * 
	* Method : deletePostTest
	* 작성자 : 202-01
	* 변경이력 :
	* Method 설명 : 게시물 삭제 테스트
	 */
	@Test
	public void deletePostTest() {
		/***Given***/
		int postNo = 12;
		
		/***When***/
		int cnt = service.deletePost(postNo);
//		sqlSession.commit();
		/***Then***/
		assertEquals(1, cnt);
	}

}

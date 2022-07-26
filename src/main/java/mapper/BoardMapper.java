package mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.BoardCommentDTO;
import dto.BoardDTO;
import dto.FileDTO;

public class BoardMapper {
	private static BoardMapper instance = new BoardMapper();
	
	private BoardMapper() {
		
	}
	public static BoardMapper getInstance() {
		if(instance == null)
			instance = new BoardMapper();
		return instance;
	}
	public List<BoardDTO> selectBoardList(int pageNo) {
		SqlSession session = DBManager.getInstance().getSession();
		List<BoardDTO> list = session.selectList("selectBoardList", pageNo);
		session.close();
		return list;
	}
	public BoardDTO selectBoard(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		BoardDTO dto = session.selectOne("selectBoard", bno);
		session.close();
		return dto;
	}
	public int selectBoardCount() {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.selectOne("selectBoardCount");
		session.close();
		return result;
	}
	public int insertBoard(BoardDTO dto) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.insert("insertBoard", dto);
		session.commit();
		return result;
	}
	public int updateBoard(BoardDTO dto) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.update("updateBoard", dto);
		session.commit();
		return result;
	}
	public int insertBoardLike(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("insertBoardLike", map);
			session.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int deleteBoardLike(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.delete("deleteBoardLike", map);
			session.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int insertBoardHate(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("insertBoardHate", map);
			session.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int deleteBoardHate(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.delete("deleteBoardHate", map);
			session.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
		
	}
	public int addBoardCount(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		int count = 0;
		try {
			count = session.update("addBoardCount", bno);
			session.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return count;
	}
	public int insertBoardComment(BoardCommentDTO dto) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("insertBoardComment", dto);
			session.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int insertBoardCommentLike(int cno, String id) {
		SqlSession session = DBManager.getInstance().getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		int result = 0;
		try {
			result = session.delete("insertBoardCommentLike", map);
			session.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int deleteBoardCommentLike(int cno, String id) {
		SqlSession session = DBManager.getInstance().getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		int result = 0;
		try {
			result = session.delete("deleteBoardCommentLike", map);
			session.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int insertBoardCommentHate(int cno, String id) {
		SqlSession session = DBManager.getInstance().getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		int result = 0;
		try {
			result = session.delete("insertBoardCommentHate", map);
			session.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int deleteBoardCommentHate(int cno, String id) {
		SqlSession session = DBManager.getInstance().getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		int result = 0;
		try {
			result = session.delete("deleteBoardCommentHate", map);
			session.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int deleteBoardComment(int cno) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.update("deleteBoardComment", cno);
			session.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public int deleteBoard(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.update("deleteBoard", bno);
			session.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	public List<BoardCommentDTO> selectBoardCommentList(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		List<BoardCommentDTO> list = session.selectList("selectBoardCommentList", bno);
		return list;
	}
	public int selectBoardNo() {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		result = session.selectOne("selectBoardNo");
		session.close();
		return result;
	}
	public int insertFile(FileDTO file) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		result = session.insert("insertFile", file);
		session.commit();
		session.close();
		return result;
	}
	public List<FileDTO> selectFileList(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		List<FileDTO> list = session.selectList("selectFileList",bno);
		session.close();
		return list;
	}
	public FileDTO selectFile(HashMap<String, Integer> map) {
		SqlSession session = DBManager.getInstance().getSession();
		FileDTO dto = session.selectOne("selectFile",map);
		session.close();
		return dto;
	}
}
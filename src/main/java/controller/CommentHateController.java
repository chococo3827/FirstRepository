package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.BoardService;
import view.ModelAndView;

public class CommentHateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		String id = ((MemberDTO)request.getSession().getAttribute("dto")).getId();
		
		int result = BoardService.getInstance().insertBoardCommentHate(cno,id);
		
		//안의 걸 문자열로 만들어준다
		response.getWriter().write(String.valueOf(result));
		
		return null;
	}

}

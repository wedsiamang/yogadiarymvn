package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DiaryDao;
import dao.TeacherDao;
import model.Account;
import model.Diary;
import model.Teacher;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UpdateServlet() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		Account loginAc=(Account)session.getAttribute("loginAc");
		String loginName=loginAc.getUserName();
		
		TeacherDao da=new TeacherDao();
		Teacher teachers=da.select_teacher(loginName);
		request.setAttribute("teachers",teachers);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/show.jsp");
		dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int id=0;
		id=Integer.parseInt(request.getParameter("id"));
		String date =request.getParameter("date");
		String weather=request.getParameter("weather");
		String covid19=request.getParameter("covid19");
		String BBT=request.getParameter("BBT");
		String time=request.getParameter("time");		
		String series=request.getParameter("series");
		String teacher=request.getParameter("teacher");
		String condition=request.getParameter("condition");
		String breath=request.getParameter("breath");
		String vanda=request.getParameter("vanda");
		String dristi=request.getParameter("dristi");
		String lunch=request.getParameter("lunch");
		String dinner=request.getParameter("dinner");
		String morning=request.getParameter("morning");
		String myName=request.getParameter("myName");
		
		HttpSession session=request.getSession();
		Account loginAc=(Account)session.getAttribute("loginAc");
		String loginName=loginAc.getUserName();

		DiaryDao dao =  new DiaryDao();
		dao.update_diary(loginName,id,date,weather,covid19,BBT,time,series,teacher,condition,breath,vanda,dristi,lunch,dinner,morning);
		
		TeacherDao da=new TeacherDao();
		Teacher teachers=da.select_teacher(loginName);
		request.setAttribute("teachers",teachers);
		
		Diary day =dao.select_diary(loginName,id);
		request.setAttribute("day",day);
		
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/show.jsp");
		dispatcher.forward(request, response);
	
	}

}

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

@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession();
		Account loginAc=(Account)session.getAttribute("loginAc");
		String loginName=loginAc.getUserName();
		System.out.println(loginName+"*");
		//先生リスト取得
				TeacherDao dao=new TeacherDao();
				Teacher teachers=dao.select_teacher(loginName);
				request.setAttribute("teachers",teachers);
		
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/new.jsp");
		dispatcher.forward(request, response);	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//id=Integer.parseInt(request.getParameter("id"));
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
		System.out.println(loginName+"*");
		//先生リスト取得
		TeacherDao dao=new TeacherDao();
		Teacher teachers=dao.select_teacher(loginName);
		request.setAttribute("teachers",teachers);
		
			//日記を新規登録
			Diary diary =new Diary();
			DiaryDao dao2 =new DiaryDao();
			dao2.insert_diary_info(loginName,date,weather,covid19,BBT,time,series,teacher,condition,breath,vanda,dristi,lunch,dinner,morning);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/new.jsp");
		dispatcher.forward(request, response);
	
	}

}

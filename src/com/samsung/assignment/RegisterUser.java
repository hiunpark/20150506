package com.samsung.assignment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.husers.impl.UserDAO;
import com.samsung.husers.vo.UserVO;

@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("registerName");
		String password = request.getParameter("registerPassword");
		String email = request.getParameter("registerEmail");
		int age = Integer.parseInt(request.getParameter("registerAge"));
		// 성별 1이면 남자, 2이면 여자, 그외 0
		int gender = Integer.parseInt(request.getParameter("registerGender"));

		// 새로운 유저 등록 
		UserVO vo = new UserVO();
		vo.setName(name);
		vo.setPassword(password);
		vo.setEmail(email);
		vo.setAge(age);
		vo.setGender(gender);
		
		UserDAO dao = new UserDAO();
		boolean insert = dao.insertUser(vo);
		if(!insert){
			response.sendRedirect("welcome.jsp");
		}
		
		// 전체 리스트 가져오기
		ArrayList<UserVO> userList = dao.selectUserList();
		// userList.jsp로 이동
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	}

}

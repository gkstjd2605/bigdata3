package kr.mem.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.control.Alert;
import kr.mem.model.MemberDAO;
import kr.mem.model.MemberVO;
import kr.mem.pojo.*;

public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		// 1.���û���� �ľ��ϴ� �۾� >> *.do
		String reqUrl = request.getRequestURI(); // Ŭ���̾�Ʈ�� � ��û�ߴ��� URI������ �������ִ�.
		// System.out.println(reqUrl);
		String ctxPath = request.getContextPath();
		// System.out.println(ctxPath);�Ƴ׿�! �� ū ���콺
		// Ŭ���̾�Ʈ�� ��û�� ���
		String command = reqUrl.substring(ctxPath.length());
		// System.out.println(command);
		// �� ��û�� ���� ó�� �ϱ�(�б��۾�)
		Controller Controller = null;
		String nextView = null;
		MemberDAO dao = new MemberDAO();
		HandlerMapping mappings = new HandlerMapping();
		
		Controller = mappings.getController(command);
		nextView = Controller.requestHandle(request,response);
		/*
		if (command.contentEquals("/list.do")) {
			Controller = new MemberListController();
			nextView = Controller.requestHandle(request, response);
		} 
		
		else if (command.equals("/insert.do")) {
			Controller = new MemberInsertController();
			nextView = Controller.requestHandle(request,response);
		} 
		
		else if (command.equals("/insertForm.do")) {
			Controller = new MemberInsertFormController();
			nextView = Controller.requestHandle(request,response);
		} 
		
		else if (command.equals("/delete.do")) {
			Controller = new MemberDeleteController();
			nextView = Controller.requestHandle(request,response);
		} */
		//---------------------------------------------
		if(nextView!=null) {
			if(nextView.indexOf("redirect:")!=-1) {
				String[] sp = nextView.split(":");  // sp[0]:sp[1]
				response.sendRedirect(sp[1]); // :0
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/"+nextView);
				rd.forward(request, response);
			}
				
		}
		

	}

}

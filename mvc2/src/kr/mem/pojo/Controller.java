package kr.mem.pojo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//FC가 해야할일을 POJO들이 대신해주는 메서드
	public String requestHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	
	
}

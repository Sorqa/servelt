package com.test.sku;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
//요청처리
@WebServlet("/hello")
public class HelloServelt extends HttpServlet {
	         
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String _dan = request.getParameter("dan");
		List<String> list = new ArrayList<>();
		int dan = Integer.parseInt(_dan);
		for(int i =1;i<10;i++) {
			list.add(String.format("%d * %d = %d",  dan, i , dan * i));
		}
		
		PrintWriter out = response.getWriter();//응답 스트림 생성
		for(int i = 0; i<list.size();i++) {
			out.println(list.get(i)+"<br>");	//br:줄을 끊어
		}
		out.println("<p>");
		for(int i = 2; i<9;i++) {
			out.print(String.format("<a href='hello?dan=%d'>%d</a>", i,i));	//get방식	a:태그 href:속성		
		}
		out.println("<p>");
		String form = "<form action='hello' method='post'>";	//post 방식
		form += " 단<input type='text' name='dan' value='2'>";
		form += "<button typ='submit'>확인</button>";
		form += "</form>";
		out.println(form);
		
	}

}

package com.sbs.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	ArticleDao dao = new ArticleDao();
	final String ARTICLEPATH = "article/";  //forwarding을 위해 변수로 만듬. final을 붙이면 수정못함.
	final String EXTENTION = ".jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		String cmd = request.getParameter("cmd");
		PrintWriter pw = response.getWriter();
		
		if(cmd.equals("list")) {
			List<Article> articles = dao.getAllArticles();
			//리퀘스트에 아티클스를 넣어놓은 상태.
			request.setAttribute("articles", articles); //리퀘스트에 아티클스를 넣어놓은 상태.
			//forwording 해야되는데, 해주는게 리퀘스트 디스펙쳐 requestdispatcher
//			RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/listprint.jsp");
//			dis.forward(request, response); 
			String url = ARTICLEPATH +"listprint"+EXTENTION;  //forwarding메서드를 만들어 간단하게 만들어놓은 상태
			forwarding(request, response, url);
		}
		else if(cmd.equals("add")) {
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			String nickname = request.getParameter("nickname");
			dao.insertArticle(title, body, nickname);
			response.sendRedirect("test?cmd=list");
		}
		else if(cmd.equals("addArticle")) {
			String url = ARTICLEPATH +"addArticle"+EXTENTION;
			forwarding(request, response, url);
		}
		else if(cmd.equals("update")) {
			String id = request.getParameter("id");
			String title = request.getParameter("title");
			String body = request.getParameter("body");
			dao.updateArticle(id, title, body);
			

			response.sendRedirect("test?cmd=list");
		}
		else if(cmd.equals("updateArticle")) {
			String id = request.getParameter("id");
			Article article = dao.readArticle(id);
			request.setAttribute("article", article);
			
			String url = ARTICLEPATH+"updateArticle"+EXTENTION;
			forwarding(request, response, url);
		}
		else if(cmd.equals("delete")) {
			String id = request.getParameter("id");
			dao.deleteArticle(id);
			response.sendRedirect("test?cmd=list");
		}
		else if(cmd.equals("read")) {
			String id = request.getParameter("id");
			Article article = dao.readArticle(id);
			request.setAttribute("article", article);
			String url = ARTICLEPATH+"detailjsp"+EXTENTION;
			forwarding(request, response, url);
		}
		else if(cmd.equals("reply")) {
			String id = request.getParameter("id");
			List<Reply> reply = dao.getAllReplies();
			request.setAttribute("reply", reply);
			String url = ARTICLEPATH+"reply"+EXTENTION;
			forwarding(request, response, url);
		}
		else if(cmd.equals("addReply")) {
			String id = request.getParameter("parentId");
			Article article = dao.readArticle(id);
			request.setAttribute("article", article);
			
			String url = ARTICLEPATH +"reply"+EXTENTION;
			forwarding(request, response, url);
		}
	}

	private void forwarding(HttpServletRequest request, HttpServletResponse response, String url) {
		RequestDispatcher req = request.getRequestDispatcher(url);
		try {
			req.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
package com.sbs.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
//	Connection getConnection() {
//		Connection conn = null;
//		BasicDataSource bds = new BasicDataSource();
//		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		bds.setUrl("jdbc:mysql://localhost:3306/t1?serverTimezone=UTC");
//		bds.setUsername("root");
//		bds.setPassword("");
//		
//		try {
//			conn = bds.getConnection();
//			stmt = conn.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return conn;
//		
//	}

	String url = "jdbc:mysql://localhost:3306/t1?serverTimezone=UTC";
	String id = "sbsst";
	String pw = "sbs123414";
	
	
	Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}return conn;

	}
	void close(){
		try {
			if(conn != null) {
				conn.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	List<Article> getArticlesByIdCurrentPage(String currentPage){
		List<Article> articles = null;
		int currentPageNo=Integer.parseInt(currentPage);
		int limit = (currentPageNo -1) *3;
		String sql = "select * from article limit "+limit+", 3";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			articles = new ArrayList<>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String body = rs.getString("body");
				String nickname = rs.getString("nickname");
				String regDate = rs.getString("regDate");
				int hit = rs.getInt("hit");
				
				Article article = new Article(id, title, body, nickname, regDate, hit);
				articles.add(article);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return articles;
	}
	
	
	List<Article> getAllArticles(){
		List<Article> articles = null;
		String sql = "select * from article";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			articles = new ArrayList<>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String body = rs.getString("body");
				String nickname = rs.getString("nickname");
				String regDate = rs.getString("regDate");
				int hit = rs.getInt("hit");
				
				Article article = new Article(id, title, body, nickname, regDate, hit);
				articles.add(article);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return articles;
	}
	public void insertArticle(String title, String body, String nickname) {
		String sql = "insert into article set title = '"+title+"', `body` = '"+body+"', nickname = '"+nickname+"', regDate = now(), hit = 155";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void updateArticle(String id, String title, String body) {
		String sql = "update article set title = '"+title+"', `body` ='"+body+"' where id = "+id;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void deleteArticle(String[] ids) {
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			for (int i=0; i<ids.length;i++) {
				String sql = "delete from article where id = "+ids[i];
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public Article readArticle(String id) {
		Article articles = null;
		String sql = "select * from article where id ="+id;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				articles = new Article();
				articles.setId(rs.getInt("id"));
				articles.setTitle(rs.getString("title"));
				articles.setBody(rs.getString("body"));
				articles.setRegDate(rs.getString("regDate"));
				articles.setNickname(rs.getString("nickname"));
				articles.setHit(rs.getInt("hit"));

			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return articles;
	}
	List<Reply> getRepliesById(String id){
		List<Reply> replies = null;
		String sql = "select * from reply where parentId = "+id;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			replies = new ArrayList<>();
			
			while(rs.next()) {
				int rid = rs.getInt("id");
				String parentId = rs.getString("parentId");
				String body = rs.getString("body");
				String writer = rs.getString("writer");
				String regDate = rs.getString("regDate");
				
				Reply reply = new Reply(rid, parentId, body, writer, regDate);
				replies.add(reply);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return replies;
}

	public void addReply(String parentId, String body, String nickname) {
		String sql = "insert into reply set parentId = "+parentId+", `body` = '"+body+"', writer = '"+nickname+"', regDate = now()";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}

	public Reply readReply(String id) {
		Reply reply = null;
		String sql = "select * from reply where id ="+id;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				reply = new Reply();
				reply.setId(rs.getInt("id"));
				reply.setBody(rs.getString("body"));
				reply.setWriter(rs.getString("writer"));
				reply.setRegDate(rs.getString("regDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return reply;
	}

	public Reply updateReply(String id, String body, String writer) {
		String sql = "update reply set `body` = '"+body+"', writer ='"+writer+"' where id = "+id;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}
	public void deleteReplyById(String id) {
		String sql = "delete from reply where id = "+id;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public Member loginCheckByIdPw(String loginId, String loginPw) {
		String sql = "select * from `member` where loginId="+loginId+" and loginPw"+loginPw;
		Member member = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				member = new Member();
				member.setId(rs.getInt("id"));
				member.setLoginId(rs.getString("LoginId"));
				member.setLoginPw(rs.getString("LoginPw"));
				member.setNickname(rs.getString("nickname"));
				member.setRegDate(rs.getString("regDate"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}return member;
	}



		

}
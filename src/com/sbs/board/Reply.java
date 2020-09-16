package com.sbs.board;

public class Reply {
	int id;
	String parentId;
	String body;
	String writer;
	String regDate;
	
	public Reply() {}
	public Reply(int id, String parentId, String body, String writer, String regDate) {
		this.id = id;
		this.parentId = parentId;
		this.body = body;
		this.writer = writer;
		this.regDate = regDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}
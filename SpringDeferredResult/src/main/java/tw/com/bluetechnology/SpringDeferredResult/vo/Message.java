package tw.com.bluetechnology.SpringDeferredResult.vo;

import java.io.Serializable;

public class Message implements Serializable{
	
	private static final long	serialVersionUID	= -7311501341520348841L;
	private String user;
	private String date;
	private String content;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}

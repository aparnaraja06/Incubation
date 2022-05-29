package mail;

public class Mail {
	
	private String from;
	private String to;
	private String content;
	private String date;
	private boolean isRecalled;
	private String subject;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isRecalled() {
		return isRecalled;
	}
	public void setRecalled(boolean isRecalled) {
		this.isRecalled = isRecalled;
	}
	@Override
	public String toString() {
		return "from : " + from + "\n to : " + to + "\n content : " + content + "\n date : " + date + "\n isRecalled : "
				+ isRecalled;
	}
	
	

}

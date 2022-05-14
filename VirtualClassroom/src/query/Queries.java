package query;

public class Queries {
	
	private int queryId;
	private int studentId;
	private int teacherId;
	private String subject;
	private String postedTime;
	private String replyTime;
	private int timeGap;
	private String question;
	private String answers;
	
	public int getQueryId() {
		return queryId;
	}
	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPostedTime() {
		return postedTime;
	}
	public void setPostedTime(String postedTime) {
		this.postedTime = postedTime;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	public int getTimeGap() {
		return timeGap;
	}
	public void setTimeGap(int timeGap) {
		this.timeGap = timeGap;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "queryId : " + queryId + ", studentId : " + studentId + ", teacherId : " + teacherId + ", subject : "
				+ subject + ", postedTime : " + postedTime + ", replyTime : " + replyTime + ", timeGap : " + timeGap
				+ ", question : " + question + ", answers : " + answers;
	}
	
	
}

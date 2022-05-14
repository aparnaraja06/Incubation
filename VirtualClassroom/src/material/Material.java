package material;

public class Material 
{

	private String type;
	private String subject;
	private double size;
	private String date;
	private int teacherId;
	
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "type : " + type + ", subject : " + subject + ", size : " + size + ", date : " + date + ", "
				+ "teacherId : "+ teacherId;
	}
	
	
}

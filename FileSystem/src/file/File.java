package file;

public class File 
{

	private String name;
	private String type;
	private double size;
	private String date;
	private String folder;
	private boolean readAndWrite=true;
	private String content;
	private boolean isDeleted=false;
    private String modifiedDate;
    
	
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public boolean isReadAndWrite() {
		return readAndWrite;
	}
	public void setReadAndWrite(boolean readAndWrite) {
		this.readAndWrite = readAndWrite;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "name : " + name + ", type : " + type + ", size : " + size + ", date : " + date + ", folder : " + folder
				+ ", readAndWrite : " + readAndWrite + ", content : " + content+", Modified Date : "+modifiedDate;
	}
	
	
	
}

package book;

public class Book 
{
      
	private String title;
	private String author;
	private String category;
	private int id;
	private String language;
	private String status;
	private int edition;
	private int rackNum;
	private String publishedDate;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public int getRackNum() {
		return rackNum;
	}
	public void setRackNum(int rackNum) {
		this.rackNum = rackNum;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	@Override
	public String toString() {
		
		return "\n title : " + title + "\n author : " + author + "\n category : " + category + "\n id : " + id +
				"\n language : "+language + "\n status : " + status + "\n edition : " + edition 
				+ "\n rackNum : " + rackNum + "\n publishedDate : "+ publishedDate+" \n ----------------";
	}
	
	
}

package directory;

public class Directory 
{

	private String name;
	private String type;
	private int totalItems;
	private double occupiedSpace;
	private double freeSpace;
	private String date;
	private String path;
	private boolean isDeleted=false;
	
	
	
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}
	public double getOccupiedSpace() {
		return occupiedSpace;
	}
	public void setOccupiedSpace(double occupiedSpace) {
		this.occupiedSpace = occupiedSpace;
	}
	public double getFreeSpace() {
		return freeSpace;
	}
	public void setFreeSpace(double freeSpace) {
		this.freeSpace = freeSpace;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "name : " + name + ", type : " + type + ", totalItems : " + totalItems + ", occupiedSpace : "
				+ occupiedSpace + ", freeSpace : " + freeSpace + ", date : " + date+", path :"+path;
	}
	
	
}

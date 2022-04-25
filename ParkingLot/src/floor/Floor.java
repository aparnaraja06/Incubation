package floor;

public class Floor {

	private int number;
	private int totalSpace=25;
	private int compact=5;
	private int large=5;
	private int handicapped=5;
	private int twoWheeler=5;
	private int electric=5;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getTotalSpace() {
		return totalSpace;
	}
	public void setTotalSpace(int totalSpace) {
		this.totalSpace = totalSpace;
	}
	public int getCompact() {
		return compact;
	}
	public void setCompact(int compact) {
		this.compact = compact;
	}
	public int getLarge() {
		return large;
	}
	public void setLarge(int large) {
		this.large = large;
	}
	public int getHandicapped() {
		return handicapped;
	}
	public void setHandicapped(int handicapped) {
		this.handicapped = handicapped;
	}
	public int getTwoWheeler() {
		return twoWheeler;
	}
	public void setTwoWheeler(int twoWheeler) {
		this.twoWheeler = twoWheeler;
	}
	public int getElectric() {
		return electric;
	}
	public void setElectric(int electric) {
		this.electric = electric;
	}
	
	public String toString() {
		return "compact "+compact+" large "+large+" handicapped "+handicapped+" two-wheeler "+twoWheeler+" electric "+
	electric;
	}
}

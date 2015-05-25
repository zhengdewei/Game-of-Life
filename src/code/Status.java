package code;

public class Status {
	
	private String name;
	private String color;
	private boolean enabled;
	
	public Status() {

	}
	public Status(String name, String color, boolean enabled) {
		super();
		this.name = name;
		this.color = color;
		this.enabled = enabled;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}

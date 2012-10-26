package fr.vinsnet.compteurtarot.adapters;

public class MenuItem {
	
	String label;
	int code;
	
	public  MenuItem(String label, int code) {
		super();
		this.label = label;
		this.code = code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}

package rmi.time;

public class Time {

	private static Time time;
	public static Time instance() {
		if(time == null)time = new Time();
		return time;
	}
	
	private int value;
	
	private Time() {
		this.value = 15000;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
}

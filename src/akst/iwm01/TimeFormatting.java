package akst.iwm01;

public class TimeFormatting {

	private static TimeFormatting instance = null;
	
	private String secondsString;
	private String minutesString;
	private String hoursString;
	private int hours;
	private int minutes;
	private int seconds;
	
	public String formatTimeInMilis(int miliseconds) {
		hours = miliseconds / 3600;
		minutes = miliseconds / 60;
		seconds = miliseconds % 60;

		secondsString = (seconds < 10) ? ":0" + seconds : ":" + seconds;
		minutesString = (minutes < 10) ? ":0" + minutes : ":"
				+ Integer.toString(minutes);
		hoursString = (hours < 10) ? "0" + hours : Integer.toString(hours);

		return (hoursString + minutesString + secondsString);
	}
	
	public static TimeFormatting getInstance() {
		if( instance == null ) {
			instance = new TimeFormatting();
		}
		
		return instance;
	}

}

package akst.iwm01;

public abstract class Exercise {
	
	abstract public int calculateTime(int amount, boolean level);
	
	public String getTime(int amount, boolean level) {
		
		String secondsString;
		String minutesString;
		int timeInSeconds = calculateTime(amount, level);
		int minutes = timeInSeconds / 60;
		int seconds = timeInSeconds % 60;
		
		secondsString = ( seconds < 10 ) ? ":0" + seconds 
										 : ":" + seconds;
		
		minutesString = ( minutes < 10 ) ? "0" + minutes 
				 						 : Integer.toString(minutes);
		
		return (minutesString + secondsString);
	};
	 
}

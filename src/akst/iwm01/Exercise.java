package akst.iwm01;

public abstract class Exercise {
	
	private int amount;
	private boolean level;
	
	private int counter;
	private boolean exerciseStarted = false;
	
	private boolean downFlag = false;
	
	public Exercise(int amount, boolean level) {
		this.amount = amount;
		this.level = level;
	}

	abstract public int calculateTime();
	
	abstract public void exerciseCounter(float x, float y, float z);
	
	public String getTime() {
		
		String secondsString;
		String minutesString;
		int timeInSeconds = calculateTime();
		int minutes = timeInSeconds / 60;
		int seconds = timeInSeconds % 60;
		
		secondsString = ( seconds < 10 ) ? ":0" + seconds 
										 : ":" + seconds;
		
		minutesString = ( minutes < 10 ) ? "0" + minutes 
				 						 : Integer.toString(minutes);
		
		return (minutesString + secondsString);
	};
	
	public int getAmount() {
		return amount;
	}
	
	public boolean getLevel() {
		return level;
	}
	
	public void startExercise() {
		this.exerciseStarted = true;
	}
	
	public void stopExercise() {
		this.exerciseStarted = false;
	}
	
	public boolean isExerciseStarted() {
		return this.exerciseStarted;
	}
	
	public void increaseCounter() {
		this.counter++;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void toggleDownFlag() {
		this.downFlag = !this.downFlag;
	}
	
	public boolean getDownFlag() {
		return downFlag;
	}
	
	
	 
}

package akst.iwm01;

public class Pompka extends Exercise {
	
	private static final float START_X_MIN = (float) -2.5;
	private static final float START_X_MAX = (float) 2.5;
	private static final float START_Y_MIN = (float) 7;
	private static final float START_Y_MAX = (float) 12;
	private static final float START_Z_MIN = (float) -4.0;
	private static final float START_Z_MAX = (float) 4.0;
	
	private static final float STOP_X_MIN = (float) -2.5;
	private static final float STOP_X_MAX = (float) 2.5;
	private static final float STOP_Y_MIN = (float) -2.0;
	private static final float STOP_Y_MAX = (float) 2.0;
	private static final float STOP_Z_MIN = (float) -12;
	private static final float STOP_Z_MAX = (float) -7;
	
	private String accValues = "init";
	
	public Pompka(int amount, boolean level) {
		super(amount, level);
	}

	@Override
	public int calculateTime() {
		
		int timeInSeconds = 0;
		
		if(getLevel() == Settings.POZIOM_LATWY) {
			timeInSeconds = getAmount() * Settings.POMPKA_LATWY_TIME;
		} else {
			timeInSeconds = getAmount() * Settings.POMPKA_TRUDNY_TIME;
		}
		
		return timeInSeconds;
	}

	@Override
	public void exerciseCounter(float x, float y, float z) {
		//this.accValues = Float.toString(x) + ", "+ Float.toString(y) + ", "+ Float.toString(z);
		if(!isExerciseStarted()) {
			if(inStartRangeX(x) && inStartRangeY(y) && inStartRangeZ(z)) {
				startExercise();
			}
		}
		else {
			if(getDownFlag() && inStartRangeX(x) && inStartRangeY(y) && inStartRangeZ(z)) {
				increaseCounter();
				setDownFlag(false);
				this.accValues="flag false";
			} else if(inStopRangeX(x) && inStopRangeY(y) && inStopRangeZ(z)) {
				setDownFlag(true);
				this.accValues="flag true";
			}
		}
		
	}

	private boolean inStartRangeZ(float z) {
		if(z > START_Z_MIN && z < START_Z_MAX) return true;
		return false;
	}

	private boolean inStartRangeY(float y) {
		if(y > START_Y_MIN && y < START_Y_MAX) return true;
		return false;
	}

	private boolean inStartRangeX(float x) {
		if(x > START_X_MIN && x < START_X_MAX) return true;
		return false;
	}
	
	private boolean inStopRangeZ(float z) {
		if(z > STOP_Z_MIN && z < STOP_Z_MAX) return true;
		return false;
	}

	private boolean inStopRangeY(float y) {
		if(y > STOP_Y_MIN && y < STOP_Y_MAX) return true;
		return false;
	}

	private boolean inStopRangeX(float x) {
		if(x > STOP_X_MIN && x < STOP_X_MAX) return true;
		return false;
	}
	
	public String getAccValues() {
		return accValues;
	}
}

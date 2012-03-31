package akst.iwm01;

public class Pompka extends Exercise {

	@Override
	public String calculateTime(int amount, boolean level) {
		
		int timeInSeconds = 0;
		
		if(level == Settings.POZIOM_LATWY) {
			timeInSeconds = amount * Settings.POMPKA_LATWY_TIME;
		} else {
			timeInSeconds = amount * Settings.POMPKA_TRUDNY_TIME;
		}
		
		String result;
		int minutes = timeInSeconds / 60;
		int seconds = timeInSeconds % 60;
		
		if(minutes < 10) {
			if(seconds < 10) {
				result = "0" + minutes + ":0" + seconds;
			} else {
				result = "0" + minutes + ":" + seconds;
			}
		} else {
			if(seconds < 10) {
				result = minutes + ":0" + seconds;
			} else {
				result = minutes + ":" + seconds;
			}
		}
		
		
		return result;
	}

}

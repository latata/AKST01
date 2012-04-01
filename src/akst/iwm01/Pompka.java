package akst.iwm01;

public class Pompka extends Exercise {

	@Override
	public int calculateTime(int amount, boolean level) {
		
		int timeInSeconds = 0;
		
		if(level == Settings.POZIOM_LATWY) {
			timeInSeconds = amount * Settings.POMPKA_LATWY_TIME;
		} else {
			timeInSeconds = amount * Settings.POMPKA_TRUDNY_TIME;
		}
		
		return timeInSeconds;
	}

}

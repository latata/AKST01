package akst.iwm01;

public class Settings {
	
	private static Settings instance;
	
	public static final int POMPKA_LATWY_TIME = 1;
	public static final int POMPKA_TRUDNY_TIME = 2;
	
	public static final boolean POZIOM_LATWY = true;
	public static final boolean POZIOM_TRUDNY = false;
	
	public static final int POMPKI = 1;
	
	
	
	private Settings() {
		
	}
	
	public static Settings getInstance() {
		if(instance == null) {
			instance = new Settings();
		}
		return instance;
	}

}

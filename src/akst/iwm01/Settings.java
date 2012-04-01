package akst.iwm01;

public class Settings {
	
	public static final int POMPKA_LATWY_TIME = 1;
	public static final int POMPKA_TRUDNY_TIME = 2;
	public static final int BRZUSZEK_LATWY_TIME = 1;
	public static final int BRZUSZEK_TRUDNY_TIME = 2;
	public static final int PRZYSIAD_LATWY_TIME = 1;
	public static final int PRZYSIAD_TRUDNY_TIME = 2;
	
	public static final boolean POZIOM_LATWY = true;
	public static final boolean POZIOM_TRUDNY = false;
	
	public static final int POMPKI = 1;
	public static final int BRZUSZKI = 2;
	public static final int PRZYSIADY = 3;
	
	public static final SpinnerState[] EXCERCISE_ITEMS = new SpinnerState[] {
		new SpinnerState("Pompki", POMPKI),
		new SpinnerState("Brzuszki", BRZUSZKI),
		new SpinnerState("Przysiady", PRZYSIADY) }; 

	public static final SpinnerState[] LEVEL_ITEMS = new SpinnerState[] {
		new SpinnerState("Łatwy", POZIOM_LATWY),
		new SpinnerState("Trudny", POZIOM_TRUDNY) };
	

}

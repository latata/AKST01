package akst.iwm01;

import java.io.Serializable;


public class SpinnerState implements Serializable{

	private boolean idLevel;
	private int idExercise;
	private String name;

	public SpinnerState(String levelName, boolean levelId) {
		this.name = levelName;
		this.idLevel = levelId;
	}
	
	public SpinnerState(String exerciseName, int excerciseId) {
		this.name = exerciseName;
		this.idExercise = excerciseId;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getLevelId() {
		return idLevel;
	}
	
	public int getExerciseId() {
		return idExercise;
	}

	public String toString()
	{
	    return name;
	}
}

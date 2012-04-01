package akst.iwm01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ExerciseActivity extends Activity {

	private int type;
	private boolean level;
	private int amount;

	private TextView exerciseNameLabel;
	private TextView amountLabel;
	private TextView timeLabel;
	
	private SpinnerState excerciseSpinnerState;
	private SpinnerState levelSpinnerState;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.exercise_layout);
		
		exerciseNameLabel = (TextView) findViewById(R.id.exerciseName);
		amountLabel = (TextView) findViewById(R.id.amountLabel);
		timeLabel = (TextView) findViewById(R.id.timeLabel);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		excerciseSpinnerState = (SpinnerState) getIntent().getSerializableExtra("typ");
		levelSpinnerState = (SpinnerState) getIntent().getSerializableExtra("poziom");
		amount = Integer.parseInt(getIntent().getStringExtra("ilosc"));
		
		type = excerciseSpinnerState.getExerciseId();
		level = levelSpinnerState.getLevelId();
		exerciseNameLabel.setText(excerciseSpinnerState.getName());
		amountLabel.setText(Integer.toString(amount));
		
		Exercise exercise = null;

		switch (type) {
		case Settings.POMPKI:
			exercise = new Pompka();
		case Settings.BRZUSZKI:
			exercise = new Pompka();
		case Settings.PRZYSIADY:
			exercise = new Pompka();
		}
		
		timeLabel.setText(exercise.getTime(amount, level));
	}
}

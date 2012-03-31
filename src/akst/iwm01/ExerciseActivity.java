package akst.iwm01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ExerciseActivity extends Activity {

	private String typeStr;
	private int type;
	private String levelStr;
	private boolean level;
	private int amount;

	private TextView exerciseName;
	private TextView amountLabel;
	private TextView timeLabel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exercise_layout);

		exerciseName = (TextView) findViewById(R.id.exerciseName);
		amountLabel = (TextView) findViewById(R.id.amountLabel);
		timeLabel = (TextView) findViewById(R.id.timeLabel);

		
		

	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		typeStr = getIntent().getStringExtra("typ");
		levelStr = getIntent().getStringExtra("poziom");
		amount = Integer.parseInt(getIntent().getStringExtra("ilosc"));

		exerciseName.setText(typeStr);
		amountLabel.setText(Integer.toString(amount));
		
		
		if(levelStr.equals("Latwy")) {
			level = Settings.POZIOM_LATWY;
		} else {
			level = Settings.POZIOM_TRUDNY;
		}

		if (typeStr.equals("Pompki")) {
			//Log.d("typ", "pompki");
			type = Settings.POMPKI;
		}

		Exercise exercise = null;

		switch (type) {
		case Settings.POMPKI:
			exercise = new Pompka();
		}
		
		timeLabel.setText(exercise.calculateTime(amount, level));
	}
}

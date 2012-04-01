package akst.iwm01;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ChooseExerciseActivity extends Activity {

	Context ctx;
	Spinner exerciseSpinner;
	Spinner levelSpinner;
	EditText amount;
	Button startBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ctx = getBaseContext();

		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_exercise_layout);
		startBtn = (Button) findViewById(R.id.startExerciseBtn);
		exerciseSpinner = (Spinner) findViewById(R.id.spinner1);
		levelSpinner = (Spinner) findViewById(R.id.level);
		amount = (EditText) findViewById(R.id.amount);
		
		ArrayAdapter<SpinnerState> excerciseSpinnerArrayAdapter = new ArrayAdapter<SpinnerState>(this,
				android.R.layout.simple_spinner_dropdown_item, Settings.EXCERCISE_ITEMS);
		exerciseSpinner.setAdapter(excerciseSpinnerArrayAdapter);

		ArrayAdapter<SpinnerState> levelSpinnerArrayAdapter = new ArrayAdapter<SpinnerState>(this,
				android.R.layout.simple_spinner_dropdown_item, Settings.LEVEL_ITEMS);
		levelSpinner.setAdapter(levelSpinnerArrayAdapter);
		

		startBtn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(ctx, ExerciseActivity.class);
				intent.putExtra("typ", (SpinnerState)exerciseSpinner.getSelectedItem());
				intent.putExtra("poziom", (SpinnerState)levelSpinner.getSelectedItem());
				intent.putExtra("ilosc", amount.getText().toString());
				startActivity(intent);
			}
		});

	}
}

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
	Spinner spinner;
	Spinner levelSpinner;
	EditText amount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		ctx = getBaseContext();

		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_exercise_layout);
		spinner = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.exercisesLabels,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		amount = (EditText) findViewById(R.id.amount);
		
		levelSpinner = (Spinner) findViewById(R.id.level);

		Button startBtn = (Button) findViewById(R.id.startExerciseBtn);
		startBtn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(ctx, ExerciseActivity.class);
				intent.putExtra("typ", spinner.getSelectedItem().toString());
				intent.putExtra("ilosc", amount.getText().toString());
				intent.putExtra("poziom", levelSpinner.getSelectedItem().toString());
				startActivity(intent);
			}
		});

	}
}

package akst.iwm01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ExerciseActivity extends Activity {

	private int type;
	private boolean level;
	private int amount;

	private TextView exerciseNameLabel;
	private TextView amountLabel;
	private TextView timeLabel;
	private TextView currentTime;
	private TextView counterLabel;
	private Button startBtn;
	
	private SpinnerState excerciseSpinnerState;
	private SpinnerState levelSpinnerState;
	
	private Exercise exercise;
	
	private float x, y, z;
	
	private Stopwatch stopwatch;
	
	private SensorManager sensorManager;
	private SensorEventListener accelerationListener = new SensorEventListener() {
		public void onAccuracyChanged(Sensor sensor, int acc) {
		}

		public void onSensorChanged(SensorEvent event) {
			x = event.values[0];
			y = event.values[1];
			z = event.values[2];
			exercise.exerciseCounter(x, y, z);
		}

	};
	
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (counterLabel != null)
				counterLabel.setText(Integer.toString(exercise.getCounter()));
		}
	};

	
	Thread thread = new Thread() {
		public void run() {
			while (true) {

				handler.sendEmptyMessage(1);
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	};
	
	private PowerManager.WakeLock mWakeLock;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.exercise_layout);
		
		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK | PowerManager.ON_AFTER_RELEASE, "My Tag");
		mWakeLock.acquire();
		
		exerciseNameLabel = (TextView) findViewById(R.id.exerciseName);
		amountLabel = (TextView) findViewById(R.id.amountLabel);
		timeLabel = (TextView) findViewById(R.id.timeLabel);
		currentTime = (TextView) findViewById(R.id.currentTime);
		counterLabel = (TextView) findViewById(R.id.counterLabel);
		startBtn = (Button) findViewById(R.id.button1);
		
		stopwatch = new Stopwatch(currentTime);
		
		startBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				if(startBtn.getText().equals("Rozpocznij"))
				{
					startBtn.setText("Stop");
					sensorManager.registerListener(accelerationListener,
							sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
							SensorManager.SENSOR_DELAY_GAME);
					thread.start();
					stopwatch.startThread();
				}
				else
				{
					startBtn.setText("Rozpocznij");
					stopwatch.stopThread();
					thread.stop();
				}
			}
		});
		
		sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
		
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

		
		switch (type) {
		case Settings.POMPKI:
			exercise = new Pompka(amount, level);
		case Settings.BRZUSZKI:
			exercise = new Pompka(amount, level);
		case Settings.PRZYSIADY:
			exercise = new Pompka(amount, level);
		}
		
		timeLabel.setText(exercise.getTime());
		
		
	}
	
	
}

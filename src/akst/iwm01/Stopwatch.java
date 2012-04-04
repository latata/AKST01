package akst.iwm01;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class Stopwatch extends Thread {

	private TextView currentTimeTextView;
	private int currentTime = 0;
	private boolean threadAliveFlag = false;
	
	private String secondsString;
	private String minutesString;
	private String hoursString;
	private int hours;
	private int minutes;
	private int seconds;

	private Handler timeHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			incrementTime();
		}
	};
	
	public Stopwatch(TextView currentTimeTextView) {
		this.currentTimeTextView = currentTimeTextView;
	}
	
	private void incrementTime() {
		currentTime++;
		
		hours = currentTime / 3600;
		minutes = currentTime / 60;
		seconds = currentTime % 60;
		
		secondsString = ( seconds < 10 ) ? ":0" + seconds 
				 : ":" + seconds;
		minutesString = ( minutes < 10 ) ? ":0" + minutes 
				 : ":" + Integer.toString(minutes);
		hoursString = ( hours < 10 ) ? "0" + hours 
				 : Integer.toString(hours);
		
		currentTimeTextView.setText(hoursString+minutesString+secondsString);
	}
	
	public void stopThread() {
		threadAliveFlag = false;
	}
	
	public void startThread() {
		threadAliveFlag = true;
		currentTime = 0;
		this.start();
	}

	public void run() {
		while (threadAliveFlag) {

			timeHandler.sendEmptyMessage(1);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return;
	};

}

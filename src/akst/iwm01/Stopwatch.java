package akst.iwm01;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class Stopwatch extends Thread {

	private TextView currentTimeTextView;
	private int currentTime = 0;
	private boolean threadAliveFlag = false;

	private Handler timeHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			updateTime();
		}
	};
	
	public Stopwatch(TextView currentTimeTextView) {
		this.currentTimeTextView = currentTimeTextView;
	}
	
	private void updateTime() {
		currentTime++;	
		currentTimeTextView.setText(TimeFormatting.getInstance().formatTimeInMilis(currentTime));
	}
	
	public boolean getThreadAliveFlag() {
		return threadAliveFlag;
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
		
		//return;
	};

}

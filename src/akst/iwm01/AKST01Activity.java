package akst.iwm01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AKST01Activity extends Activity {
	
	Context ctx;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ctx = getBaseContext();
        
        Button chooseExerciseBtn = (Button) findViewById(R.id.button3);
        chooseExerciseBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(ctx, ChooseExerciseActivity.class);	
				startActivity(intent);
			}
		});
        
        Button startPlanBtn = (Button) findViewById(R.id.button1);
        startPlanBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO				
			}
		});
        
        Button continuePlanBtn = (Button) findViewById(R.id.button2);
        continuePlanBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO				
			}
		});
    }
}
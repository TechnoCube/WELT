package com.example.technocube.welt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private int mThrottleValue = 0;
    private ProgressBar mThrottleIndicator;
    private Button mIncrementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mThrottleIndicator = (ProgressBar) findViewById(R.id.throttle_indicator);

        mIncrementButton = (Button) findViewById(R.id.inc_button);
        mIncrementButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                maxThrottle();
                return true;
            }
        });
    }

    // Method to increment the throttle value. Maximum of 10.
    // Called by increment button onClick listener
    protected void incThrottle() {
        if (mThrottleValue < 10) {
            mThrottleValue++;
            updateThrottleSetting();
        }
    }

    // Method to decrement the throttle value. Minimum of 0.
    // Called by decrement button onClick listener
    protected void decThrottle() {
        if (mThrottleValue > 0) {
            mThrottleValue--;
            updateThrottleSetting();
        }
    }

    // Method to reset the throttle value to 0.
    // Called by stop button onClick listener
    protected void stopThrottle() {
        mThrottleValue = 0;
        updateThrottleSetting();
    }

    // Method to max out throttle (10).
    // Called on increment button long press
    protected void maxThrottle() {
        mThrottleValue = 10;
        updateThrottleSetting();
    }

    // Updates the status bar and the MCU profile.
    protected void updateThrottleSetting() {
        mThrottleIndicator.setProgress(mThrottleValue);
    }

    public void incThrottleListener(View view) {
        incThrottle();
    }

    public void decThrottleListener(View view) {
        decThrottle();
    }

    public void stopThrottleListener(View view) {
        stopThrottle();
    }

    public void exitListener(View view) {
        finish();
    }
}

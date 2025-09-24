package com.example.stopwatchsample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private StopwatchViewModel viewModel;
    private TextView tvTime;
    private Button btnStartStop, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(StopwatchViewModel.class);
        viewModel.GetAggregatedTime();
        tvTime = findViewById(R.id.tvTime);
        tvTime.setText("00:00:00.0");

        // TODO: Initialize UI components (TextView, Buttons)
        final Observer<Long> TimeObserver = new Observer<Long>() {
            @Override
            public void onChanged(Long l) {
                tvTime.setText(formatTime(l));
            }
        };
        viewModel.GetAggregatedTime().observe(this,TimeObserver);
        // TODO: Set up button listeners for Start/Stop and Reset
    }

    public void OnResetClick (View view){
        viewModel.ResetClock();
    }

    public void OnStartStopClick (View view){
        Button StartStopButton = (Button) view;
        String StartStop = StartStopButton.getText().toString();
        if(StartStop.equals("Start")){
            StartStopButton.setText(getResources().getString(R.string.Stop));
            viewModel.StartClock();
        }
        else{//Do stop
            StartStopButton.setText(getResources().getString(R.string.Start));
            viewModel.StopClock();
        }

    }

    // TODO: Format elapsed time for display
    public String formatTime(Long l) {
        String returnNumber = "";
        if((l/3600000) > 9)
        {
            returnNumber = String.format(Long.toString(l/3600000)) + ":";
        }
        else{
            returnNumber = "0" + String.format(Long.toString(l/3600000)) + ":";
        }

        if((l/60000) > 9){
            returnNumber = returnNumber + String.format(Long.toString((l/60000) % 60)) + ":";
        }
        else{
            returnNumber = returnNumber + "0" + String.format(Long.toString((l/60000) % 60)) + ":";
        }

        if(((l/1000) % 60) > 9){
            returnNumber = returnNumber + String.format(Long.toString((l/1000) % 60));
        }
        else{
            returnNumber = returnNumber + "0" + String.format(Long.toString((l/1000) % 60));
        }
            returnNumber = returnNumber + "." + String.format(Long.toString((l/100) % 10));

        //returnNumber = returnNumber + String.format(Long.toString(l/3600000)) + ":" + String.format(Long.toString(l/60000)) + ":" + String.format(Long.toString((Math.round(l/10)/100)));
        return returnNumber;
    }
}

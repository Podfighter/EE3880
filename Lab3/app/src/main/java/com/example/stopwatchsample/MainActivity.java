package com.example.stopwatchsample;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        // TODO: Initialize UI components (TextView, Buttons)

        // TODO: Set up button listeners for Start/Stop and Reset
    }

    public Void OnResetClick (View view){

    }

    public void OnStartStopClick (View view){
        Button StartStopButton = (Button) view;
        String StartStop = StartStopButton.getText().toString();
        if(StartStop.equals("Start")){

        }
        else{//Do stop

        }

    }

    // TODO: Format elapsed time for display
}

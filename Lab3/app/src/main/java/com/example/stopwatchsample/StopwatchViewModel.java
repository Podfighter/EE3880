package com.example.stopwatchsample;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StopwatchViewModel extends ViewModel {

    // Variable to track elapsed time
    private long elapsedTime = 0L;
    private long StartTime = 0L;

    private boolean isStoped = true;


    Thread TimeKeeper = new Thread(new Runnable() {
        @Override
        public void run() {
            if(!isStoped){
                GetAggregatedTime().postValue(System.currentTimeMillis() - StartTime);
            }
        }
    });
    private MutableLiveData<Long> AggregatedTime;
    public MutableLiveData<Long> GetAggregatedTime(){
        if(AggregatedTime == null){
            AggregatedTime = new MutableLiveData<Long>();
            TimeKeeper.start();
        }
        return AggregatedTime;
    }

    public void StartClock(){
        StartTime = System.currentTimeMillis();
        isStoped = false;
    }

    public void StopClock(){
        isStoped = true;
        if(AggregatedTime.isInitialized()) {
            elapsedTime = AggregatedTime.getValue();
        }


    }

    public void ResetClock(){
        AggregatedTime.setValue(0L);
        elapsedTime = 0L;
    }

    // TODO: Add methods to start, stop, and reset the stopwatch

    public long getElapsedTime() {
        return elapsedTime;
    }
}

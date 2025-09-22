package com.example.stopwatchsample;

public class StopwatchViewModel extends ViewModel {

    // Variable to track elapsed time
    private long elapsedTime = 0L;
    private long StartTime = 0L;
    private MutableLiveData<Long> AggregatedTime;

    public MutableLiveData<Long> GetAggregatedTime(){
        if(AggregatedTime == null){
            AggregatedTime = new MutableLiveData<Long>();
        }
        return AggregatedTime;
    }

    public void StartClock(){

    }

    public void StopClock(){
        
    }

    public void ResetClock(){
        AggregatedTime = 0L;
    }

    // TODO: Add methods to start, stop, and reset the stopwatch

    public long getElapsedTime() {
        return elapsedTime;
    }
}

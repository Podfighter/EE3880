package com.example.stopwatchsample;

public class StopwatchViewModel extends ViewModel {

    // Variable to track elapsed time
    private long elapsedTime = 0L;
    private MutableLiveData<Long> AggregatedTime;

    public MutableLiveData<Long> GetAggregatedTime(){
        if(AggregatedTime == null){
            AggregatedTime = new MutableLiveData<Long>();
        }
        return AggregatedTime;
    }

    // TODO: Add methods to start, stop, and reset the stopwatch

    public long getElapsedTime() {
        return elapsedTime;
    }
}

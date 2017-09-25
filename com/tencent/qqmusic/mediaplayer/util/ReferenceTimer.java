package com.tencent.qqmusic.mediaplayer.util;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicLong;

public class ReferenceTimer {
    private static final String TAG = "ReferenceTimer";
    private AtomicLong mBaseTime = new AtomicLong();

    public void restart() {
        this.mBaseTime.set(SystemClock.uptimeMillis());
    }

    public long getTimeInMs() {
        return SystemClock.uptimeMillis() - this.mBaseTime.get();
    }

    public void refreshTimeInMs(long j) {
        this.mBaseTime.set(SystemClock.uptimeMillis());
        this.mBaseTime.addAndGet(-j);
    }
}

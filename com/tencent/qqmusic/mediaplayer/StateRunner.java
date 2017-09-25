package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.util.Logger;

class StateRunner<T> {
    private static final String TAG = "StateRunner";
    private T mState;

    public StateRunner(T t) {
        this.mState = t;
    }

    public synchronized T transfer(T t) {
        T t2;
        t2 = this.mState;
        this.mState = t;
        Logger.i(TAG, t2.toString() + " -> " + this.mState.toString());
        return t2;
    }

    public synchronized boolean transfer(T t, T... tArr) {
        boolean z;
        if (isEqual(tArr)) {
            transfer(t);
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public synchronized boolean isEqual(T... tArr) {
        boolean z = false;
        synchronized (this) {
            for (Object equals : tArr) {
                if (this.mState.equals(equals)) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public synchronized T get() {
        return this.mState;
    }
}

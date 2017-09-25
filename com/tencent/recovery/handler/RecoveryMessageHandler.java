package com.tencent.recovery.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.recovery.Recovery;

public class RecoveryMessageHandler extends Handler {
    public RecoveryMessageHandler() {
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                Recovery.cds();
                return;
            case 2:
                Recovery.CQ(1);
                return;
            case 3:
                Recovery.CQ(1);
                return;
            default:
                return;
        }
    }
}

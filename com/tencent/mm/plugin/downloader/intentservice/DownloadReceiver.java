package com.tencent.mm.plugin.downloader.intentservice;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.y.d;
import com.tencent.mm.plugin.notification.b;

public class DownloadReceiver extends ResultReceiver {
    private static final String TAG = DownloadReceiver.class.getSimpleName();
    private d kGh;

    protected void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        if (i == 4657) {
            int i2 = bundle.getInt("progress");
            if (b.nZQ != null) {
                if (i2 < 100) {
                    this.kGh.b(100, i2, false).b("Download in progress:" + i2);
                    b.nZQ.notify(4657, this.kGh.build());
                    return;
                }
                this.kGh.b(0, 0, false).b("Download Complete");
                b.nZQ.notify(4658, this.kGh.build());
            }
        }
    }
}

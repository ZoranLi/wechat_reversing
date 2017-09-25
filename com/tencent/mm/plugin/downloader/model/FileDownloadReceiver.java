package com.tencent.mm.plugin.downloader.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20150202", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class FileDownloadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            String action = intent.getAction();
            w.i("MicroMsg.FileDownloadReceiver", action);
            if (bg.mA(action)) {
                w.e("MicroMsg.FileDownloadReceiver", "action is null or nill, ignore");
            } else {
                action.equals("android.intent.action.DOWNLOAD_COMPLETE");
            }
        }
    }
}

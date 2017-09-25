package com.tencent.mm.plugin.downloader.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.e.a.pu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;

public class FileDownloadNotificationClickReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        w.i("MicroMsg.FileDownloadNotificationClickReceiver", "onReceive");
        String bk = bg.bk(context);
        w.i("MicroMsg.FileDownloadNotificationClickReceiver", "topActivityName = " + bk);
        Bundle extras = intent.getExtras();
        if (bg.mz(bk).equals("com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI")) {
            b puVar = new pu();
            puVar.fWR.bundle = extras;
            a.urY.m(puVar);
            return;
        }
        Intent intent2 = new Intent(context, FileDownloadConfirmUI.class);
        intent2.putExtras(extras);
        intent2.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startActivity(intent2);
    }
}

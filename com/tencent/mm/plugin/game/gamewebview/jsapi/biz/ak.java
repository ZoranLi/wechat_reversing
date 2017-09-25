package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import org.json.JSONObject;

public final class ak extends a {
    public static final int CTRL_BYTE = 240;
    public static final String NAME = "resumeDownloadTask";
    private long fCw;
    private int scene;

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        w.i("MicroMsg.GameJsApiResumeDownloadTask", "GameJsApiResumeDownloadTask");
        Context azK = dVar.azK();
        this.fCw = jSONObject.optLong("download_id");
        this.scene = jSONObject.optInt("scene", 1000);
        if (this.fCw <= 0) {
            w.e("MicroMsg.GameJsApiResumeDownloadTask", "fail, invalid downloadId = " + this.fCw);
            dVar.x(i, a.d("resume_download_task:fail_invalid_downloadid", null));
        } else if (am.isWifi(azK)) {
            b(dVar, i);
        } else {
            g.a(azK, azK.getString(R.l.flW), azK.getString(R.l.flX), azK.getString(R.l.flR), azK.getString(R.l.dGs), false, new OnClickListener(this) {
                final /* synthetic */ ak mkP;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.mkP.b(dVar, i);
                    dialogInterface.dismiss();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ ak mkP;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    d dVar = dVar;
                    int i2 = i;
                    ak akVar = this.mkP;
                    dVar.x(i2, a.d("add_download_task:fail_network_not_wifi", null));
                }
            }, R.e.aWu);
        }
    }

    public final void b(d dVar, int i) {
        GWMainProcessTask doDownloadTask = new DoDownloadTask();
        doDownloadTask.type = 3;
        doDownloadTask.fCw = this.fCw;
        doDownloadTask.scene = this.scene;
        GameWebViewMainProcessService.b(doDownloadTask);
        if (doDownloadTask.fFj) {
            dVar.x(i, a.d("resume_download_task:ok", null));
        } else {
            dVar.x(i, a.d("resume_download_task:fail", null));
        }
    }
}

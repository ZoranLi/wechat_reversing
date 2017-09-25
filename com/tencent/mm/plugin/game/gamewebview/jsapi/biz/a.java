package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.game.gamewebview.jsapi.a {
    public static final int CTRL_BYTE = 269;
    public static final String NAME = "addDownloadTaskStraight";

    public final void a(final d dVar, final JSONObject jSONObject, final int i) {
        w.i("MicroMsg.GameJsApiAddDownloadTaskStraight", "invoke");
        Context azK = dVar.azK();
        String optString = jSONObject.optString("task_url");
        long optLong = jSONObject.optLong("task_size");
        if (bg.mA(optString)) {
            w.e("MicroMsg.GameJsApiAddDownloadTaskStraight", "url is null");
            dVar.x(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.d("add_download_task:fail", null));
        } else if (!am.isNetworkConnected(dVar.getContext())) {
            dVar.x(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.d("add_download_task:fail_network_not_connected", null));
            com.tencent.mm.plugin.game.gamewebview.a.d.runOnUiThread(new Runnable(this) {
                final /* synthetic */ a mka;

                public final void run() {
                    Toast.makeText(dVar.getContext(), dVar.getContext().getString(R.l.eoG), 0).show();
                }
            });
            w.i("MicroMsg.GameJsApiAddDownloadTaskStraight", " fail, network not ready");
        } else if (!f.rZ()) {
            dVar.x(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.d("add_download_task:fail_sdcard_not_ready", null));
            com.tencent.mm.plugin.game.gamewebview.a.d.runOnUiThread(new Runnable(this) {
                final /* synthetic */ a mka;

                public final void run() {
                    Toast.makeText(dVar.getContext(), dVar.getContext().getString(R.l.eoI), 0).show();
                }
            });
            w.i("MicroMsg.GameJsApiAddDownloadTaskStraight", " fail, sdcard not ready");
        } else if (optLong > 0 && !f.G(optLong)) {
            dVar.x(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.d("add_download_task:fail_has_not_enough_space", null));
            com.tencent.mm.plugin.game.gamewebview.a.d.runOnUiThread(new Runnable(this) {
                final /* synthetic */ a mka;

                public final void run() {
                    Toast.makeText(dVar.getContext(), dVar.getContext().getString(R.l.eoH), 0).show();
                }
            });
            w.i("MicroMsg.GameJsApiAddDownloadTaskStraight", "fail, not enough space, require size = " + optLong);
        } else if (am.isWifi(azK)) {
            b(dVar, jSONObject, i);
        } else {
            g.a(azK, azK.getString(R.l.flW), azK.getString(R.l.flX), azK.getString(R.l.flR), azK.getString(R.l.dGs), false, new OnClickListener(this) {
                final /* synthetic */ a mka;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.mka.b(dVar, jSONObject, i);
                    dialogInterface.dismiss();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ a mka;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    d dVar = dVar;
                    int i2 = i;
                    a aVar = this.mka;
                    dVar.x(i2, com.tencent.mm.plugin.game.gamewebview.jsapi.a.d("add_download_task:fail_network_not_wifi", null));
                }
            }, R.e.aWu);
        }
    }

    public final void b(d dVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("task_name");
        String optString2 = jSONObject.optString("task_url");
        String optString3 = jSONObject.optString("alternative_url");
        long optLong = jSONObject.optLong("task_size");
        String optString4 = jSONObject.optString("file_md5");
        String optString5 = jSONObject.optString("extInfo");
        String optString6 = jSONObject.optString("fileType");
        String optString7 = jSONObject.optString("appid");
        String optString8 = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
        int optInt = jSONObject.optInt("scene", 1000);
        GWMainProcessTask doDownloadTask = new DoDownloadTask();
        doDownloadTask.type = 1;
        doDownloadTask.mjV = optString;
        doDownloadTask.url = optString2;
        doDownloadTask.mjW = optString3;
        doDownloadTask.fFW = optString4;
        doDownloadTask.extInfo = optString5;
        doDownloadTask.mjX = optString6;
        doDownloadTask.appId = optString7;
        doDownloadTask.packageName = optString8;
        doDownloadTask.mjY = optLong;
        doDownloadTask.scene = optInt;
        GameWebViewMainProcessService.b(doDownloadTask);
        if (doDownloadTask.fCw <= 0) {
            w.e("MicroMsg.GameJsApiAddDownloadTaskStraight", "fail, downloadId = " + doDownloadTask.fCw);
            dVar.x(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.d("add_download_task:fail", null));
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put("download_id", Long.valueOf(doDownloadTask.fCw));
        dVar.x(i, com.tencent.mm.plugin.game.gamewebview.jsapi.a.d("add_download_task:ok", hashMap));
    }
}

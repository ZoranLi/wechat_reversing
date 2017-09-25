package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Bundle;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.game.gamewebview.b.a.b;
import com.tencent.mm.plugin.game.gamewebview.b.a.c;
import com.tencent.mm.sdk.platformtools.w;

public final class e implements m {
    public final void onTaskStarted(long j, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", c.NAME);
        bundle.putString("state", "download_start");
        a ba = d.ba(j);
        bundle.putString("appid", ba != null ? ba.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.x(bundle);
    }

    public final void c(long j, String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", c.NAME);
        bundle.putString("state", "download_succ");
        a ba = d.ba(j);
        bundle.putString("appid", ba != null ? ba.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.x(bundle);
    }

    public final void d(long j, int i, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", c.NAME);
        bundle.putString("state", "download_fail");
        bundle.putInt("err_code", i);
        a ba = d.ba(j);
        bundle.putString("appid", ba != null ? ba.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.x(bundle);
    }

    public final void onTaskRemoved(long j) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", c.NAME);
        bundle.putString("state", "download_removed");
        a ba = d.ba(j);
        bundle.putString("appid", ba != null ? ba.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.x(bundle);
    }

    public final void onTaskPaused(long j) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", c.NAME);
        bundle.putString("state", "download_pause");
        a ba = d.ba(j);
        bundle.putString("appid", ba != null ? ba.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.x(bundle);
    }

    public final void bg(long j) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", b.NAME);
        a ba = d.ba(j);
        if (ba == null || ba.field_totalSize == 0) {
            w.w("MicroMsg.GameWebViewDownloadEventBus", "loadDownloadProgress failed, downloadId = " + j);
            return;
        }
        bundle.putInt("progress", (int) ((((double) ba.field_downloadedSize) / ((double) ba.field_totalSize)) * 100.0d));
        bundle.putString("appid", ba.field_appId);
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.x(bundle);
    }

    public final void j(long j, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("mm_to_client_notify_type", 1);
        bundle.putString("js_event_name", c.NAME);
        bundle.putString("state", "download_resumed");
        a ba = d.ba(j);
        bundle.putString("appid", ba != null ? ba.field_appId : "");
        bundle.putLong("download_id", j);
        com.tencent.mm.plugin.game.gamewebview.ipc.a.x(bundle);
    }
}

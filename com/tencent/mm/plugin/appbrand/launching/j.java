package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.wcdb.database.SQLiteDatabase;

class j implements a {
    final String appId;
    final int fFR = (j.class.hashCode() & 65535);

    void onReady() {
    }

    void US() {
    }

    void UT() {
        d.b(ab.getContext(), "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", n.N(this.appId, 2)).putExtra("showShare", false).putExtra("show_bottom", false).putExtra("isWebwx", false).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
        g.oUh.a(366, 8, 1, false);
    }

    j(String str) {
        this.appId = str;
    }

    final void Va() {
        if (com.tencent.mm.compatible.util.d.eo(17)) {
            onReady();
        } else {
            UT();
        }
    }

    public final void a(int i, int i2, Intent intent) {
        if (this.fFR == i) {
            if (i2 == -1) {
                w.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs download ok");
                onReady();
            } else if (i2 == 2) {
                w.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs cancel loading, download in background");
                US();
            } else {
                w.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "onActivityResult, tbs download unknown error, resultCode = %d, apiLevel = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(VERSION.SDK_INT)});
                Va();
            }
        }
    }
}

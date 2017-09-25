package com.tencent.mm.plugin.welab.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.as.d;
import com.tencent.mm.as.i;
import com.tencent.mm.as.j;
import com.tencent.mm.e.a.kh;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

public final class a implements b {
    public final void c(Activity activity, String str) {
        if (d.Ii()) {
            String optString = j.kb("discoverRecommendEntry").optString("wording");
            if (bg.mA(optString)) {
                w.e("MicroMsg.FTS.LookOneLookOpener", "empty query");
                return;
            }
            Intent Il = d.Il();
            Il.putExtra("ftsbizscene", 21);
            Il.putExtra("ftsQuery", optString);
            Il.putExtra("title", optString);
            Il.putExtra("isWebwx", optString);
            Il.putExtra("ftscaneditable", false);
            Map a = d.a(21, false, 2);
            a.put("query", optString);
            a.put("sceneActionType", "2");
            Il.putExtra("rawUrl", d.m(a));
            com.tencent.mm.sdk.b.b khVar = new kh();
            khVar.fQJ.scene = 0;
            com.tencent.mm.sdk.b.a.urY.m(khVar);
            com.tencent.mm.bb.d.b(activity, "webview", ".ui.tools.fts.FTSWebViewUI", Il);
            i.q(21, optString);
            return;
        }
        w.e("MicroMsg.FTS.LookOneLookOpener", "fts h5 template not avail");
    }

    public final String bAN() {
        return j.kb("discoverRecommendEntry").optString("labIcon");
    }

    public final String bAO() {
        String optString = j.kb("discoverRecommendEntry").optString("wording");
        if (bg.mA(optString)) {
            return ab.getContext().getString(R.l.eki);
        }
        return optString;
    }
}

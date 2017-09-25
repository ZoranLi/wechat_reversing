package com.tencent.mm.plugin.welab.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.as.d;
import com.tencent.mm.as.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

public final class b implements com.tencent.mm.plugin.welab.a.a.b {
    public final void c(Activity activity, String str) {
        if (d.Ii()) {
            Intent Il = d.Il();
            Il.putExtra("ftsbizscene", 20);
            Map a = d.a(20, true, 0);
            Il.putExtra("ftsneedkeyboard", true);
            Il.putExtra("rawUrl", d.m(a));
            com.tencent.mm.bb.d.b(activity, "webview", ".ui.tools.fts.FTSSearchOneSearchWebViewUI", Il);
            return;
        }
        w.e("MicroMsg.FTS.SearchOneSearchOpener", "fts h5 template not avail");
    }

    public final String bAN() {
        return j.kb("discoverSearchEntry").optString("labIcon");
    }

    public final String bAO() {
        String optString = j.kb("discoverSearchEntry").optString("wording");
        if (bg.mA(optString)) {
            return ab.getContext().getString(R.l.eki);
        }
        return optString;
    }
}
